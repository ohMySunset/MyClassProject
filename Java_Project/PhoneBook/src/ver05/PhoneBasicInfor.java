package ver05;

public class PhoneBasicInfor implements PhoneInfor { 

	// 친구의 이름, 전화번호, 주소 , 이메일
	// 변수의 캡슐화 : 정보은닉 (변수에 직접 접근을 제한 - 변수 보호)
	private String name;        // 친구의 이름
	private String phoneNum; // 전화번호
	private String addr;        // 주소
    private String email;       // 이메일
    
    // 생성자를 통한 초기화
	public PhoneBasicInfor(String name, String phoneNum, String addr, String email) {
		//super();    //Object 클래스의 생성자를 호출
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr = addr;
		this.email = email;
	}

	// 변수를 private 처리하면 아래 과정이 필요함.
	  // getter / setter 메서드
	
	public String getName() { //get다음에는 대문자가 옴.
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	// 정보를 출력하는 기능 : 하위클래스에서 오버라이딩 하는 목적
	public void showInfor() {
		super.showInfor();
		System.out.println("이름 : "+ name);
		System.out.println("전화번호 : "+ phoneNum);
		System.out.println("주소 : "+ addr);
		System.out.println("이메일 : "+ email);
	}
    
	
	
	
	
	
	
	
	
	
	
	
}
