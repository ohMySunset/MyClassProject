package ver06_Self;

import java.util.ArrayList;
import java.util.InputMismatchException;

import ver03.Util;

public class PhoneBookManager  {

	
	// 정보를 저장할 배열 선언
	private ArrayList<PhoneInfor> list;
	
	
	// 생성자를 통한 초기화
	private PhoneBookManager(int num) {
		list = new ArrayList<PhoneInfor>();	
		num = 0;
	}


    // PhoneBookManager타입의 인스턴스 싱글톤 처리
	// 인스턴스 생성 -> 미리 생성되어 있어야 하므로 static
	private static PhoneBookManager manager = new PhoneBookManager(100); 
	// 인스턴스를 호출할 수 있는 메서드 
	public static PhoneBookManager getInstance() {
		return manager;
	}
	
		
	// 정보 저장 메서드
	// 1) 배열에 정보를 추가하는 메서드
	void inputArray(PhoneInfor p) {
	   list.add(p);
	}
	
	
	// 2) 사용자로부터 입력받은 정보를 분류하여 인스턴스 생성.
	// 인터페이스 기반의 상수처리를 하여 메뉴 구성
	public void insertInfor() {
						
			System.out.println("어떤 정보를 입력하시겠습니까?");
			System.out.println(Menu.STANDARD+". 일반");
			System.out.println(Menu.UNIV+". 대학");
	    	System.out.println(Menu.COM +". 회사");
	    	System.out.println(Menu.CAFE +". 동호회");	    		
	    	
	    	int select = 0;
	    	
	    	// 예외가 발생할 수 있는 부분
	    	try {
	    	select = Util.sc.nextInt();
	    	Util.sc.nextLine();	   
	    	
	    	if(!(select>=Menu.STANDARD && select<=Menu.CAFE)) { 	
	    		MenuMisMatch e = new MenuMisMatch("메뉴의 선택 오류");
	    		throw e;
	  	    }
	    	// 주어진 메뉴를 제외한 숫자 혹은 특수문자를 입력했을 때 예외처리
	    	} catch(InputMismatchException | MenuMisMatch e){
	    		System.out.println("메뉴의 선택이 올바르지 않습니다.\n"+ "다시 선택해주세요.");
	    	} catch (Exception e) {
				System.out.println("메뉴의 선택이 올바르지 않습니다.\n"+ "다시 선택해주세요.");
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
	    	case Menu.STANDARD :
	    		inputArray(new PhoneInfor(name, phoneNum, addr, email));	    	
	    		break;
	    	case Menu.UNIV : 
	    		//전공, 학년 
	    		System.out.println("전공>>");
	    		String major = Util.sc.nextLine();	    	
	    		System.out.println("학년>>");
	    		int grade = Util.sc.nextInt();
	    		Util.sc.nextLine();
	    		inputArray(new UnivPhoneInfor(name, phoneNum, addr, email, major, grade));
	    		break;
	    	case Menu.COM : 
	    		// 회사이름
	    		System.out.println("회사 이름>>");
	    		String company = Util.sc.nextLine();
	    		inputArray(new CompanyPhoneInfor(name, phoneNum, addr, email, company));
	    		break;
	    	case Menu.CAFE : 
	    		// 동호회 이름, 닉네임
	    		System.out.println("동호회 이름>>");
	    		String cafeName = Util.sc.nextLine();
	    		System.out.println("닉네임>>");
	    		String nickName = Util.sc.nextLine();
	    		inputArray(new CafePhoneInfor(name, phoneNum, addr, email, cafeName, nickName));
	    		break;	    		
	    	}   		    	
	    	System.out.println("입력하신 정보가 저장되었습니다.[저장개수 :"+list.size()+"]");	 	    		
		}
	

	// 2) 정보 검색 메서드
	// 입력한 이름과 비교해서 인덱스를 반환해주는 메서드
	public int searchIndex(String name) {
		int index = -1;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getName().equals(name))
				index = i;
		}				
		return index;
	}
	
		
	
	// 입력된 이름에 부합하는 정보를 출력하는 메서드
	void searchInfor() {	
		Util.sc.nextLine();
		if(list.size()==0) {
		   System.out.println("메모리에 저장된 정보가 없습니다.");
		   System.out.println("정보를 저장하신 후 다시 시도해주세요");
		   return;
		}
		System.out.println("검색하실 정보의 이름을 입력해주세요.");
		String name = Util.sc.nextLine();
		int index = searchIndex(name);
		if(index<0) {
			System.out.println("찾으시는 "+name+" 와(과) 일치하는 정보가 없습니다.");
			System.out.println("초기화면으로 돌아갑니다.");
			return;
		} else {
			System.out.println("검색 결과 >>");
			list.get(index).showInfor();
		}
	}
		
	
	// 3) 삭제 메서드
    // 사용자에게 이름을 입력받고 이름으로 검색한 후 정보 삭제
    public void deleteInfor() {    	
    	if(list.size()==0) {
 		   System.out.println("메모리에 저장된 정보가 없습니다."+"\n 정보를 저장하신 후 다시 시도해주세요.");
 		   return;
 	   }
    	Util.sc.nextLine();
    	System.out.println("삭제하고자 하는 정보의 이름을 입력해주세요");
    	String name = Util.sc.nextLine();
    	int index = searchIndex(name);
    	if(index<0) {
    		System.out.println("찾으시는 "+name+" 와(과) 일치하는 정보가 없습니다.");
    		System.out.println("초기화면으로 이동합니다.");
    	} else {
    		list.remove(index);
    		}    		
    		System.out.println("요청하신 이름의 정보를 삭제하였습니다.");
    	}	
    
   
    
    // 4) 기본 정보 출력 메서드
    public void showShortInfo() {
    	if(list.size()==0) {
  		   System.out.println("메모리에 저장된 정보가 없습니다."+"\n 정보를 저장하신 후 다시 시도해주세요.");
  		   return;
  	   }
    	System.out.println("기본 정보 출력 결과 >>");
    	for(int i=0;i<list.size();i++){
    		list.get(i).showBasicInfor();
     		System.out.println("----------------------");
       }   	
    }
    
    
  
    // 5) 전체 정보 출력 메서드
    public void showAllInfor() {
 	   if(list.size()==0) {
 		   System.out.println("메모리에 저장된 정보가 없습니다."+"\n 정보를 저장하신 후 다시 시도해주세요.");
 		   return;
 	   }
     	System.out.println("전체 정보 출력 결과 >>");
     	for(int i=0;i<list.size();i++) {
     		list.get(i).showInfor();
     		System.out.println("----------------------");
     	}
     }
    

}
    
	
	

