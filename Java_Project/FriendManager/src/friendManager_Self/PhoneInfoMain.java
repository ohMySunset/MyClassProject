package friendManager_Self;

import java.util.Scanner;

public class PhoneInfoMain {

	public static void main(String[] args) {
	
		// PhoneInfoHandler타입의 인스턴스 생성
		PhoneInfoHandler handler = new PhoneInfoHandler(10); // FriendInfo 배열에 10개의 요소를 저장
		
		while(true) { //사용자가 프로그램을 종료할때까지 반복
						
			// 프로그램 메뉴 구성
			System.out.println("====프로그램 메뉴====");
			System.out.println("1. 대학 동창 번호 저장.");
			System.out.println("2. 회사 동료 번호 저장.");
			System.out.println("3. 모임 멤버 번호 저장.");
			System.out.println("4. 전체 데이터 출력.");
			System.out.println("5. 기본 데이터 출력.");
			System.out.println("6. 프로그램 종료.");
			System.out.println("================");
			
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
			switch(choice) {
			    case 1 : case 2: case 3:
			        handler.addFriendInfo(choice);
			    	     break;
			    case 4 :
			    	handler.showAllPhoneInfo();
			    	     break;
			    case 5 :
			    	handler.showAllBasicInfo();
			    	     break;
			    case 6 :		
			    	System.out.println("프로그램을 종료합니다!");
			    	     return;
			        	 
			}
			
			
			
			
		}
		
		
	}

}
