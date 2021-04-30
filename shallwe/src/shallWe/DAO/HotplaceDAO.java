package shallWe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shallWe.Util.DBUtil;
import shallWe.VO.HotplaceVO;
import shallWe.VO.MemberVO;

public class HotplaceDAO {

	//모든 핫플레이스 목록 Select
	public List<HotplaceVO> selectHotplaceLocation() {
		List<HotplaceVO> hotplaces = new ArrayList<HotplaceVO>();
		String sql = "select * from hotplaces";
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				hotplaces.add(makeHotplace(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hotplaces;
	}

	// 각 핫플레이스의 lat,lon select
	public HotplaceVO selectHotplaceLocationByName(String hotplaceName) {

		HotplaceVO hotplace = new HotplaceVO();
		String sql = "select * from hotplaces " + "where hotplace_name = ? ";
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, hotplaceName);
			rs = st.executeQuery();
			while (rs.next()) {
				hotplace = makeHotplace(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hotplace;
	}

	// makehotplace
	private HotplaceVO makeHotplace(ResultSet rs) throws SQLException {
		HotplaceVO hotplace = new HotplaceVO();
		hotplace.setHotplace_name(rs.getString("hotplace_name"));
		hotplace.setLat(rs.getDouble("lat"));
		hotplace.setLon(rs.getDouble("lon"));
		return hotplace;
	}

}
