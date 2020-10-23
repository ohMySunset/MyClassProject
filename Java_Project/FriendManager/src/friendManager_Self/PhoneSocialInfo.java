package friendManager_Self;

public class PhoneSocialInfo extends FriendInfo {

	// 새로 추가된 변수
	private String groupName;  // 모임 이름
	
	// 생성자를 통한 초기화
	public PhoneSocialInfo(String name, String phoneNumber, String address, String email, String groupName) {
		super(name, phoneNumber, address, email);
        this.groupName = groupName;       
	}

	// 오버라이딩 1
	// 전체 정보를 출력하는 메서드 
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("모임명 : "+ groupName);
	}
	
	// 오버라이딩 2
	// 기본 정보를 출력하는 메서드
	@Override
	public void showBasicInfo() {
		super.showBasicInfo();
		System.out.println("이름 : "+ getName());
		System.out.println("전화번호 : "+ getPhoneNumber());
		System.out.println("모임명 : "+ groupName);
	}
}
