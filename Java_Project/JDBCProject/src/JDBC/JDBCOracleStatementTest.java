package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCOracleStatementTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;

		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 이름 틀리면 제대로 로드되지 않음

			System.out.println("Oracle Driver Load !!!");

			// 2. DB 연결 localhost == 127.0.0.1
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";

			conn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("데이터베이스에 접속했습니다.");

			// 3. statement 인스턴스 생성
			Statement stmt = conn.createStatement();
			
			System.out.println("부서 이름을 입력해주세요.");
			String userDname = sc.nextLine();
			System.out.println("부서의 위치를 입력해주세요.");
			String userLoc = sc.nextLine();

			// 입력 : insert
			String sqlInsert = "insert into dept values (SEQ_DEPT_DEPTNO.NEXTVAL, '"+ userDname+"','"+ userLoc+"')";
                                                                                  //DB오라클 문자열 표기에 따라 ' '
			int resultCnt = stmt.executeUpdate(sqlInsert);

			if (resultCnt > 0) {
				System.out.println("데이터가 정상적으로 입력되었습니다.");
			}

			// 4. SQL 실행 : 부서리스트 출력
			String sql = "select * from dept order by deptno";

			ResultSet rs = stmt.executeQuery(sql);

			// 5. ResultSet을 이용해서 결과 출력
			while (rs.next()) { // 행이 존재할 때 까지 반복
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString(3); // 위 select문과 같은 순서로

				System.out.println(deptno + "\t" + dname + "\t" + loc);

			}

			// 6. close 역순으로 닫아줌
			rs.close();
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println("Driver 로드 실패");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}