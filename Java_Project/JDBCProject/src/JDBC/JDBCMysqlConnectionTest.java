package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCMysqlConnectionTest {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		try {
		// 1. 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver"); // 이름 틀리면 제대로 로드되지 않음
			
			System.out.println("Driver Load !!!");
			
		// 2. DB 연결     localhost == 127.0.0.1
			String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
			                                                //사용자 컴퓨터와 DB의 타임존이 일치하지 않으면오류 발생
			String user = "bit";
			String password = "bit";
						
		
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
