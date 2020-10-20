package ver04;

import ver03.Util;

public class PhoneBookManager {

	// 전화번호 정보를 저장할 배열을 가지고,
	// 배열을 이용한 정보의 저장, 삭제, 출력을 하는 기능
	
	// 배열 선언 : 상속 관계이기 때문에 PhoneInfor 타입으로 선언
	private PhoneInfor[] pBook;  // 전화번호 정보를 저장할 배열, 초기화는 생성자를 통해서 처리
	private int cnt;             // 배열에 저장된 요소의 개수, 추가할 배열의 index
	
	// 생성자
    PhoneBookManager(int num){
    	pBook = new PhoneInfor[num];  //생성자의 매개변수의 인자를 전달받아 배열 생성
    	cnt = 0;  	
    }
    
    // 1) 정보 저장
    // 1. 배열에 정보를 저장하는 메서드, 다형성을 이용하여 하나의 메서드로 정의!!! 
    // void addInfor(상위클래스 타입의 매개변수){}
   private void addInfor(PhoneInfor info) {
    	pBook[cnt++] = info;
    }
  
   
    // 2. 사용자에게 받은 데이터를 인스턴스로 생성하는 메서드
    //   입력의 구분 -> 구분에 따라 인스턴스 생성도 구분 -> addInfor()메서드를 이용해서 정보를 저장한다. 
    public void insertInfo() {
    	if(pBook.length==cnt) {
    		System.out.println("데이터의 저장공간이 부족하여 정보를 저장할 수 없습니다.");
    		System.out.println("일부 데이터를 삭제하고 저장공간을 확보해주세요.");
    	}
    	System.out.println("어떤 정보를 입력하시겠습니까?");
    	System.out.println(" 1. 기본");
    	System.out.println(" 2. 대학");
    	System.out.println(" 3. 회사");
    	System.out.println(" 4. 동호회");
    	
    	int select = Util.sc.nextInt();
    	Util.sc.nextLine();  // 다음 String 변수에 엔터값이 들어가지 않도록 방지
    	
    	if(!(select>0 && select<5)) { 	
		  System.out.println("메뉴 선택이 올바르지 않습니다.");
		  System.out.println("초기메뉴로 이동합니다.");
		  return;
    	}
    	 
    	System.out.println("정보 입력을 시작합니다.");
    	System.out.println("이름 >> ");
    	String name = Util.sc.nextLine();
    	System.out.println("전화번호 >> ");
    	String phoneNum = Util.sc.nextLine();
    	System.out.println("주소 >>");
    	String addr = Util.sc.nextLine();
    	System.out.println("이메일 >>");
    	String email = Util.sc.nextLine();
    	
    	switch (select) {
    	case 1 : //인스턴스 생성 -> 배열에 저장
    		addInfor(new PhoneInfor(name, phoneNum, addr, email));
    		break;
    	case 2 : // 추가정보를 받고 -> 인스턴스 생성 -> 배열에 저장
    		//전공, 학년 
    		System.out.println("전공>>");
    		String major = Util.sc.nextLine();
    		System.out.println("학년>>");
    		int grade = Util.sc.nextInt();
    		addInfor(new UnivPhoneInfor(name, phoneNum, addr, email, major, grade));
    		break;
    	case 3 : // 추가정보를 받고 -> 인스턴스 생성 -> 배열에 저장
    		// 회사이름
    		System.out.println("회사 이름>>");
    		String company = Util.sc.nextLine();
    		addInfor(new CompanyPhoneInfor(name, phoneNum, addr, email, company));
    		break;
    	case 4 : // 추가정보를 받고 -> 인스턴스 생성 -> 배열에 저장
    		// 동호회 이름, 닉네임
    		System.out.println("동호회 이름>>");
    		String cafeName = Util.sc.nextLine();
    		System.out.println("닉네임>>");
    		String nickName = Util.sc.nextLine();
    		addInfor(new CafePhoneInfor(name, phoneNum, addr, email, cafeName, nickName));
    		break;    	
    	}
    	
    System.out.println("입력하신 정보가 저장되었습니다. (저장개수 :"+cnt+")");
  }
    
    
    
    // 2) 정보 저장 메서드
    // 배열의 index를 찾는 메서드
    private int searchIndex(String name) {
    	int index = -1; // 정보가 없을 때 
    	for(int i=0; i<cnt; i++) {
    		//이름으로 비교
    		if(pBook[i].getName().equals(name)) {
    			index = i;
    		}
    	}   	
    	return index;
    }
    
    // 해당 index의 참조변수로 정보 출력  : 사용자가 입력한 이름으로 검색
    public void searchInfo() {
    	if(cnt==0) {
 		   System.out.println("저장된 데이터가 존재하지 않습니다.");
 		   return;
 	   }
    	System.out.println("검색하실 이름을 입력해주세요.");
    	Util.sc.nextLine();
    	String name = Util.sc.nextLine();
    	
    	int index = searchIndex(name);
    	if(index<0) {
    		System.out.println("검색하신 이름 "+name+" 의 정보가 존재하지 않습니다.");
    	    System.out.println("메뉴로 돌아갑니다");
    	} else {
    		System.out.println("검색결과 =============");
    		pBook[index].showInfor();
    	}
    }
 
    
   // 3) 삭제 메서드
   // 사용자에게 이름을 입력받고 이름으로 검색한 후 정보 삭제
    public void deleteInfor() {    	
    	if(cnt==0) {
 		   System.out.println("저장된 데이터가 존재하지 않습니다.");
 		   return;
 	   }
    	Util.sc.nextLine();
    	System.out.println("삭제하고자 하는 정보의 이름을 입력해주세요");
    	String name = Util.sc.nextLine();
    	int index = searchIndex(name);
    	if(index<0) {
    		System.out.println("찾으시는 "+name+" 의 정보가 존재하지 않습니다.");
    		System.out.println("메뉴로 이동합니다.");
    	} else {
    		// 배열의 요소를 왼쪽으로 시프트
         for(int i=index;i<cnt-1;i++) {
        	 pBook[i] = pBook[i+1];
         }
         cnt--; //저장된 개수를 감소
         System.out.println("요청하신 이름의 정보를 삭제하였습니다.");
    	}
    }
    
    
   
    // 4) 전체 정보 출력 메서드
   public void showAllInfor() {
	   if(cnt==0) {
		   System.out.println("저장된 데이터가 존재하지 않습니다.");
		   return;
	   }
    	System.out.println("전체 정보를 출력합니다.=============");
    	for(int i=0;i<cnt;i++) {
    		pBook[i].showInfor();
    		System.out.println("-----------------------");
    	}
    }
    
    
    
}
