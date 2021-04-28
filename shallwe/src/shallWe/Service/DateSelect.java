package shallWe.Service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shallWe.DAO.DateDAO;
import shallWe.VO.DateOptionVO;
import shallWe.VO.DateVO;
import shallWe.VO.MemberPlanVO;
import shallWe.VO.PlanVO;

public class DateSelect {
		private  DateDAO dao = new DateDAO();
		
		public int convertArrayInsert(String planid, String hostdates) {
			String[] sphostdates = hostdates.split(",");
			int result = 0;
			for(String s : sphostdates) {
				System.out.println(s);
				 result = dao.insertMasterDate(planid, s);
			}
			return result;
		}
		
		//플랜 아이디를 통해 MemberDAO에서 member_id와 plan_id를 받아온다.
		public  List<MemberPlanVO> selectAllMembers(int planid) throws SQLException{
			List<MemberPlanVO> list = dao.selectMemIdplanId(planid);
			if(list.size() == 0) 
				throw new SQLException("planId와 memberId를 받아올 수 없습니다.");
			return list;
		}
		
	//	public int insertMasterDate(String hostdate, int planid) throws SQLException {
	//		int result = dao.insertMasterDate(hostdate, planid);
	//		if(result == 0)
	//			throw new SQLException("날짜 범위 지정 error");
	//		return result;
	//	}
		
		public List<DateOptionVO> selectHostDates(String planid) throws SQLException{
			List<DateOptionVO> list = dao.selectHostDates(planid);
			if(list.size() == 0)
				throw new SQLException("날짜 범위 목록 error");
			return list;
		}
		
		public int updateMemberDates(DateVO dateVo, int planid, String memberid) throws SQLException {
			int result = dao.updateMemberDates(dateVo, planid, memberid);
			if(result == 0)
				throw new SQLException("날짜 삽입 에러");
			return result;
		}
		
		public List<DateVO> selectAllDates(int planid) throws SQLException{
			List<DateVO> dlist = dao.selectAllDates(planid);
			if(dlist.size() == 0)
				throw new SQLException("date 목록 에러");
			return dlist;
		}
		
		public int updateFixDate(PlanVO vo , int planid) throws SQLException {
			int result = dao.updateFixDate(vo, planid);
			if(result == 0)
				throw new SQLException("최종 약속 날짜를 선택할 수 없습니다.");
			return result;
			
		}
//		public static List<DateVO> list(int planid){
//			List<DateVO> dlist = dao.datesInsert(planid);
//			return dlist;
//		}
		
		public int insertMasterDate (String planid, String hostdate) {
			return dao.insertMasterDate(planid, hostdate);
		}
	}

