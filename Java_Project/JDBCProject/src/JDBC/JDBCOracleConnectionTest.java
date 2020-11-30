package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCOracleConnectionTest {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		try {
		// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 이름 틀리면 제대로 로드되지 않음
			
			System.out.println("Oracle Driver Load !!!");
			
		// 2. DB 연결     localhost == 127.0.0.1
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			
		
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("데이터베이스에 접속했습니다.");
			
			// ........
			
			
			conn.close();
			
		} catch (ClassNotFoundException e) {	
			System.out.println("Driver 로드 실패");
		
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
