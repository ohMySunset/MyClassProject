package guestbook.model;

import java.sql.Timestamp;
import java.util.Date;

public class Message { // Message Beans

	private int id;
	private String guestName;
	private String password;
	private String message;
	private Timestamp writedate;
	
	// getter / setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
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
	public void setWirtedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	
	// Timestamp  -> java.util.Date
	public Date getToDate() {
		return new Date(writedate.getTime());
	}
	
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", guestName=" + guestName + ", password=" + password + ", message=" + message
				+ ", wirtedate=" + writedate + "]";
	}
	
	
	
	
}
