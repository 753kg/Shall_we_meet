package shallWe.Service;

import java.util.List;

import shallWe.DAO.DateDAO;
import shallWe.VO.DateVO;
import shallWe.VO.MemberPlanVO;

public class DateService {
	private static DateDAO dao = new DateDAO();
	
	public static List<MemberPlanVO> selectAllMembers(int planid){
		List<MemberPlanVO> list = dao.selectAllMembers(planid);
		return list;
	}
	
//	public static List<DateVO> list(int planid){
//		List<DateVO> dlist = dao.datesInsert(planid);
//		return dlist;
//	}
}
