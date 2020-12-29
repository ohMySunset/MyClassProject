package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.exception.InvalidMessagePasswordException;
import guestbook.exception.MessageNotFoundException;
import guestbook.model.Message;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class DeleteMessageService {

	// 싱글톤 처리
	private DeleteMessageService() {};
	private static DeleteMessageService service = new DeleteMessageService();
	public static DeleteMessageService getInstance() {
		return service;
	}
	
	// 게시물의 아이디, 비밀번호를 받아서 삭제하고	
	// 결과를 반환하는 메서드
	public int deleteMessage(int mid, String pw) throws SQLException,
	                                             MessageNotFoundException,
	                                             InvalidMessagePasswordException {
		int resultCnt = 0;
		
		// Connection, MessageDao 객체 생성
		// -> selectMessage(conn, mid) => Message 객체 : 게시물 존재 유무, 비밀번호 체크 일치 체크
        // -> deleteMessage(conn, mid) : 게시물 삭제

		Connection conn = null;
		MessageDao dao = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			// 오토커밋(Auto Commit) -> false
			conn.setAutoCommit(false); // default -> true
			
			dao = MessageDao.getInstance();
			
			Message message = dao.selectMessage(conn, mid); // Message객체, null일 경우
						
			if(message==null) {
				// 메세지가 존재하지 않는 경우
				// 강제적으로 예외 발생 -> 롤백
				throw new MessageNotFoundException();
				
			} else if(message.getPassword().equals(pw)){
				//메세지가 존재하고 비밀번호도 일치 -> 게시물을 삭제						
				dao.deleteMessage(conn, mid);				
				conn.commit();
				
			} else {
				// 메세지가 존재하지만 비밀번호가 틀린 경우	
				// 강제적으로 예외 발생 -> 롤백
				throw new InvalidMessagePasswordException();
			}
			
			
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			throw e;			
		} catch (MessageNotFoundException e){ 
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			throw e;
		} catch (InvalidMessagePasswordException e){ 
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			throw e;
		}
				
		return resultCnt;
	}
	
	
	
	
	
}




