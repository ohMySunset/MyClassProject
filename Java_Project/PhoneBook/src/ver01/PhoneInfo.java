package ver01;

public class PhoneInfo {

	/*
	Version 0.1 전화번호 관리 프로그램. 
	​
	PhoneInfor 라는 이름의 클래스를 정의해 보자. 클래스는 다음의 데이터들의 문자열 형태로
	 저장이 가능 해야 하며, 저장된 데이터의 적절한 출력이 가능하도록 메소드 정의
	​
	• 이름            name              String
	• 전화번호       phoneNumber     String
	• 생년월일       birthday            String 
	​
	단, 생년월일 정보는 저장할 수도 있고, 저장 않을 수도 있게끔 생성자 생성.
	*/
	
	//1. data저장 -> 변수저장
	//서로 다른 타입의 변수들 -> 전화번호정보라는 클래스에 정의
	//2. 메서드 정의
	//데이터 출력
	//개인정보를 저장할 수도 있고 하지 않을 수도 있게 -> 초기화 메서드 -> 생성자 오버로딩	
	
    //변수설정
	String name;          //이름 
	String phoneNumber;   //전화번호
	String birthday;      //생일정보
	
	//세 개의 데이터를 받아 초기화
   PhoneInfo(String name, String phoneNumber, String birthday){
	   this.name = name;
	   this.phoneNumber = phoneNumber;
	   this.birthday = birthday;
   }
    //생성자  : 두 개 데이터 (이름, 전화번호)
   PhoneInfo(String name, String phoneNumber){
	 //  this.name = name;
	 //  this.phoneNumber = phoneNumber;
	   this(name, phoneNumber, null);
   }
	
	//저장된 데이터의 적절한 출력메서드
	void showInfo() {
		System.out.println("이름 :"+ name );
		System.out.println("전화번호 :"+ phoneNumber);
	//	System.out.println("생일정보 :"+ birthday);		
	
	if(birthday == null) {
		System.out.println("생일 : 데이터 없음");
	}else {
		System.out.println("생일 :"+ birthday);
	}
	}
	
	
}		
	

