package shallWe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import shallWe.Util.DBUtil;
import shallWe.VO.MemberPlanVO;

public class MemberPlanDAO {

	//각 멤버의 lat,lon insert
	public int updateMemberLocation(String member_id, String plan_id,double lat,double lon) {
		int result =0;
		String sql = "update set lat = ?, lon = ?"
				+ " where member_id = ? and plan_id = ?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs =null;
		
		try {
			st= conn.prepareStatement(sql);
			st.setDouble(1, lat);
			st.setDouble(2, lon);
			st.setString(3, member_id);
			st.setString(4, plan_id);
			st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	//그룹 멤버들의 lat,lon select
	public List<MemberPlanVO> selectLocationByGroup(){
		return null;
	}
	
	//호스트의 경우 위치도 다 삽입 , 호스트가 아닌경우 위도 경도는 0 삽입
	public int insertMemberToMemberPlan(String member_id, String plan_id, double lat, double lon) {
		
		return 0;
	}
	
	
}
