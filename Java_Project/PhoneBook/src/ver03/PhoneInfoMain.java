package ver03;

import java.util.Scanner;

public class PhoneInfoMain {

	public static void main(String[] args) {
	
	//배열 참조	, 인스턴스 생성
	PhoneInfo[] arr = new PhoneInfo[100];
	
	Scanner sc = new Scanner(System.in);
	
	int num;
	int cnt = 0;
	
	System.out.println("몇 명의 정보를 입력하시겠습니까?");
	num = sc.nextInt();
	 sc.nextLine();
   while(cnt<num) {	
	 System.out.println("저장을 위한 데이터를 입력해주세요.");	 
	 System.out.println("이름을 입력해 주세요.");
	 String name = sc.nextLine();
	 System.out.println("전화번호를 입력해 주세요.");
     String phoneNumber = sc.nextLine();
     System.out.println("생년월일을 입력해 주세요.");
     String birthday = sc.nextLine();
     
	//입력받은 정보를 저장
	for(int i=0;i<arr.length;i++) {		// 행의 개수 -> 100명의 정보를 저장하고 있음.	 		         	    	 			
	 arr[i] = new PhoneInfo(name, phoneNumber, birthday);	 
	}
				 
	//인스턴스 초기화
	PhoneInfo data = null;
	
	//생년월일 값이 입력되지 않을 때, 공백란 처리
	if(birthday.trim().isEmpty()) {
	 data = new PhoneInfo(name,phoneNumber);
	}	else {
     data = new PhoneInfo(name,phoneNumber,birthday);
	
	}
	//메서드 호출
	data.showData();
	   
	  cnt++; //while문 탈출
	}
   
    //정보검색 메서드
	 String searchName;
	 System.out.println("누구의 정보를 검색하시겠습니까?");
	 searchName = sc.nextLine();
	for(int i=0;i<arr.length;i++) {
		if(arr[i].toString().substring(3)== searchName) {
			System.out.println("요청하신 정보는 : "+ arr[i] +" 입니다");
			System.out.println(arr[i].toString().substring(3));
			break;
		}else {
			System.out.println("요청하신 정보를 찾을 수 없습니다.");
		}
		
	}
	

	
}}
	