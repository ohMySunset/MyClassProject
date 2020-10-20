package friend;

public abstract class Friend {

	// 변수 선언
	private String name;              // 친구의 이름
	private String phoneNumber;       // 전화번호
	private String addr;              // 주소
	
	// 생성자를 통해 인스턴스 변수들을 초기화
	public Friend(String name, String phoneNumber, String addr) {
	 this.name = name;
	 this.phoneNumber = phoneNumber;
	 this.addr = addr;
	} 
	
	//직접 참조를 피하기 위해 private 처리한 변수를 다른 클래스에서도 사용할 수 있도록 getter를 설정
	public String getName() {
        return name;		
	}
	public String getphoneNumber() {
		return phoneNumber;
	}
	public String addr() {
		return addr;
	}
	
	// 오버라이딩 처리 : 상속하는 클래스의 추가 속성을 출력
	public void showData() {
		 System.out.println("이름 : "+name);
	     System.out.println("전화 : "+phoneNumber);
	     System.out.println("주소 : "+addr);
	}
	 
	// 오버라이딩 : 비어있는 처리부에 기능을 추가
//	public void showBasicInfo() {  //상속의 목적으로만 사용하는 추상클래스의 역할
//		                           
//	}
	
	public abstract void showBasicInfo();  // 추상클래스
	
}
