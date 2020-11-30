package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCEmpTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		Connection conn = null;

		try {

			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("드라이버 로드 완료.");

			// 2. DB연결
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";

			conn = DriverManager.getConnection(jdbcUrl, user, password);
			
			System.out.println("데이터 베이스 접속에 성공하였습니다.");
			
			
			// 3. statement 데이터를 불러올 인스턴스 생성
			
//							
//			System.out.println("사원 이름을 입력해주세요.");
//			String ename = sc.nextLine();
//			System.out.println("직급을 입력해주세요.");
//			String job = sc.nextLine();
//			System.out.println("담당 매니저의 사번을 입력하세요.");
//			int mgr = sc.nextInt();
//			System.out.println("사원의 월급을 입력해주세요.");
//			int sal = sc.nextInt();
//			System.out.println("커미션을 입력해주세요.");
//			int comm = sc.nextInt();
//			System.out.println("배치할 부서 번호를 입력해주세요.");
//			int deptno = sc.nextInt();
//				
//			

//			
			PreparedStatement pstmt = null;
			
		
			
//			// insert
//			String sqlInsert = "insert into emp values(seq_emp_empno.nextval,?,?,?,to_date(sysdate, 'YYYY-MM-DD'),?,?,?)";
//			pstmt=conn.prepareStatement(sqlInsert);
//					 
//			pstmt.setString(1, ename);
//			pstmt.setString(2, job);
//			pstmt.setInt(3, mgr);			
//			pstmt.setInt(4, sal);
//			pstmt.setInt(5, comm);
//			pstmt.setInt(6, deptno);

			
			
			
//			//update
//			String sqlUpdate = "update emp set sal = ? where ename = ?";
//			pstmt = conn.prepareStatement(sqlUpdate);
//										
//			pstmt.setInt(1, 1000);
//			pstmt.setString(2, "SCOTT");
//			
			
						
//			int resultCnt = pstmt.executeUpdate();
//								
//			if(resultCnt>0) {
//				System.out.println("데이터 입력이 완료되었습니다.");
//			} else {
//				System.out.println("데이터 입력이 실패하였습니다.");
//			}
//			
			
			
			// 사원 정보 리스트			
//			String sqlSelect = "select * from emp";
//	        pstmt = conn.prepareStatement(sqlSelect);
			
			
			
			// 사원과 부서 정보리스트 
	        String sqlSelect = "select * from emp e, dept d where e.deptno = d.deptno";
	        pstmt = conn.prepareStatement(sqlSelect);

			
			
			// 사원 검색
//			System.out.println("검색하고자 하는 사원의 이름을 입력해주세요");
//			String searchName = sc.nextLine();
//							
//			String sqlSearch = "select * from emp where ename = ?";
//			pstmt = conn.prepareStatement(sqlSearch);	
//			pstmt.setString(1, searchName);
					
			
			ResultSet rs = pstmt.executeQuery();
			
			
			// 사원 정보 출력
//			if(!rs.next()) {
//				System.out.println("검색결과가 없습니다.");
//			}
//			else {
//			 do {    
//				System.out.print(rs.getInt(1)+"\t");
//				System.out.print(rs.getString(2)+"\t");
//				System.out.print(rs.getString(3)+"\t");
//				System.out.print(rs.getInt(4)+"\t");
//				System.out.print(rs.getDate(5)+"\t");
//				System.out.print(rs.getInt(6)+"\t");
//				System.out.print(rs.getInt(7)+"\t");
//				System.out.print(rs.getInt(8)+"\n");
//			} while(rs.next());
//			}; 
			
			
			// 사원 정보와 부서 정보의 전체 출력
			if(!rs.next()) {
				System.out.println("검색결과가 없습니다.");
			}
			else {
			 do {    
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getInt(4)+"\t");
				System.out.print(rs.getDate(5)+"\t");
				System.out.print(rs.getInt(6)+"\t");
				System.out.print(rs.getInt(7)+"\t");
				System.out.print(rs.getInt(8)+"\t");
				System.out.print(rs.getInt(9)+"\t");
				System.out.print(rs.getString(10)+"\t");
				System.out.print(rs.getString(11)+"\n");
				
			} while(rs.next());
			}; 
			
					
			rs.close();
			pstmt.close();
			conn.close();
			
			
		} catch (SQLException e) {	
			System.out.println("예외발생");
		} catch (ClassNotFoundException e) {
			System.out.println("로드 실패");
		}

	
		
		
		
		
	}

}
