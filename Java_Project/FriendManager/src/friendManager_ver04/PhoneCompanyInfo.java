package friendManager_ver04;

public class PhoneCompanyInfo extends FriendInfo {

	// 새로 추가된 변수
    private String company;
     
    // 생성자를 통한 초기화  (상위클래스와 하위클래스 모두 초기화)
	public PhoneCompanyInfo(String name, String phoneNumber, String address, String email, String company) {
		super(name, phoneNumber, address, email);
        this.company = company;
	}

	// 오버라이딩 1
	// 전체 정보를 출력하는 메서드 
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("회사 : "+company);		
	}
	
	// 오버라이딩 2
	// 기본 정보를 출력하는 메서드
	@Override
	public void showBasicInfo() {
		super.showBasicInfo();
		System.out.println("이름 : "+ getName());
		System.out.println("전화번호 : "+ getPhoneNumber());
		System.out.println("회사 : "+ company);
	}
}
