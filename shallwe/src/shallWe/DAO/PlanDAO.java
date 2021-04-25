package shallWe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shallWe.Util.DBUtil;
import shallWe.VO.PlanVO;

public class PlanDAO {
	// 약속생성
	// 1. plan Insert
	// 2. members_plans Insert
	// 3. date_options Insert
	public int insertPlan(String plan_name, String host_id, int numbers) {
		int result = 0;
		String sql = " insert into plans(plan_id, plan_name, host_id, numbers)" + 
					" values(plans_seq.nextval, ?, ?, ?)";
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;

		// 학원가서 try-catch-finally 하기
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, plan_name);
			st.setString(2, host_id);
			st.setInt(3, numbers);
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

	// 약속조회
	public List<PlanVO> selectPlanByMemberId(String memberid) {
		List<PlanVO> plist = new ArrayList<>();
		String sql = 
				"select *" +
				" from plans" +
				" where plan_id in (select plan_id " +
									" from members_plans" +
									" where member_id = ?)";

		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, memberid);
			st.executeQuery();
			while (rs.next()) {
				plist.add(makePlan(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}

		return plist;
	}

	public PlanVO makePlan(ResultSet rs) throws SQLException {
		PlanVO p = new PlanVO();
		p.setPlan_id(rs.getInt("plan_id"));
		p.setFixed_date(rs.getDate("fixed_date"));
		p.setHotplace_name(rs.getString("hotplace_name"));
		p.setPlan_name(rs.getString("plan_name"));
		p.setHost_id(rs.getString("host_id"));
		p.setNumbers(rs.getInt("numbers"));
		return p;
	}
}
