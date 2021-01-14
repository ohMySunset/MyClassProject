package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import member.dao.MessageDao;
import member.model.Message;

public class WriteMessageService {

	// 싱글톤 패턴 적용
	public WriteMessageService() {}
	private static WriteMessageService service = new WriteMessageService();
	public static WriteMessageService getInstance() {
		return service;
	}
	
	// Message 객체를 받고,
	// Connection, Dao 객체 생성
	// Dao 내부의 insert메서드 호출
	// 데이터 반환
	
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
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return resultCnt;
		
	}
}
