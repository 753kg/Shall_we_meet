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
	public int insertMemberLocation(double lat,double lon) {
		int result =0;
		String sql = "insert into members_plans(lat,lon) values(?,?) ";
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs =null;
		
		try {
			st= conn.prepareStatement(sql);
			st.setDouble(1, lat);
			st.setDouble(2, lon);
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
	
}
