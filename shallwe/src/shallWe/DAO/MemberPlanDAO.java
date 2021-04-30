package shallWe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shallWe.Util.DBUtil;
import shallWe.VO.MemberPlanVO;

public class MemberPlanDAO {

	// 각 멤버의 lat,lon 넣기
	public int updateMemberLocation(String member_id, String plan_id, double lat, double lon) {
		int result = 0;
		String sql = "update members_plans set lat = ?, lon = ?" + " where member_id = ? and plan_id = ?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(sql);
			st.setDouble(1, lat);
			st.setDouble(2, lon);
			st.setString(3, member_id);
			st.setString(4, plan_id);
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	// 그룹 멤버들의 lat,lon select
	public List<MemberPlanVO> selectLocationByGroup(String plan_id) {
		
		List<MemberPlanVO> mlist = new ArrayList<MemberPlanVO>();
		String sql = "select member_id,lat,lon "
				+ " from members_plans "
				+ " where plan_id = ?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, plan_id);
			rs= st.executeQuery();
			while(rs.next()) {
				mlist.add(makeMembers_plans(plan_id,rs));
			}
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(null, st, conn);
		}

		return mlist;
	}

	private MemberPlanVO makeMembers_plans(String plan_id,ResultSet rs) throws SQLException {
		MemberPlanVO memberplanVO = new MemberPlanVO();
		memberplanVO.setPlan_id(plan_id);
		memberplanVO.setMember_id(rs.getString("member_id"));
		memberplanVO.setLat(rs.getDouble("lat"));
		memberplanVO.setLon(rs.getDouble("lon"));
		return memberplanVO;
	}

	// 호스트의 경우 위치도 다 삽입 , 호스트가 아닌경우 위도 경도는 0 삽입

	public int insertMemberPlan(String plan_id, String member_id, double lat, double lon) {
		int result = 0;
		String sql = " insert into members_plans(plan_id, member_id, lat, lon)" + " values(?, ?, ?, ?)";
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, plan_id);
			st.setString(2, member_id);
			st.setDouble(3, lat);
			st.setDouble(4, lon);
			result = st.executeUpdate();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(null, st, conn);
		}

		return result;

	}

}
