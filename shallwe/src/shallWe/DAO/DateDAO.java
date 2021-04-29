package shallWe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shallWe.Util.DBUtil;
import shallWe.VO.DateOptionVO;
import shallWe.VO.DateVO;
import shallWe.VO.MemberPlanVO;
import shallWe.VO.PlanVO;

public class DateDAO {
	
	//방장 - 약속만들기 - 날짜
	//memberplans 테이블에서 memberid, planid 가져오기	
	
	public List<MemberPlanVO> selectMemIdplanId(String planid){
		List<MemberPlanVO> mlist = new ArrayList<MemberPlanVO>();
		String sql = "select MEMBER_ID, PLAN_ID"
				+ " from members_plans "
				+ " where plan_id = ?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, planid);
			rs = st.executeQuery();
			
			while(rs.next()) {
				mlist.add(new MemberPlanVO(rs.getString(1),
						rs.getInt(2), rs.getDouble(3),
						rs.getDouble(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return mlist;
	}
	
	//방장
	//방장의 날짜 범위를 저장한다. (servlet에서 반복시켜야 한다.)
	public int insertMasterDate (String planid, String hostdate) {
		int result = 0;
		String sql = " insert into date_options (plan_id, host_date) "
				+ " values ( ? , ?) ";
				
		Connection conn;
		PreparedStatement st = null;
		
		conn = DBUtil.getConnection();
	
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, planid);
			st.setString(2, hostdate);
			result = st.executeUpdate();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.dbClose(null, st, conn);
		}
		return result;
	}
	
	//멤버
	//멤버아이디 플랜아이디를 받아와서 dates에 날짜 삽입한다.
	public int updateMemberDates(String planid, String memberid, String memberdates) {
		String sql = "	insert into dates(member_id, plan_id, select_date) "
					+" values(?, ?, ?) ";
		int result = 0;

		Connection con = null;
		PreparedStatement ps = null;
		con = DBUtil.getConnection();

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memberid);
			ps.setString(2, planid);
			ps.setString(3, memberdates);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(null, ps, con);
		}
		return result;
	}
	
	//fix방장 
		//selectAllDates로 받아온 값을 보고 한가지 date를 fix한다.
	
 
	
		public int updateFixDate(String date , String planid, String hostid) {
			Connection con = null;
			PreparedStatement st = null;
						
			String sql = " update plans "
				+" set fixed_date =  '" + date + "'"
				+" where plan_id = '" + planid + "'"
				+" and host_id = '" + hostid+ "'";
			int result = 0;
		
			try {
				con = DBUtil.getConnection();
				st = con.prepareStatement(sql);
				result = st.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.dbClose(null, st, con);
			}
			return result;
		}
	//방장
		//방장이 선택한 dates들을 뿌려준다. for문반복 
		public List<DateOptionVO> selectHostDates(String planid){
			List<DateOptionVO> list = new ArrayList<DateOptionVO>();
			String sql = "select host_date "
					+ "from date_options "
					+ "where plan_id = ?";
			
			Connection conn = DBUtil.getConnection();
			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				st = conn.prepareStatement(sql);
				st.setString(1, planid);
				rs = st.executeQuery();
				
				while(rs.next()) {
					list.add(new DateOptionVO(planid, rs.getString(1)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.dbClose(rs, st, conn);
			}
			return list;
		}
	//fix방장
	//dates 테이블에서 planid사용하여 date(모두) 받아오기
	public List<DateVO> selectAllDates(String planid, String memberid){
		List<DateVO> dlist = new ArrayList<DateVO>();
		String sql = 
				" select distinct select_date "
			+   " from dates"
			+	" where plan_id = "+planid;
		
		Connection con = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				dlist.add(new DateVO(planid, memberid, rs.getString(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, st, con);
		}
		return dlist;
	}
	
	
}
