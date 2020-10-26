package ver03;

import java.util.Scanner;
import ver03.Util;

public class PhoneBookManager {

	// 배열 : 전화번호 정보 (이름, 전화번호, 생일)를 저장하는 목적
	// 기능  : (순차적인)저장. 검색, 삭제 
	
	final PhoneInfo[] phoneBook; // 정보 저장을 위한 배열 선언, 다른 배열인스턴스가 참조하지 않도록 final처리
	int cnt; // 1.저장된 정보의 개수    -> 한번에 100개를 저장하지 않고 순차적으로 필요할 때 마다 저장한다고 가정,
	         // 2. 반복 -> 마지막 저장된 정보까지 반복문을 돌릴 경우 cnt-1 
	         // 3. 입력 -> 마지막 저장된 정보의 개수가 cnt면, 다음에 저장될 정보의 인덱스 위치[cnt]!
	
//	Scanner sc;  //ctrl + shift + o
		
    // 배열의 초기화
   PhoneBookManager(){
	//   phoneBook = new PhoneInfo[100];  //100개의 값을 저장하는 배열 생성
	   this(100);   // 밑에서 별다른 요소개수 정의가 없으면 100개의 저장공간 생성
}
   PhoneBookManager(int size) {
	   phoneBook = new PhoneInfo[size]; // 생성자 오버로딩, 요소의 개수 정의
	   Scanner sc = new Scanner(System.in);
   }
    
	// 기능 : 저장, 검색, 삭제
   
    // 정보 저장 기능
	// 사용자로부터 데이터를 받아서 -> 인스턴스를 생성	-> 배열에 생성된 인스턴스의 참조값을 저장.
    // 배열에 생성된 인스턴스의 참조값을 저장 : 저장 index는 cnt를 이용, 저장 후에는 cnt++
   
   void insertMember() {
	   System.out.println("친구의 정보 입력을 시작합니다.");
	   
	   //이름 입력받기
	   System.out.println("이름을 입력해주세요. ");
	   String name = Util.sc.nextLine();
	   //전화번호 입력받기
	   System.out.println("전화번호를 입력해주세요. ");
	   String pNum = Util.sc.nextLine();
	   //생년월일 입력받기
	   System.out.println("생년월일을 입력해주세요.");
	   String birthday = Util.sc.nextLine().trim(); 	   
	   
	   //배열에 저장하기 위한 인스턴스의 참조변수
      PhoneInfo info = null;
      
	//생일이 입력되었는지 여부에 따라 인스턴스 생성을 다르게 처리한다. 
      if(birthday!=null && birthday.length()>0) {
    	  info = new PhoneInfo(name, pNum, birthday);
      } else {
    	  info = new PhoneInfo(name, pNum);
      }
      
      
     phoneBook[cnt++] = info; // phoneBook[0] = 0x111; 주소값, 배열에 정보저장
     //cnt++; //추가된 정보만큼 +1
     
      
   }
   
   
   
    // 정보 검색
    // 검색하고자 하는 이름을 사용자로부터 받고 (반환X)
    // 배열의 요소(참조값 -> 인스턴스 참조) PhoneInfo.name 변수의 값과 검색 이름을 비교(동등 비교)
    // 해당 index를 찾을 수 있다. 
    // 검색된 index로 정보 출력
     void searchMember() {
    	 if(cnt==0) {
    		 System.out.println("저장된 데이터가 없습니다. 다시 메뉴로 이동합니다.");
    		 return;  //메서드의 종료를 의미!
    	 }
    	 
    	 //찾고자 하는 이름을 받는다.
    	 System.out.println("정보 검색을 시작합니다.");
    	 System.out.println("찾고자 하는 이름을 입력해주세요.");
         String name = Util.sc.nextLine();
        
         // 이름의 요소 index 검색
         int index = searchIndex(name);                          
         
         //int index = -1;
         
         // 검색 : index를 찾는다
//         for(int i=0; i<cnt;i++) {
//        	 if(phoneBook[i].name.equals(name)) {
//       		 index=i;
//        		 break;    //이름이 같다면 메서드 종료
//        	 }
//         }
         if(index<0) {
        	 System.out.println("찾으시는 이름의 정보가 존재하지 않습니다.");
         } else {
        	 //정보출력
        	 phoneBook[index].showData();
         }
     }
     
     
     
         //이름 문자열을 받아서,
         //배열의 정보와 비교하고,
         //index를 찾아서 반환하는 메서드
      int searchIndex(String name) {
    	int result = -1; 
    	// 검색 : index를 찾는다
        for(int i=0; i<cnt;i++) {
       	 if(phoneBook[i].name.equals(name)) {
       		 result=i;
       		 break;    //이름이 같다면 메서드 종료
       	 }
        }
    	     return result;
      }
     
     
     
     
         // 정보 삭제
         // 삭제하고자 하는 이름을 사용자로부터 받는다.
         // 배열에서 이름으로 검색해서 index를 찾는다
         // 배열에서 찾은 index의 참조값을 삭제 : 인스턴스는 참조하는 참조변수가 없으면 삭제된다
         // 참조값에 null을 입력하거나, 다른 주소값을 입력(shift처리) -> 이전에 있던 참조값은 없어진다.(가비지 컬렉터)
         // 삭제 대상의 index부터 왼쪽으로 값을 시프트 처리
         // ★ cnt-1 정보가 하나 없어졌으므로
         
     void deleteMember() {
   	    	
    	    	 if(cnt==0) {
    	    		 System.out.println("등록된 정보가 없습니다.");
    	    		 return;
    	    	 }
    	 System.out.println(" 정보 삭제를 진행합니다.");
    	 System.out.println("삭제 하고자 하는 정보의 이름을 입력해주세요.");
    	 String name = Util.sc.nextLine();     
    	 
    	// 이름의 요소 index 검색
         int index = searchIndex(name);
         
         // 검색 : index를 찾는다
 //        for(int i=0; i<cnt;i++) {
 //       	 if(phoneBook[i].name.equals(name)) {
 //       		 index=i;
 //       		 break;    //이름이 같다면 메서드 종료
 //       	 }
 //        }
         if(index<0) {
        	 System.out.println("삭제하고자 하는 정보가 존재하지 않습니다.");
         } else {
        	 // 삭제 처리 : 삭제해야하는 index 부터 왼쪽으로 시프트 처리
        	 // index = 3; 
        	 //phoneBook[3] = phoneBook[4];
        	 //phoneBook[4] = phoneBook[5];
        	 // 반복의 시작 -> 삭제할 index
        	 // 반복의 종료 -> cnt-1
        	 
        	 for(int i=index;i<cnt-1;i++) {
        		 phoneBook[i] = phoneBook[i+1];
        		 
        	 }
        	 cnt--;
        	 System.out.println("정보를 삭제 했습니다.");
         }
         
                  
         
     }

     
         //전체 정보 출력
     void displayAll() {
    	 if(cnt==0) {
    		 System.out.println("등록된 정보가 없습니다.");
    		 return;
    	 }
    	 System.out.println("전체 정보를 출력합니다. ("+ cnt +")");
    	 System.out.println("-----------------------------");
    	 for(int i=0; i<cnt;i++) {
    		 phoneBook[i].showData();
    		 System.out.println("------------------------------");
    	 }
     }
     
     
         
         
         
         
     
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
