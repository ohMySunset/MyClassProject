package friend;

public class HighFriend extends Friend{

	// 새로운 변수 선언
	String work;
	
	// 생성자를 통한 변수의 초기화 (상위클래스(super), 하위클래스 모두 정의)
	public HighFriend(String name, String phoneNumber, String addr, String work) {
		super(name, phoneNumber, addr);
	    this.work = work;
	}
	
	// 상위클래스 오버라이딩
	@Override
	public void showData() {	//Friend f = new HignFriend()	-> f.showData()
		super.showData();
		System.out.println("직업 : "+work);
	}


	@Override
	public void showBasicInfo() {
	//	super.showBasicInfo();
		System.out.println("이름 : "+ getName());
		System.out.println("전화번호 : "+getphoneNumber());		
	}

	
	
	
}
