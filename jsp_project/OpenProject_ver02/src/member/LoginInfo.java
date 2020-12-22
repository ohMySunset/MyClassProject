package member;

  //로그인 정보만 저장할 beans 객체
public class LoginInfo {

	// 회원 정보의  변수 
	private String memberId;  //회원 아이디
	private String memberName; // 회원 이름
	private String memberPhoto; // 회원 
	
	// 생성자
	public LoginInfo(String memberId, String memberName, String memberPhoto) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPhoto = memberPhoto;
	}
		
	// 정보를 받기만 할거기 때문에 getter 생성
	public String getMemberId() {
		return memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public String getMemberPhoto() {
		return memberPhoto;
	}
	
	
	// 출력 확인용 toString()
	@Override
	public String toString() {
		return "로그인 정보 [memberId=" + memberId + ", memberName=" + memberName + ", memberPhoto=" + memberPhoto+"]";
	}


	

	
	
	
}
