package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import member.model.Message;

public class MessageDao {

	// 싱글톤 패턴 적용
	private MessageDao() {}
	private static MessageDao dao = new MessageDao();
	public static MessageDao getInstance() {
		return dao;
	}
	
	// 메세지를 입력받아 데이터베이스에 저장해주는 메서드 
	public int insertMessage(Connection conn, Message message) throws SQLException {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		try {
		// 데이터를 입력할 sql	
		String sql = "INSERT INTO guestbook_message(guest_name,password,message) VALUES(?,?,?)";	
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, message.getMemberId());
	    pstmt.setString(2, message.getPassword());
	    pstmt.setString(3, message.getMessage());
	    
	    // 결과반환	    
	    resultCnt = pstmt.executeUpdate();	
		} finally {
			pstmt.close();
		}		
		return resultCnt;
	}
}
