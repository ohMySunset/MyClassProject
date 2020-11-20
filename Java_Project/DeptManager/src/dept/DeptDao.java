package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// DAO : Data Access Object -> 데이터베이스 처리하는 기능만 가지는 클래스
public class DeptDao {
	
	private static DeptDao dao = new DeptDao();

	private DeptDao() {
		
	}

	public static DeptDao getInstance() {
		return dao;
	}
	
	// 부서 입력
	int insertDept(Dept dept, Connection conn) {
		
		int resultCnt = 0;
		
		// DB 연결 : Connection
	
		try {
			// Statement
			// SQL : insert into 
			String sql = "insert into dept values(?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			// SQL 실행	
			resultCnt = pstmt.executeUpdate();
					
			pstmt.close();
			
		} catch (SQLException e) {
		}
	
		// 결과
		return resultCnt;
	}
	
	
	
	
    // 부서 정보 수정  : Dept
	int updateDept(Dept dept, Connection conn) {
	int resultCnt = 0;
		
		// DB 연결 : Connection
	
		try {
			// Statement
			// SQL : update 
			String sql = "update dept set dname = ?, loc = ? where deptno = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			
			// SQL 실행	
			resultCnt = pstmt.executeUpdate();
					
			pstmt.close();
			
		} catch (SQLException e) {
		}
	
		// 결과
		return resultCnt;
		
	}
	
	// 부서 정보 삭제
	int deleteDept(int deptno, Connection conn) {
		
		int resultCnt = 0;

		// DB 연결 : Connection

		try {
			// Statement
			// SQL : update
			String sql = "delete from dept where deptno = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, deptno);

			// SQL 실행
			resultCnt = pstmt.executeUpdate();

			pstmt.close();

		} catch (SQLException e) {
		}

		// 결과
		return resultCnt;
	}
	
	
	// 부서 전체 리스트
	List<Dept> listDept(Connection conn) {
		List<Dept> list = new ArrayList<Dept>();
		
		Statement stmt =null;
		try {
			stmt = conn.createStatement();
			
			String sql = "Select * from dept order by deptno";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				// 리스트에 담기
			//	Dept d = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			//  list.add(d);
			    list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));				
			}
			
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
		return list;
	}
	
	// 부서 하나 검색
	Dept searchDept(int deptno, Connection conn) {		
		
		Dept dept =null;
		
		Statement stmt = null;
			
			try {
				stmt = conn.createStatement();
				
				String sql = "Select * from dept where deptno = "+deptno;
				
				ResultSet rs = stmt.executeQuery(sql);
				
			if(rs.next()) {
				dept = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
				
			} catch (SQLException e) {	
				e.printStackTrace();
			}
			
			return dept;
		
	}
	
	
	
	
	
	
}
