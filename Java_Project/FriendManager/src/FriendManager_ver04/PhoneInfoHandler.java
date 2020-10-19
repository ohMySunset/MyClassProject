package FriendManager_ver04;

import java.util.Scanner;

public class PhoneInfoHandler {

	// 정보의 개수 표현과 반복을 위한 변수
	int cnt; 	
	// 친구의 정보를 넣을 배열 생성
	FriendInfo[] friend = new FriendInfo[cnt];
	
	// 생성자를 통한 초기화
	public PhoneInfoHandler(int count) {
	    friend = new FriendInfo[count];	
	    cnt = 0;
	}
	
	// 배열에 친구의 정보를 저장하는 메서드 
	public void addInfoToArray(FriendInfo f) {
		friend[cnt++] = f;   // ★입력받은 정보를 배열에 저장하고 정보가 추가될 때 마다 배열의 요소가 증가한다.
	}
	
	
	// 친구의 정보를 입력받아 출력하는 메서드
	// 3번의 분기 ->  1.UnivInfo 2.CompanyInfo 3.SocialInfo
	public void addFriendInfo(int choice) {   
		// 사용자로부터 데이터를 입력받기
	   Scanner sc = new Scanner(System.in);		
	   System.out.println("데이터 저장을 위한 입력을 시작합니다.");
	   
	   System.out.println("이름을 입력해주세요.");
	   String name = sc.nextLine();
	   
	   System.out.println("전화번호를 입력해주세요.");
	   String phoneNumber = sc.nextLine();
	   
	   System.out.println("주소를 입력해주세요.");
	   String address = sc.nextLine();
	   
	   System.out.println("이메일을 입력해주세요.");
	   String email = sc.nextLine();
		
		if(choice==1) {
			System.out.println("전공을 입력해주세요.");
			String major = sc.nextLine();
			System.out.println("학년을 입력해주세요.");
			String year = sc.nextLine();
			addInfoToArray(new PhoneUnivInfo(name, phoneNumber, address, email, major, year));
		} else if(choice==2) {
			System.out.println("회사 이름을 입력해주세요.");
			String company = sc.nextLine();
			addInfoToArray(new PhoneCompanyInfo(name, phoneNumber, address, email, company));
		} else {
			System.out.println("모임명을 입력해주세요.");
			String groupName = sc.nextLine();
			addInfoToArray(new PhoneSocialInfo(name, phoneNumber, address, email, groupName));
		}
		System.out.println("데이터가 저장되었습니다.");				
	}
	
	// 오버라이딩한 전체 데이터 출력을 위한 메서드
	public void showAllPhoneInfo() {
		System.out.println("===전체 데이터를 출력합니다!===");
	for(int i=0;i<cnt;i++) {  //저장된 정보의 개수만큼 정보를 출력한다
		friend[i].showInfo();
		System.out.println("-----------------------");
	}
	    System.out.println("=======================");
	}
	
	// 오버라이딩한 기본 데이터 출력을 위한 메서드
	public void showAllBasicInfo() {
		System.out.println("===전체 데이터를 출력합니다!===");
	for(int i=0;i<cnt;i++) { //저장된 정보의 개수만큼 정보를 출력한다
		friend[i].showBasicInfo();
		System.out.println("-----------------------");
	}
	    System.out.println("=======================");
	}
	
	
	
}
