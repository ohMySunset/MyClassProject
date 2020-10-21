package ver06;

import ver03.Util;

public class PhoneBookMain {

	public static void main(String[] args) {
		
	PhoneBookManager manager = PhoneBookManager.getInstance();
	
	while(true) {			
		try {
			System.out.println("메뉴를 입력해주세요.=======");
			System.out.println(Menu.INSERT+". 저장");
			System.out.println(Menu.SEARCH+". 검색");
			System.out.println(Menu.DELETE+". 삭제");
			System.out.println(Menu.SHOWALLDATA+". 모든 정보 출력");
			System.out.println(Menu.EXIT+". 종료");
			
			System.out.println("\n>>");			
			
		String select = Util.sc.nextLine();	
		
		switch (select) {
		case Menu.INSERT :
			manager.insertInfo();
			break;
		case Menu.SEARCH :
			manager.searchInfo();
			break;
		case Menu.DELETE :
			manager.deleteInfor();
			break;
		case Menu.SHOWALLDATA :
			manager.showAllInfor();
		    break;
		case Menu.EXIT :
			System.out.println("프로그램을 종료합니다.");
			return;	
		}
		//공백문자 예외처리
		if(select ==" ") {  
			System.out.println("메뉴의 선택이 올바르지 않습니다.\n"+ "다시 선택해주세요.");
			continue;
		}		
		// 메뉴를 제외한 숫자 예외처리
		if(!(Integer.parseInt(select)>0 && Integer.parseInt(select)<6)){
				System.out.println("메뉴의 선택이 올바르지 않습니다.\n"+ "다시 선택해주세요.");
				continue;
		}			
		// 숫자가 아닌 경우 예외처리			
		 	Util.sc.nextLine();	
		} catch(NumberFormatException e) {
			System.out.println("메뉴의 선택이 올바르지 않습니다.\n"+ "다시 선택해주세요.");
			continue;
		}
	    break;
	    
		}
							
	}
	
	
	}

