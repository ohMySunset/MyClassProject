package phonenumber;


public class PhoneInfo_ver1 {

	//1. 변수선언		
	String name; //이름
	String phonenumber; //전화번호
	String birthday;  //생년월일
	
	//2. 변수의 초기화 
	PhoneInfo_ver1(String name, String phonenumber, String birthday){ 
		this.name = name;  
		this.phonenumber = phonenumber ;
		this.birthday = birthday;		
	}

    //3. 개인정보를 보여주는 메서드
	public void showInfo() {
		System.out.println(name+" 의 전화번호는 "+phonenumber+" 이며 생년월일은 "+birthday+" 입니다.");
	}
		

public static void main(String[] args) {
	
	//4. 메인메서드 인스턴스 생성 및 정보입력
	PhoneInfo_ver1 info1 = new PhoneInfo_ver1("피카츄","010-3747-4386","1993년 12월 17일" );
	PhoneInfo_ver1 info2 = new PhoneInfo_ver1("파이리","010-3285-4682","없음" ); 
	PhoneInfo_ver1 info3 = new PhoneInfo_ver1("꼬북이","010-2543-1328","1987년 7월4일" );
	
	//5. 개인정보 출력
    info1.showInfo();
    info2.showInfo();
    info3.showInfo();
}
}