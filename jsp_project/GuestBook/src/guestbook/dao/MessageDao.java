package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import guestbook.model.Message;
import jdbc.JdbcUtil;

public class MessageDao {
	
	// 싱글톤 패턴 : DAO 인스턴스는 여러개가 생성될 필요가 없다. 
	private MessageDao() {};
		
	private static MessageDao dao = new MessageDao();
	public static MessageDao getInstance() {
		return dao;
	}
		
	// 방명록에 데이터를 저장해주는 메서드 ( 몇 개의 행이 저장되었는지 숫자를 반환)
	public int insertMessage(Connection conn, Message message) throws SQLException {
		
		int resultCnt = 0; // 반환할 결과 값		
		PreparedStatement pstmt = null;
		try {
			// 입력을 위한 sql
			String sql = "INSERT INTO guestbook_message(guest_name,password,message)"
					      + "VALUES(?,?,?)";
			// 값을 저장
			pstmt = conn.prepareStatement(sql); // throw해서 service클래스에서 예외처리 
			pstmt.setString(1, message.getGuestName());
			pstmt.setString(2, message.getPassword());
			pstmt.setNString(3, message.getMessage());
			
			// 결과 반환
			resultCnt = pstmt.executeUpdate();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}

	
	// 전체 게시물의 개수를 구하는 메서드
	public int selectAllCount(Connection conn) throws SQLException {

		int totalCnt = 0;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
		  stmt = conn.createStatement();
		  String sql = "SELECT count(*) from guestbook_message";
		
		  rs = stmt.executeQuery(sql);
		  
		  if(rs.next()) {
			  totalCnt = rs.getInt(1);
		  }
		  
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
		return totalCnt;
	}

	public List<Message> selectList(Connection conn, int firstRow, int messageCountPerPage) throws SQLException {
		List<Message> list = new ArrayList<Message>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// limit a, b => a : 시작위치 (*0부터 시작) , b : 반환할 데이터의 개수 
		String sql = "SELECT * FROM guestbook_message order by message_id desc limit ?, ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, messageCountPerPage);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(makeMessage(rs));				
			}
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}				
		return list;
	}

	// 반환할 메세지 객체의 반복되는 코드
	private Message makeMessage(ResultSet rs) throws SQLException {
		
		Message message = new Message();
		message.setId(rs.getInt(1));
		message.setGuestName(rs.getString(2));
		message.setPassword(rs.getString(3));
		message.setMessage(rs.getString(4));
		message.setWirtedate(rs.getTimestamp(5));
		
		return message;
	}

	// 삭제할 메세지 데이터를 불러오는 메서드
	public Message selectMessage(Connection conn, int mid) throws SQLException {
	
		Message message = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from guestbook_message where message_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // message_id는 pk속성이기 때문에 결과는 1개 (0 또는 1) -> 고로 반복 필요 없음
				message = makeMessage(rs);
			}
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return message;   // 메시지 객체를 반환하거나 null을 반환
	}
	
	
	// 선택한 메세지를 삭제하는 메서드
	public int deleteMessage(Connection conn, int mid) throws SQLException {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql ="DELETE FROM guestbook_message WHERE message_id=?";
		
	    try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			
			resultCnt = pstmt.executeUpdate(); //결과 반환
			
	  } finally {
		JdbcUtil.close(pstmt);
	  }
		
		
		return resultCnt;	
	}

	
	
}
