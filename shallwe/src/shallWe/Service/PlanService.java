package shallWe.Service;

import java.util.List;

import shallWe.DAO.PlanDAO;
import shallWe.VO.PlanVO;

public class PlanService {
	
	PlanDAO dao = new PlanDAO();
	
	public int insertPlan(String plan_id, String plan_name, String host_id, int numbers) {
		return dao.insertPlan(plan_id, plan_name, host_id, numbers);
	}
	
	public List<PlanVO> selectPlanByMemberId(String memberid) {
		return dao.selectPlanByMemberId(memberid);
	}

}
