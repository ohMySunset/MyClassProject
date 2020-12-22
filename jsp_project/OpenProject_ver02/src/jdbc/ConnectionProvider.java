package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection getConnection() {
		
		// DB와 연결 : Connection객체를 가져온다
		Connection conn = null;
		
		String jdbcurl = "jdbc:mysql://localhost:3306/open?serverTimezone=UTC";
	    String user = "aia";
	    String password = "aia";
	    
	    try {
			conn = DriverManager.getConnection(jdbcurl,user,password);
		   System.out.println("Connection 객체 생성 성공!");
	    } catch (SQLException e) {
	       System.out.println("Connection 객체 생성 실패!");
			e.printStackTrace();
		}
	    
	    // Connection 객체 반환
	    return conn;
	} 
	
}
