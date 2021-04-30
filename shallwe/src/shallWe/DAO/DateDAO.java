package shallWe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shallWe.Util.DBUtil;
import shallWe.VO.DateOptionVO;
import shallWe.VO.DateVO;
import shallWe.VO.MemberPlanVO;
import shallWe.VO.PlanVO;

public class DateDAO {
	
	//諛⑹옣 - �빟�냽留뚮뱾湲� - �궇吏�
	//memberplans �뀒�씠釉붿뿉�꽌 memberid, planid 媛��졇�삤湲�	
	
	public List<MemberPlanVO> selectMemIdplanId(String planid){
		List<MemberPlanVO> mlist = new ArrayList<MemberPlanVO>();
		String sql = "select MEMBER_ID, PLAN_ID"
				+ " from members_plans "
				+ " where plan_id = ?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, planid);
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
	
	//諛⑹옣
	//諛⑹옣�쓽 �궇吏� 踰붿쐞瑜� ���옣�븳�떎. (servlet�뿉�꽌 諛섎났�떆耳쒖빞 �븳�떎.)
	public int insertMasterDate (String planid, String hostdate) {
		int result = 0;
		String sql = " insert into date_options (plan_id, host_date) "
				+ " values ( ? , ?) ";
				
		Connection conn;
		PreparedStatement st = null;
		
		conn = DBUtil.getConnection();
	
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, planid);
			st.setString(2, hostdate);
			result = st.executeUpdate();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.dbClose(null, st, conn);
		}
		return result;
	}
	
	//硫ㅻ쾭
	//硫ㅻ쾭�븘�씠�뵒 �뵆�옖�븘�씠�뵒瑜� 諛쏆븘���꽌 dates�뿉 �궇吏� �궫�엯�븳�떎.
	public int updateMemberDates(String planid, String memberid, String memberdates) {
		String sql = "	insert into dates(member_id, plan_id, select_date) "
					+" values(?, ?, ?) ";
		int result = 0;

		Connection con = null;
		PreparedStatement ps = null;
		con = DBUtil.getConnection();

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memberid);
			ps.setString(2, planid);
			ps.setString(3, memberdates);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(null, ps, con);
		}
		return result;
	}
	
	//fix諛⑹옣 
		//selectAllDates濡� 諛쏆븘�삩 媛믪쓣 蹂닿퀬 �븳媛�吏� date瑜� fix�븳�떎.
	
 
	
		public int updateFixDate(String date , String planid) {
			Connection con = null;
			PreparedStatement st = null;
						
			String sql = " update plans "
				+" set fixed_date =  '" + date + "'"
				+" where plan_id = '" + planid + "'";
			int result = 0;
		
			try {
				con = DBUtil.getConnection();
				st = con.prepareStatement(sql);
				result = st.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.dbClose(null, st, con);
			}
			return result;
		}
	//諛⑹옣
		//諛⑹옣�씠 �꽑�깮�븳 dates�뱾�쓣 肉뚮젮以��떎. for臾몃컲蹂� 
		public List<DateOptionVO> selectHostDates(String planid){
			List<DateOptionVO> list = new ArrayList<DateOptionVO>();
			String sql = "select host_date "
					+ "from date_options "
					+ "where plan_id = ?";
			
			Connection conn = DBUtil.getConnection();
			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				st = conn.prepareStatement(sql);
				st.setString(1, planid);
				rs = st.executeQuery();
				
				while(rs.next()) {
					list.add(new DateOptionVO(planid, rs.getString(1)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.dbClose(rs, st, conn);
			}
			return list;
		}
	//fix諛⑹옣
	//dates �뀒�씠釉붿뿉�꽌 planid�궗�슜�븯�뿬 date(紐⑤몢) 諛쏆븘�삤湲�
	public List<DateVO> selectAllDates(String planid){
		List<DateVO> dlist = new ArrayList<DateVO>();
		String sql = 
				" select distinct select_date "
			+   " from dates"
			+	" where plan_id = ?";
		
		Connection con = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement(sql);
			st.setString(1, planid);
			rs = st.executeQuery();
			
			while(rs.next()) {
				dlist.add(new DateVO(planid, rs.getString(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, st, con);
		}
		return dlist;
	}
	
	
}
