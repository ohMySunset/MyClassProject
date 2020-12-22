package member;

//회원가입 정보를 담을 beans 클래스
public class Member {

	// 회원가입 시 받을 데이터의 변수
	private String userId;
	private String pw;
	private String userName;
	private String userPhoto;
	
	//기본 생성자
	public Member() {
		super();
	}

	public Member(String userId, String pw, String userName, String userPhoto) {
		super();
		this.userId = userId;
		this.pw = pw;
		this.userName = userName;
		this.userPhoto = userPhoto;
	}
	
	
	// getter / setter
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	
	// Member(회원정보)-> LoginInfo(로그인정보)
	public LoginInfo toLoginInfo() {
		return new LoginInfo(this.userId, this.userName, this.userPhoto);
	}
	
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", pw=" + pw + ", userName=" + userName + ", userPhoto=" + userPhoto + "]";
	}

	

    




	
	
	
	
	
}
