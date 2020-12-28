package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection getConnection() throws SQLException {
		
		//DB연결 : Connection 객체를 얻어온다.
		Connection  conn = null;
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/open?serverTimezone=UTC";
		String user = "aia";
		String password = "aia";


			conn = DriverManager.getConnection(jdbcUrl, user, password);

		//커넥션 객체를 반환
		return conn;
	}
}
