package shallWe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import shallWe.VO.DateVO;
import shallWe.VO.MemberPlanVO;

public class DateDAO {
	
	//memberplans 테이블에서 memberid, planid 가져오기	
	public List<MemberPlanVO> selectAllMembers(int planid){
		List<MemberPlanVO> mlist = new ArrayList<MemberPlanVO>();
		String sql = "select MEMBER_ID, PLAN_ID"
				+ " from members_plans "
				+ " where plan_id = ?";
		Connection conn = DbUtil.getConnection();
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
	
	//멤버의 아이디, 플랜아이디, 날짜 삽입
	public int datesInsert(DateVO dateVo, int planid) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into dates values(?, ?, ?) ";
		
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dateVo.getMember_id());
			ps.setInt(2, dateVo.getPlan_id());
			ps.setDate(2, dateVo.getSelect_date());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(null, ps, con);
		}
		return result;
	}
	//dates 테이블에서 planid사용하여 memberid, date(모두) 받아오기
	public List<DateVO> selectAllDates(String planid){
		List<DateVO> dlist = new ArrayList<DateVO>();
		String sql = 
				"select * from dates where plan_id = "+planid;
		
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
}
