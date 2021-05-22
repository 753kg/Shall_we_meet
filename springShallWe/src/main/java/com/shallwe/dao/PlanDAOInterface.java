package com.shallwe.dao;

import java.util.List;

import com.shallwe.model.PlanVO;

public interface PlanDAOInterface {
	
	public int insertPlan(String plan_id, String plan_name, String host_id, int numbers);
	public List<PlanVO> selectPlanByMemberId(String memberid);
	public int updateHotplace(String plan_id, String hotplace_name);
}
