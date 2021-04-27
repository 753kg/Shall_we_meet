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
	
	public List<MemberPlanVO> selectMemIdplanId(int planid){
		List<MemberPlanVO> mlist = new ArrayList<MemberPlanVO>();
		String sql = "select MEMBER_ID, PLAN_ID"
				+ " from members_plans "
				+ " where plan_id = ?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, planid);
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
	//방장의 날짜 범위를 저장한다. (jsp에서 5번까지 반복시켜야 한다.)
	public int updateMasterDate (DateOptionVO vo, int planid) {
		int result = 0;
		String sql = " update date_options "
				+ " set host_date = ?"
				+ " where plan_id = ?";
				
		Connection conn;
		PreparedStatement st = null;
		conn = DBUtil.getConnection();
	
		try {
			st = conn.prepareStatement(sql);
			st.setDate(1, vo.getHost_date());
			st.setInt(2, planid);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.dbClose(null, st, conn);
		}
		return result;
	}
	
	//방장
	//방장이 선택한 dates들을 뿌려준다. for문반복 5회
	public List<DateOptionVO> selectHostDates(int planid){
		List<DateOptionVO> list = new ArrayList<DateOptionVO>();
		String sql = "select host_date "
				+ "from date_options "
				+ "where plan_id = "+planid;
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				list.add(new DateOptionVO(planid, rs.getDate(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return list;
	}
	
	//멤버
	//멤버아이디 플랜아이디를 받아와서 dates에 날짜 삽입한다.
	public int updateMemberDates(DateVO dateVo, int planid, String memberid) {
		String sql = "update dates"
				+ " set select_date = ?"
				+ " where plan_id = "+planid+" and member_id = "+memberid;
		
		int result = 0;

		Connection con = null;
		PreparedStatement ps = null;
		con = DBUtil.getConnection();

		try {
			ps = con.prepareStatement(sql);
			ps.setDate(1, dateVo.getSelect_date());
			ps.setInt(2, planid);
			ps.setString(3, memberid);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(null, ps, con);
		}
		return result;
	}
	
	//fix방장
	//dates 테이블에서 planid사용하여 date(모두) 받아오기
	public List<DateVO> selectAllDates(int planid){
		List<DateVO> dlist = new ArrayList<DateVO>();
		String sql = 
				" select distinct select_date "
			+   " from dates"
			+	" where plan_id = "+planid;
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		con = DBUtil.getConnection();
		
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				dlist.add(new DateVO(rs.getString(1),
						rs.getInt(2), rs.getDate(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, st, con);
		}
		return dlist;
	}
	
	//fix방장
	//selectAllDates로 받아온 값을 보고 한가지 date를 fix한다.
	public int updateFixDate(PlanVO vo , int planid) {
		Connection con = null;
		PreparedStatement st = null;
		
		int result = 0;
		String sql = " update plans"
				+ " set fixed_date = ?"
				+ " where plan_id = ?";
		
		try {
			con = DBUtil.getConnection();
			st = con.prepareStatement(sql);
			st.setDate(1, vo.getFixed_date());
			st.setInt(2, planid);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(null, st, con);
		}
		return result;
	}
}
