package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.Member;
    // DB에 데이터를 저장하고 불러오는 메서드를 정의할 클래스 
public class MemberDao {
    // 메서드만 있는 구조의 클래스는 싱글톤 처리 해주자
	// 싱글톤 처리
	private MemberDao() {} // 생성자 (접근제어자는 private)
	private static MemberDao dao = new MemberDao(); // 인스턴스 내부에서만 생성
	public static MemberDao getInstance() {
		return dao;  // 메서드를 호출하면 인스턴스의 참조변수가 반환
	}
		
	// DB의 member테이블에 데이터를 CRUD 할 수 있는 메서드 정의한다!
	
	// 1. member 테이블에 값을 저장하는 메서드
	public int insertMember(Connection conn, Member member) {
		// 데이터가 저장되면 반환할 결과
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		
		// sql 실행
		String sqlInsert = "Insert into member (memberid,password,membername) VALUES (?,?,?)";
		// 값 저장하기
		try {
			pstmt = conn.prepareStatement(sqlInsert);
			
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getPw());
			pstmt.setNString(3, member.getUserName());
			
			resultCnt = pstmt.executeUpdate(); // DML의 실행
		} catch (SQLException e) {		
			e.printStackTrace();
		}	
		return resultCnt;		
	}
	
	
	// 2. Login처리를 위해 member 테이블에서 회원정보를 select 할 수있는 메서드
	// uid와 pw를 받아서 처리	
	public Member selectMemberLogin(Connection conn, String uid, String pw) {
		
		Member member = null;
		
		String sqlSelect = "Select * from member where memberid=? and password=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sqlSelect);

            pstmt.setString(1, uid);
            pstmt.setString(2, pw);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()) {
          /*member 테이블에서 uid,pw와 일치하는 값을 찾아 받아와서 Member객체에 저장한다.*/
            	member = new Member(
            			          /*테이블 변수이름과 동일해야함*/
            		  rs.getString("memberid"),
            		  rs.getString("password"),
            		  rs.getString("membername"),
            		  rs.getString("memberphoto"));
           	
            }
		
		} catch (SQLException e) {			
			e.printStackTrace();
		}				
		return member;
	}
	
	
	
	
	
	
	
}
