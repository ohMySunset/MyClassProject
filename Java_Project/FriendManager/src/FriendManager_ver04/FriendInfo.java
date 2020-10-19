package FriendManager_ver04;

public class FriendInfo {
    
	// 변수선언
	private String name;          // 친구의 이름
	private String phoneNumber;   // 전화번호
	private String address;       // 주소
	private String email;         // 메일
	
	// 생성자를 통해 변수의 초기화
	public FriendInfo(String name, String phoneNumber, String address, String email) {
      this.name = name;
      this.phoneNumber = phoneNumber;
      this.address = address;
      this.email = email;			
	}

	// private 처리로 보호한 변수의 getter 생성
	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	
	// 전체 정보를 출력하는 메서드 생성	
	public void showInfo() {
		System.out.println("이름 : "+ name);
	    System.out.println("전화번호 : "+ phoneNumber);
	    System.out.println("주소 : "+ address);
	    System.out.println("메일 : "+ email);
	}
	
	// 기본 정보를 출력하는 메서드 생성
	public void showBasicInfo() {
		
	}
	
	
	
	
}
