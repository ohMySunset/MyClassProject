package phonenumber;

import java.util.Scanner;

public class PhoneInfo_ver2 {

	//변수선언
		
	String name;
	String phonenumber;
	String birthday;
	
	Scanner sc = new Scanner(System.in);
	
//	PhoneInfo(){
//		this("양선경", "1234", "12355")
//	}
	
	PhoneInfo_ver2(String name, String phonenumber, String birthday){
		this.name = name;
		this.phonenumber = phonenumber ;
		this.birthday = birthday;		
	}
	

	public void showInfo() {
		System.out.println(name+" 의 번호는 "+phonenumber+" 이며 생년월일은 "+birthday+" 입니다.");
	}
	
	

public static void main(String[] args) {
	
//	Scanner sc = new Scanner(System.in);	

	
	PhoneInfo_ver2 info1 = new PhoneInfo_ver2("피카츄","010-3747-4386","12월 17일" );
	PhoneInfo_ver2 info2 = new PhoneInfo_ver2("파이리","010-3285-4682","없음" );
	PhoneInfo_ver2 info3 = new PhoneInfo_ver2("꼬북이","010-2543-1328","7월4일" );
	
	
    info1.showInfo();
    info2.showInfo();
    info3.showInfo();
}
}