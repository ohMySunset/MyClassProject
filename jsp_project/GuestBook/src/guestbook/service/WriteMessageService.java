package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class WriteMessageService {
	
	// 기능만 가진 클래스 -> 싱글톤 패턴 적용
	private WriteMessageService() {}
	
	private static WriteMessageService service = new WriteMessageService();
	public static WriteMessageService getInstance() {
		return service;
	}

	// Message 객체를 받고 
	// Connection 객체를 생성
	// MessgageDao 객체를 생성
	// insertMessage(conn, message) 매개변수로 전달
	
	public int writeMessage(Message message) {
		
		int resultCnt = 0;
		
		Connection conn = null;
		MessageDao dao = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();
			
			resultCnt = dao.insertMessage(conn, message);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 예외가 발생하든 안하든 처리
			JdbcUtil.close(conn);			
		}
		
		return resultCnt;		
	}
	
	
	
	
	
}
