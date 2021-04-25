package shallWe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shallWe.VO.ActivityVO;

public class ActivityDAO {
	// Activity 조회
	public List<ActivityVO> selectActivityByLocationName(String location_name) {
		List<ActivityVO> alist = new ArrayList<>();
		String sql = "select * from activities where location_name = ?";

		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, location_name);
			st.executeQuery();
			while (rs.next()) {
				alist.add(makeActivity(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}

		return alist;
	}

	public ActivityVO makeActivity(ResultSet rs) throws SQLException {
		ActivityVO a = new ActivityVO();
		a.setActivity_name(rs.getString("activity_name"));
		a.setMain_activity(rs.getString("main_activity"));
		a.setLocation_name(rs.getString("location_name"));
		a.setActivity_id(rs.getInt("activity_id"));
		return a;
	}
}
