package ver02;

import java.util.Scanner;

public class PhoneBookMain {

//private static PhoneInfo p;

	public static void main(String[] args) {

      //사용자에게 데이터를 받는다.
		 Scanner s = new Scanner(System.in);
		
	  while(true) {		  //아래 루틴을 반복
	
		 //인스턴스 생성을 위해서 이름, 전화번호, 생일 데이터를 받는다.
		 System.out.println("저장을 위한 데이터를 입력해주세요.");
		 
		 System.out.println("이름을 입력해 주세요.");
		 String name = s.nextLine();
		 System.out.println("전화번호를 입력해 주세요.");
	     String phoneNumber = s.nextLine();
	     System.out.println("생년월일을 입력해 주세요.");
	     String birthday = s.nextLine();
		 
	     
	   PhoneInfo info= null; //인스턴스 생성
	   
	   // trim() -> "     1 23  " 좌우공백을 지워줌
	   // .trim() -> "123"  문자 사이의 공백도 지워줌
	   
	   //입력값 없이 enter인 경우 공백 문자열을 반환
	   //문자열의 길이가 0이면 입력이 없다고 판단.
	   //if(birthday.length()==0)  => true
	   if(birthday.trim().isEmpty()) { //.isEmpty() 문자열이 없다
		  info = new PhoneInfo(name, phoneNumber);  //인스턴스 값 초기화
	   } else {
	      info = new PhoneInfo(name, phoneNumber, birthday);
	   }
	   
	   //메서드 호출
	   info.showInfo();
	   
	}
	}
	
}
