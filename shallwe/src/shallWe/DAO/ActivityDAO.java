package shallWe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shallWe.Util.DBUtil;
import shallWe.VO.ActivityVO;
import shallWe.VO.CafeVO;
import shallWe.VO.RestaurantVO;

public class ActivityDAO {
	
	// Restaurant 조회
	public List<RestaurantVO> selectRestaurantByLocationName(String location_name) {
		List<RestaurantVO> rlist = new ArrayList<>();
		String sql = "select * from restaurants where location_name = ?";

		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, location_name);
			rs = st.executeQuery();
			while (rs.next()) {
				rlist.add(makeRestaurant(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}

		return rlist;
	}
	
	// cafe 조회
	public List<CafeVO> selectCafeByLocationName(String location_name) {
		List<CafeVO> clist = new ArrayList<>();
		String sql = "select * from cafes where location_name = ?";

		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, location_name);
			rs = st.executeQuery();
			while (rs.next()) {
				clist.add(makeCafe(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}

		return clist;
	}


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
			rs = st.executeQuery();
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
	
	private RestaurantVO makeRestaurant(ResultSet rs) throws SQLException {
		RestaurantVO r = new RestaurantVO();
		r.setRestaurant_name(rs.getString("restaurant_name"));
		r.setLocation_name(rs.getString("location_name"));
		r.setFull_address(rs.getString("full_address"));
		r.setMain_food(rs.getString("main_food"));
		r.setLikes(rs.getInt("likes"));
		r.setImage(rs.getString("image"));
		r.setRestaurant_id(rs.getInt("restaurant_id"));
		return r;
	}

	private CafeVO makeCafe(ResultSet rs) throws SQLException {
		CafeVO c = new CafeVO();
		c.setCafe_name(rs.getString("cafe_name"));
		c.setLocation_name(rs.getString("location_name"));
		c.setFull_address(rs.getString("full_address"));
		c.setMain_food(rs.getString("main_food"));
		c.setLikes(rs.getInt("likes"));
		c.setImage(rs.getString("image"));
		c.setCafe_id(rs.getInt("cafe_id"));
		return c;
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
