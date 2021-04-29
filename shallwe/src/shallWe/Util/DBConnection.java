package shallWe.Util;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {
	
	//Database에 연결합니다.
	public static Connection getConnection() {
		Connection conn = null;
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return conn;
	}

	//Database 연결을 해제합니다.
	public static void dbClose(ResultSet rs, Statement st, Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(st!=null)st.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
}
