package friend;

public class UnivFriend extends Friend{

	// 새로운 변수 선언
	private String major;  // 친구의 전공
	
	// 생성자를 통한 변수의 초기화 (상위클래스(super), 하위클래스 모두 정의)
	public UnivFriend(String name, String phoneNumber, String addr, String major) {
		super(name, phoneNumber, addr);
		this.major = major;
	}
	
	// 오버라이딩 
    public void showData() {
    	super.showData();
    	System.out.println("전공 : "+major);
    }
    
    // 오버라이딩
    public void showBasicInfo() {
    	System.out.println("이름 : "+ getName());
    	System.out.println("전화번호 : "+ getphoneNumber());
    	System.out.println("전공 : "+ major); //major는 같은 클래스 안의 변수이므로 게터를 받아올 필요가 없음
    }
}
