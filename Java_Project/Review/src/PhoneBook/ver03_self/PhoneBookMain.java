package PhoneBook.ver03_self;

public class PhoneBookMain {

	public static void main(String[] args) {
		
	 //PhoneBookManager를 참조할 인스턴스 생성
	   PhoneBookManager bm = new PhoneBookManager(); 
		
	 //프로그램 구성	
	 //switch문으로 메뉴를  구성한다.
	while(true) {
	   System.out.println("==========전화번호 프로그램==========");
	   System.out.println("메뉴를 선택해주세요!");
	   System.out.println("1. 정보 저장");
	   System.out.println("2. 정보 검색");
	   System.out.println("3. 정보 삭제");
	   System.out.println("4. 정보 출력");
	   System.out.println("5. 프로그램  종료");
	   System.out.println("===============================");
	   
	   int insertNum = Util.sc.nextInt();
	   switch(insertNum) {
	                 case 1 :
	              bm.saveInfo();
	                 break;
	                 case 2 :
	              bm.findinfo();
	                 break;
	                 case 3 :
	              bm.deleteInfo();
	                 break;
	                 case 4 :
	              bm.showAll(); 
	                 break;
	                 case 5 :
	              System.exit(0);
	                 break;
	   }
	   
	
	}
	
	}
}
