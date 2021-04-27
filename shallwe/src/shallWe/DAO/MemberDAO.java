package shallWe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shallWe.Util.DBUtil;
import shallWe.VO.MemberVO;

public class MemberDAO {
	
	// 회원가입
	public int insertMember(MemberVO m) {
		int result = 0;
		String sql = "insert into members values(?, ?, ?, ?, ?, ?)";
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, m.getMember_id());
			st.setString(2, m.getPassword());
			st.setString(3, m.getName());
			st.setString(4, m.getEmail());
			st.setString(5, m.getPhone_number());
			st.setString(6, m.getSecurity());
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

	// 로그인체크
	public MemberVO loginChk(String memberid, String memberpw) {
		MemberVO m = null;
		String sql = " select * from members where member_id = ? and password = ? ";

		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, memberid);
			st.setString(2, memberpw);
			rs = st.executeQuery();
			while (rs.next()) {
				m = makeMember(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}

		return m;
	}

	public MemberVO makeMember(ResultSet rs) throws SQLException {
		MemberVO m = new MemberVO();
		m.setMember_id(rs.getString("member_id"));
		m.setPassword(rs.getString("password"));
		m.setName(rs.getString("name"));
		m.setEmail(rs.getString("email"));
		m.setPhone_number(rs.getString("phone_number"));
		m.setSecurity(rs.getString("security"));
		return m;
	}
}
