package PhoneBook.ver03_self;

public class PhoneInfo {

   
	 //객체 100개 저장  --> 배열
		//PhoneInfo[] info = new PhoneInfo[100];		
		//저장기능 : 배열에 저장
		//검색기능 : 데이터 정보 출력 
		//삭제기능 : 데이터가 삭제 되면 배열이 앞으로 당겨지면서 채워짐.
	
	//변수선언
		 String name;       //이름
		 String pNum;  //전화번호
		 String birthday;     //생년월일 
	
	//생성자 호출
	 PhoneInfo(String name, String pNum, String birthday){
		this.name = name;
		this.pNum = pNum;
		this.birthday = birthday;
			        			}
			        		
	//생년월일을 받지 않을 대상의 생성자
	PhoneInfo(String name, String pNum){
		this(name, pNum, null);
	}	 
		
	
	
	//출력메서드
	void showData() {		
		System.out.println("이름 : "+ name);
		System.out.println("전화번호 : "+ pNum);
	//	System.out.println("생년월일 : "+ birthday);
	
	//생년월일을 입력하지 않은 대상자에 대한 출력문
    if(birthday == null) {
    	System.out.println("생년월일 : 데이터 정보 없음");
    } else {
    	System.out.println("생년월일 : "+ birthday);
    }
	}

	
	
}
