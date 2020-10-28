package ver07;

public interface Menu {

	
	public static final	 int     INSERT= 1, 
			                	SEARCH= 2,
				                DELETE= 3,
				                SHOWBASIC= 4,
				                SHOWALL = 5,
				                EXIT = 7;
      
	//2020.10.27 : 인스턴스를 저장하는 메뉴 추가
	int SAVE = 6;
	
	
	public static final	 int    STANDARD= 1,
	                            UNIV= 2,
			                    COM = 3,
			                    CAFE= 4;
				
}
