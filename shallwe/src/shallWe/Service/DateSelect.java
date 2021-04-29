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
		
		public int insertMasterDate (String planid, String hostdate) {
			return dao.insertMasterDate(planid, hostdate);
		}
		
		public int convertArrayInsertMaDate(String planid, String hostdates) {
			String[] sphostdates = hostdates.split(",");
			int result = 0;
			for(String s : sphostdates) {
				System.out.println(s);
				 result = dao.insertMasterDate(planid, s);
			}
			return result;
		}
		
		//플랜 아이디를 통해 MemberDAO에서 member_id와 plan_id를 받아온다.
		public  List<MemberPlanVO> selectAllMembers(String planid) throws SQLException{
			List<MemberPlanVO> list = dao.selectMemIdplanId(planid);
			if(list.size() == 0) 
				throw new SQLException("planId와 memberId를 받아올 수 없습니다.");
			return list;
		}
		
		public List<DateOptionVO> selectHostDates(String planid) throws SQLException{
			List<DateOptionVO> list = dao.selectHostDates(planid);
			if(list.size() == 0)
				throw new SQLException("날짜 범위 목록 error");
			return list;
		}
		
		public int updateMemberDates(String planid, String memberid, String memberdates) throws SQLException {
			String[] mdates = memberdates.split(",");
			int result = 0;
			for(String s : mdates) {
				String fs = s.replace("-", "/");
				System.out.println(fs);
				result = dao.updateMemberDates(planid, memberid, fs);
			}
			return result;
		}
		public int updateFixDate(String date , String planid, String hostid) throws SQLException {
			int result = dao.updateFixDate(date, planid, hostid);
			if(result == 0)
				throw new SQLException("최종 약속 날짜를 선택할 수 없습니다.");
			return result;
			
		}
		public List<DateVO> selectAllDates(String planid, String memberid) throws SQLException{
			List<DateVO> dlist = dao.selectAllDates(planid, memberid);
			if(dlist.size() == 0)
				throw new SQLException("date 목록 에러");
			return dlist;
		}
		
		
//		public static List<DateVO> list(int planid){
//			List<DateVO> dlist = dao.datesInsert(planid);
//			return dlist;
//		}
	}

