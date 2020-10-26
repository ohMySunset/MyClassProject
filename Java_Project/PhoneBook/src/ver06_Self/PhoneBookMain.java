package ver06_Self;

import java.util.InputMismatchException;

import ver03.Util;

public class PhoneBookMain implements Util {

	public static void main(String[] args)  {
		
		PhoneBookManager manager = PhoneBookManager.getInstance();
		
		while(true) {	
			
							   
				System.out.println("메뉴를 입력해주세요.=======");
				System.out.println(Menu.INSERT+". 저장");
				System.out.println(Menu.SEARCH+". 검색");
				System.out.println(Menu.DELETE+". 삭제");
				System.out.println(Menu.SHOWBASIC+". 기본 정보 출력");
				System.out.println(Menu.SHOWALL+". 모든 정보 출력");
				System.out.println(Menu.EXIT+". 종료");
				
				System.out.println("\n>>");		
			
			int select = 0;	//  try구문 밖에서 초기화
			
			// 예외가 발생할 수 있는 부분
			try {								
			select = sc.nextInt();		
			
			if(!(select>=Menu.INSERT && select<=Menu.EXIT)) { 	
			   MenuMismatchException ext = new MenuMismatchException(String.valueOf(select));
			   throw ext;		
			}	
			// 주어진 메뉴를 제외한 숫자 혹은 특수문자를 입력했을 때 예외처리
			} catch ( MenuMismatchException | InputMismatchException e){
				System.out.println("메뉴의 선택이 올바르지 않습니다.\n"+ "다시 선택해주세요.");
				Util.sc.nextLine();
				continue;
			} catch (Exception e) {
				System.out.println("메뉴의 선택이 올바르지 않습니다.\n"+ "다시 선택해주세요.");
				Util.sc.nextLine();
				continue;
			}
			
			
			switch (select) {
			case Menu.INSERT :
				manager.insertInfor();
				break;
			case Menu.SEARCH :
				manager.searchInfor();
				break;
			case Menu.DELETE :
				manager.deleteInfor();
				break;
			case Menu.SHOWBASIC :
				manager.showShortInfo();
				break;
			case Menu.SHOWALL :
				manager.showAllInfor();
			    break;
			case Menu.EXIT :
				System.out.println("프로그램을 종료합니다.");
				return;	
			}			
					
		}
	        
		
}
}
