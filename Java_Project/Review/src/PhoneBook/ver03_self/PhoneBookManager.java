package PhoneBook.ver03_self;

import java.util.Scanner;

public class PhoneBookManager {

	// 1. 배열 선언
	//PhoneInfo를 참조할 것이기 때문에 타입은 PhoneInfo!		
	final PhoneInfo[] pBook;
	
	// 2. 활용할 변수 선언
	int cnt;  // 정보의 개수를 의미, 뒤에서 배열 반복 시 사용될 것임.

	
	// 3. 배열 초기화
	PhoneBookManager(){
	//	pBook = new PhoneInfo[100];
		this(100);    //밑에서 별다른 인자값이 들어오지 않으면 100개의 저장공간을 가진 배열이 생성
	}
	
	PhoneBookManager(int size) {  
		pBook = new PhoneInfo[size]; //생성자 오버로딩, 정보의 개수를 사용자가 정의하여 배열을 생성
		Util.sc = new Scanner(System.in); 
	}
		
	// 4. 필요한 메서드 기능
	// (1)저장, (2)검색, (3)삭제, (4)정보의 출력
			
	
	// 1) 저장 메서드 생성
	void saveInfo() {
		System.out.println("저장할 데이터를 입력해주세요!");
		Util.sc.nextLine();
		System.out.println("이름을 입력해주세요.");
		String name = Util.sc.nextLine();
		System.out.println("전화번호를 입력해주세요.");
		String pNum = Util.sc.nextLine();
		System.out.println("생년월일을 입력해주세요.");
		String birthday = Util.sc.nextLine().trim();  //공백문자 제거
		
		
		PhoneInfo info = null;		
	// 생일 데이터를 입력받은 경우와 받지 않은 경우로 나누어 인스턴스 생성
		if(birthday!=null && birthday.length()>0) { //생일 데이터가 입력 된 경우
			info = new PhoneInfo(name, pNum, birthday);
		} else {   //입력이 되지 않은 경우
			info = new PhoneInfo(name, pNum);
		}
		
		pBook[cnt++] = info;   //★pBook에 입력된 데이터를 PhoneInfo에 전달!
		                       //전체 정보의 개수가 +1 
	}
	
	
	
	   
	// 2) 검색 메서드 생성 (이름을 기준으로)
	// 배열을 참조하여 저장된 name과 사용자가 입력한 데이터를 비교 (equals 사용)
	// 사전에 정의해주어야 할 것. (1)정보가 하나도 입력되지 않았을 경우 -> 종료, (2)입력된 정보와 일치하는 데이터가 없을 경우 -> 출력문
	 
	  void findinfo() {		  	
		 if(cnt==0) {  //(1)정보가 하나도 입력되지 않았을 경우
			 System.out.println("저장된 데이터가 없습니다. 초기화면으로 돌아갑니다.");
			 return;  //메서드 종료
		 }		
		 
		System.out.println("데이터 정보 검색을 시작합니다!");
		Util.sc.nextLine();
		System.out.println("검색할 이름을 입력해주세요");
		String name = Util.sc.nextLine();
		int index = searchIndex(name); 

		if(index<0) { //(2)입력된 정보와 일치하는 데이터가 없을 경우
		    	System.out.println("일치하는 데이터가 없습니다!");
		    }else {
		    	pBook[index].showData();
		    }
	 }
	 
	  
	// 추가+) 이름과 일치하는지 비교하여 인덱스를 반환해주는 메서드  (검색, 삭제 메서드에서 사용)
	   int searchIndex(String name) { //반환하는것이 index이므로 int타입으로 생성
			  int result = -1; // 정보가 일치하지 않는 경우를 위한 변수. 배열의 인덱스는 절대 음수가 나올 수 없기 때문에!
			  for(int i=0; i<cnt;i++) {
					if(pBook[i].name.equals(name)) {
						result = i;
					    break;  //원하는 인덱스를 찾았으므로 break			    
					}
				}
			  return result;
		  }
	
	  	  
	 
	 // 3) 삭제 메서드 생성 (이름을 기준으로)
	 // 데이터 하나가 삭제되면 뒤에서 앞으로 shift되야함.
	 // 데이터 삭제의 개념 -> 1) 해당 인덱스에 null값이 들어갔을 때 -> 가비지 컬렉터가 쓸모없는 메모리로 인식하면서 삭제됨
	 //                2) 해당 인덱스 위치에 index+1이 들어갔을 때 해당 인덱스를 참조할 수 있는 참조값이 없어지면서 자동적으로 삭제됨.  
	 // 검색과 마찬가지로 입력한 이름과 (1)아직 저장된 데이터가 없는 경우,(2)일치하는 데이터가 없을 경우를 정의해주어야함.
	  
	  
	  void deleteInfo() {
		 
		  if(cnt==0) {    //(1)아직 저장된 데이터가 없는 경우
			  System.out.println("저장된 데이터가 없습니다. 초기화면으로 돌아갑니다.");
			  return;     //메서드 종료
		  }
		  System.out.println("데이터 정보 삭제를 시작합니다!");
		  Util.sc.nextLine();		  
		  System.out.println("삭제할 이름을 입력해주세요.");
		  String name = Util.sc.nextLine();		
		  
		  int index = searchIndex(name);	 
		 
		 if(index<0) { //(2)입력된 정보와 일치하는 데이터가 없을 경우
		    	System.out.println("일치하는 데이터가 없습니다!");
		    }else {
		    	 for(int i=index;i<cnt-1;i++) {  //cnt를 기준으로 데이터 하나가 빠지면 인덱스가 앞으로 시프트된다.
					 pBook[i] = pBook[i+1];      //마지막 비는 저장공간은 삭제 후 cnt--가 되기 때문에 신경쓰지 않아도됨.					 			 
				 }	
		    	 cnt--;
		    	 System.out.println("정보를 삭제하였습니다.");
	  }
	  }
	  
	  
	   // 4) 데이터 정보 출력 메서드 생성
	   // 1)저장된 데이터가 없는 경우, 2)저장된 데이터만큼 출력
	  void showAll() {
		 if(cnt==0) {
			 System.out.println("저장된 데이터가 없습니다. 초기화면으로 돌아갑니다.");
			 return;
		 }
			 for(int i=0;i<cnt;i++) {
				 pBook[i].showData();
			 }
		 
	  }
	
}
