package com.shallwe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shallwe.model.PlanVO;

@Repository
public class PlanDAO implements PlanDAOInterface{
	
	@Autowired
	SqlSession sqlsession;
	
	String namespace="com.shallwe.plan.";

	@Override
	public int insertPlan(String plan_id, String plan_name, String host_id, int numbers) {
		Map<String, Object> map = new HashMap<>();
		map.put("plan_id", plan_id);
		map.put("plan_name", plan_name);
		map.put("host_id", host_id);
		map.put("numbers", numbers);
		return sqlsession.insert(namespace + "insertPlan", map);
	}

	@Override
	public List<PlanVO> selectPlanByMemberId(String memberid) {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace + "selectPlanByMemberId", memberid);
	}

	@Override
	public int updateHotplace(String plan_id, String hotplace_name) {
		Map<String, String> map = new HashMap<>();
		map.put("plan_id", plan_id);
		map.put("hotplace_name", hotplace_name);
		return sqlsession.update(namespace + "updateHotplace", map);
	}
	
}
