package loginform;

public class RegForm {

	
	// beans에 필요한 변수 (private)
	private String userId;   // 유저 아이디(이메일)
	private String password; // 유저 비밀번호
	private String userName; // 유저의 이름
	
	
	// 생성자 생성
	public RegForm() {
	}

	public RegForm(String userId, String password, String userName) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	@Override
	public String toString() {
		return "RegForm [userId=" + userId + ", password=" + password + ", userName=" + userName + "]";
	}
	
	
	
	
	
}
