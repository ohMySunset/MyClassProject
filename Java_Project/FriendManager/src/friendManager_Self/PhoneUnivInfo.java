package friendManager_Self;

public class PhoneUnivInfo extends FriendInfo {

	// 새로 추가된 변수
	private String major;    // 친구의 전공
	private String year;     // 친구의 학년
	
	// 생성자를 통한 초기화 (상위클래스와 하위클래스 모두 초기화)
	public PhoneUnivInfo(String name, String phoneNumber, String address, String email, String major, String year) {
		super(name, phoneNumber, address, email);
		this.major = major;  
		this.year = year;
	}
	
	// 오버라이딩 1
	// 전체 정보를 출력하는 메서드 
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("전공 : "+ major);
		System.out.println("학년 : "+ year);
	}
	
	// 오버라이딩 2
	// 기본 정보를 출력하는 메서드
	@Override
	public void showBasicInfo() {		
		System.out.println("이름 : "+ getName());
		System.out.println("전화번호 : "+ getPhoneNumber());
		System.out.println("전공 : "+ major);		
	}
	
	
}
