package my.com.mango.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MangoPlateConnection {
	public static Connection getConnection()
			throws ClassNotFoundException,SQLException{		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn=null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "mangoplate";
		String password = "mp";

		conn = DriverManager.getConnection(url, user, password);
		System.out.println("DB와 연결성공");
		return conn;
	}
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			}catch(SQLException e) {
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			}catch(SQLException e) {
			}
		}
		if(conn !=null) {
			try {
				conn.close();
			}catch(SQLException e) {
			}
		}
	}
}

