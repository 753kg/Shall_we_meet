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
		
		//�뵆�옖 �븘�씠�뵒瑜� �넻�빐 MemberDAO�뿉�꽌 member_id�� plan_id瑜� 諛쏆븘�삩�떎.
		public  List<MemberPlanVO> selectAllMembers(String planid) throws SQLException{
			List<MemberPlanVO> list = dao.selectMemIdplanId(planid);
			if(list.size() == 0) 
				throw new SQLException("planId�� memberId瑜� 諛쏆븘�삱 �닔 �뾾�뒿�땲�떎.");
			return list;
		}
		
		public List<DateOptionVO> selectHostDates(String planid) throws SQLException{
			List<DateOptionVO> list = dao.selectHostDates(planid);
			if(list.size() == 0)
				throw new SQLException("�궇吏� 踰붿쐞 紐⑸줉 error");
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
		public int updateFixDate(String date , String planid) throws SQLException {
			int result = dao.updateFixDate(date, planid);
			if(result == 0)
				throw new SQLException("理쒖쥌 �빟�냽 �궇吏쒕�� �꽑�깮�븷 �닔 �뾾�뒿�땲�떎.");
			return result;
			
		}
		public List<DateVO> selectAllDates(String planid) throws SQLException{
			List<DateVO> dlist = dao.selectAllDates(planid);
			if(dlist.size() == 0)
				throw new SQLException("date 紐⑸줉 �뿉�윭");
			return dlist;
		}
		
		
//		public static List<DateVO> list(int planid){
//			List<DateVO> dlist = dao.datesInsert(planid);
//			return dlist;
//		}
	}

