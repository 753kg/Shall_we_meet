package com.shallwe.service;

import java.util.List;

import com.shallwe.model.MakePlanVO;
import com.shallwe.model.PlanVO;

public interface PlanServiceInterface {
	
	//public int insertPlan(String plan_id, String plan_name, String host_id, int numbers);
	public void makePlan(MakePlanVO mpvo);
	public List<PlanVO> selectPlanByMemberId(String memberid);
	public int updateHotplace(String plan_id, String hotplace_name);

}
