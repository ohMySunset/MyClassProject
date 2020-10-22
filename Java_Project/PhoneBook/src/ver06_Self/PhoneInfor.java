package ver06_Self;

public class PhoneInfor implements Infor {

	// 변수선언
	private String name;         // 이름
	private String phoneNumber;  // 전화번호
	private String addr;         // 주소
	private String email;        // 이메일
	
		
	//생성자 초기화 
	public PhoneInfor(String name, String phoneNumber, String addr, String email) {	
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.addr = addr;
		this.email = email;
	}


	// getter/setter	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	
	// 모든 정보 출력 (오버라이딩)
	@Override
	public void showInfor() {
		System.out.println("이름 : "+ name);
		System.out.println("전화번호 : "+ phoneNumber);
		System.out.println("주소 : "+ addr);
		System.out.println("이메일 : "+ email);
	}
	
	// 기본 정보 출력 (오버라이딩)
	@Override
	public void showBasicInfor() {
		System.out.println("이름 : "+ name);
		System.out.println("전화번호 : "+ phoneNumber);
	}
}
