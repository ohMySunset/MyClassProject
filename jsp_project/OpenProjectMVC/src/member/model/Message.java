package member.model;

import java.sql.Timestamp;
import java.util.Date;

// 메시지 데이터를 저장할 beans
public class Message {

	private int id;               // 게시물 ID
	private String memberId;      // 회원 이름
	private String password;      // 비밀번호
	private String message;       // 메시지
	private Timestamp writedate;  // 작성일자
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	
	// DB Timestamp => Date타입
	public Date toDate() {
		return new Date(writedate.getTime());
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", memberId=" + memberId + ", password=" + password + ", message=" + message
				+ ", writedate=" + writedate + "]";
	}
	
	
}
