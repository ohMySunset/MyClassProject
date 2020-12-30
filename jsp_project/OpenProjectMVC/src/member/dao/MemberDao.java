package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import member.model.Member;

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
	public int insertMember(Connection conn, Member member) throws SQLException {
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		//sql 실행
		String sqInsert = "INSERT INTO member (memberid,password,membername,memberphoto) VALUES (?,?,?,?)";
		
		//try {
			pstmt = conn.prepareStatement(sqInsert);
			
			pstmt.setString(1, member.getUserId() );
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getUserPhoto());
			
			resultCnt = pstmt.executeUpdate(); //executeUpdate() : DML(CRUD)의 실행->int
	//	} catch (SQLException e) {
			
	//		e.printStackTrace();
	//	}
		
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
//		    	member = new Member(
//		    			rs.getString("memberid"),
//		    			rs.getString("password"),
//		    			rs.getString("membername"),
//		    			rs.getString("memberphoto"),
//		    			rs.getTimestamp("regdate"));
		    	member = makeMember(rs);
		    }
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return member;
	}

    // 전체 리스트를 반환하는 select
	public List<Member> selectMember(Connection conn){
		
	   List<Member> list = new ArrayList<Member>();
	   
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   
	   String sql = "select * from member";
	   try {
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
//			list.add(new Member(
//					rs.getString("memberid"),
//					rs.getString("password"),
//					rs.getString("membername"),
//					rs.getString("memberphoto"),
//					rs.getTimestamp("regdate")
//					));
			list.add(makeMember(rs));
		}
		
		rs.close();
		pstmt.close();	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	   
	   return list;
	}
	
	// 반복되는 코드 메서드 처리 
	private Member makeMember(ResultSet rs) throws SQLException {
		return new Member(
				rs.getString("memberid"),
				rs.getString("password"),
				rs.getString("membername"),
				rs.getString("memberphoto"),
				rs.getTimestamp("regdate")
				);
	}


	public int selectMemberTotalCount(Connection conn) throws SQLException {
	
		int resultCnt = 0;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT count(*) FROM MEMBER";
		
		try {			
		  stmt = conn.createStatement();
		  rs = stmt.executeQuery(sql);
		
		  if(rs.next()) {
			  resultCnt = rs.getInt(1);
		   }
		  } finally {
		    rs.close();
		    stmt.close();
		}
		return resultCnt;
	}

	
    // 페이지의 첫번째 행을 받아서 데이터를 리스트에 저장해주는 메서드
	public List<Member> selectMember(Connection conn, int firstRow, int count) throws SQLException {
		List<Member> memberList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member order by memberid limit ?,?";
		
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, firstRow);
		pstmt.setInt(2, count);
		
		rs = pstmt.executeQuery();
		
		memberList = new ArrayList<Member>();
		
		while(rs.next()) {
			memberList.add(makeMember(rs));
		}
		
		}finally {
			rs.close();
			pstmt.close();
		}
		
		return memberList;
	}
}

