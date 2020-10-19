package friend;

import java.util.Scanner;

public class FriendInfoHandler {

	// 친구정보를 저장하는 배열 (조상클래스를 이용해서 변수를 만든다)	
	private Friend[] friends; 
	private int numOfFriends; // 저장된 친구 정보의 개수, 배열의 요소 추가시 index로 사용.

	// 생성자를 통한 초기화
   public FriendInfoHandler(int num) {
	   friends = new Friend[num];  
	   numOfFriends = 0;
   }
	
	// 배열에 친구 정보를 저장하는 기능 : 다형성을 이용한 매개변수의 정의	
/*	 아래의 단계를 줄여주기 위해 조상클래스를 매개변수로 받는다
    void addFriendInfo(HighFriend f) {		
	}
    void addFriendInfo(UnivFriend f) {		
	}
*/	  
   void addFriendInfo(Friend f) {
	   friends[numOfFriends++] = f;
	   //numOfFriends++
   }
   
   
   // 고교친구 : 1, 대학 친구 : 2
   void addFriend(int choice) {
	   
	   //사용자로부터 기본 정보를 입력받자 : 이름, 전화번호, 주소
	   Scanner sc = new Scanner(System.in);
	   System.out.println("친구 정보의 입력을 시작합니다.");
	   
	   System.out.println("이름을 입력해주세요>> ");
	   String name = sc.nextLine();
	   
	   System.out.println("전화번호를 입력해주세요>> ");
	   String phoneNumber = sc.nextLine();
	   
	   System.out.println("주소를 입력해주세요>> ");
	   String addr = sc.nextLine();
	   
	   // 인스턴스를 생성해서 저장
	   // 인스턴스 생성 : 고교 친구와 대학 친구가 다르다  -> 분기
	   if(choice==1) {
		   //고교친구의 데이터를 받고-> 인스턴스를 생성 -> 배열에 저장 
		   System.out.println("직업을 입력해주세요>> ");
		   String work = sc.nextLine();		   	
		//Friend f = new HighFriend(name, phoneNumber, addr, work);
		  //배열에 저장 
			addFriendInfo(new HighFriend(name, phoneNumber, addr, work));	   
	   } else {
		   // 대학 친구의 데이터를 받고 -> 인스턴스를 생성 -> 배열에 저장 
		 System.out.println("전공을 입력해주세요>> ");
		 String major = sc.nextLine();
		 addFriendInfo(new UnivFriend(name, phoneNumber, addr, major));
	   }
         System.out.println("입력이 완료되었습니다.");      
   }
   
   //전체정보를 출력하는 메서드 : showData()   
   public void showAllData() {
	   System.out.println("전체 데이터를 출력합니다.=============");
    for(int i=0; i<numOfFriends; i++) {
    	friends[i].showData();  //friends[0] -> Friend 타입의 참조변수 = 하위 클래스의 인스턴스를 참조, 형변환을 따로 할 필요가 없음.
        System.out.println("------------------------");
    }
   }
   //기본정보를 출력하는 메서드 : showBasicInfo()
   public void showAllSimpleData() {
	   System.out.println("간단한 데이터를 출력합니다.=============");
	   for(int i=0;i<numOfFriends;i++) {
		   friends[i].showBasicInfo();
		   System.out.println("------------------------");
	   }
   }
   



}
