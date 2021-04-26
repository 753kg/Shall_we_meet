package shallWe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shallWe.Util.DBUtil;
import shallWe.VO.HotplaceVO;
import shallWe.VO.MemberVO;

public class HotplaceDAO {

	

	// 각 핫플레이스의 lat,lon select
	public HotplaceVO selectHotplaceLocation(String hotplaceName) {
		
		HotplaceVO hotplace = new HotplaceVO();
		String sql = "select lat,lon from hotplaces "
				+ "where hotplace_name = ? ";
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs =null;
		
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

	

	// 가장 가까운 핫플레이스 이름 select
	
	
	//makehotplace
	private HotplaceVO makeHotplace(ResultSet rs) throws SQLException {
		HotplaceVO hotplace = new HotplaceVO();
		hotplace.setHotplace_name(rs.getString("hotplace_name"));
		hotplace.setLat(rs.getDouble("lat"));
		hotplace.setLon(rs.getDouble("lon"));
		return hotplace;
	}
	
}
