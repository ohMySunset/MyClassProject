package loginform;

public class LogForm {

	// beans에 필요한 변수
	private String userId;
	private String password;
	
	
	// 디폴트 생성자 생성
	public LogForm() {
		
	}

	public LogForm(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	
	// getter/setter
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "logform [userId=" + userId + ", password=" + password + "]";
	}
	
	
	
	
	
}
