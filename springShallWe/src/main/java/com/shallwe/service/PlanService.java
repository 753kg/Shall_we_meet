package com.shallwe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shallwe.dao.DateDAO;
import com.shallwe.dao.MemberPlanDAO;
import com.shallwe.dao.PlanDAOInterface;
import com.shallwe.model.MakePlanVO;
import com.shallwe.model.PlanVO;

@Service
@Transactional
public class PlanService implements PlanServiceInterface{
	
	@Autowired
	PlanDAOInterface pdao;
	
	@Autowired
	MemberPlanDAO mpdao;
	
	@Autowired
	DateDAO datedao;
	
	public List<PlanVO> selectPlanByMemberId(String memberid) {
		return pdao.selectPlanByMemberId(memberid);
	}

	public int updateHotplace(String plan_id, String hotplace_name) {
		return pdao.updateHotplace(plan_id, hotplace_name);
	}
	
	@Override
	public void makePlan(MakePlanVO mpvo) {
		// 데이터 정리
		// plan
		String host_id = mpvo.getHost_id();
		String plan_name = mpvo.getPlan_name();
		int numbers = Integer.parseInt(mpvo.getMembercount());
		String plan_id = host_id + System.currentTimeMillis();
		// host -> members_plans
		String host_place = mpvo.getHost_place();
		String lat = mpvo.getHost_lat();
		String lon = mpvo.getHost_lon();
		double host_lat = Double.parseDouble(lat.equals("")?"0.0":lat);
		double host_lon = Double.parseDouble(lon.equals("")?"0.0":lon);
		// host_dates -> date_options
		String[] host_dates = mpvo.getHost_dates().split(",");
		// friend -> members_plans
		List<String> friendlist = mpvo.getFriendlist();
		
		// insert 시작
		// plan
		pdao.insertPlan(plan_id, plan_name, host_id, numbers);
		// host -> members_plans
		mpdao.insertMemberPlan(plan_id, host_id, host_lat, host_lon);
		// host_dates -> date_options
		if(!host_dates[0].equals("")) {
			for(String date : host_dates) {
				datedao.insertMasterDate(plan_id, date);
			}
		}
		// friend -> members_plans
		for(String friend : friendlist) {
			mpdao.insertMemberPlan(plan_id, friend, 0.0, 0.0);
		}
		
		
	}
}
