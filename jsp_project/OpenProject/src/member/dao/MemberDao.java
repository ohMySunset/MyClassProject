package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.Member;

public class MemberDao {
    // 메서드만 있는 클래스는 여러개의 객체를 생성할 필요가 없음!
	// --> 싱글톤 처리 :외부에서 인스턴스를 생성하지 못함.
	// but 내부에 만들어준 인스턴스를 반환해주는 메서드를 통해 참조할 수 있음. 
	private MemberDao() {} //생성자의 접근제어자 : private	
	
	private static MemberDao dao = new MemberDao(); // 내부에서 실행할 때 미리 만들어짐.
	
	public static MemberDao getInstance() { //public static
		return dao;
	}

	
	// Member 테이블의 데이터를 CRUD
	// insert, select, update, delete
	
	// 데이터 입력
	public int insertMember(Connection conn, Member member) {
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		//sql 실행
		String sqInsert = "INSERT INTO member (memberid,password,membername) VALUES (?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sqInsert);
			
			pstmt.setString(1, member.getUserId() );
			pstmt.setString(2, member.getPassword());
			pstmt.setNString(3, member.getUserName());
			
			resultCnt = pstmt.executeUpdate(); //executeUpdate() : DML(CRUD)의 실행->int
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return resultCnt;
	}

    // 로그인을 위한 select
	public Member selectMemberLogin(Connection conn, String uid, String pw) {
		
		Member member = null;
		
		String sqlSelect = "Select * from member where memberid=? and password=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sqlSelect);
		    pstmt.setString(1, uid);
		    pstmt.setString(2, pw);
		    
		    ResultSet rs = pstmt.executeQuery();
		    
		    if(rs.next()) {
		    	member = new Member(
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

