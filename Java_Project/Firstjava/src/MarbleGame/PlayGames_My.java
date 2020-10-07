package MarbleGame;

public class PlayGames_My {

	// 어린이1, 어린이 2가 가진 구슬의 변수
	// 기존에 가지고 있던 구슬의 개수 어린이 1, 어린이2의 값을 구하는 메서드
	// 2차 게임 동안 주고, 받는 기능의 메서드 
	// 결과 출력
	
	

	int kid1Mable = 15;
	int kid2Mable = 9;
	
	void showKidsMables () {  // 아이들이 가지고 있는 구슬의 개수를 저장하고 출력
		System.out.println("어린이 1의 보유자산 : 구슬"+kid1Mable+"개");
		System.out.println("어린이 2의 보유자산 : 구슬"+kid2Mable+"개");
	}
	
	void play1Mables (int mables) { //1차 게임동안 아이들이 주고 받은 구슬		         
        int num = mables;
		kid1Mable = kid1Mable + num;
		kid2Mable = kid2Mable - num;
		System.out.println("1차 게임 결과 => 어린이1의 구슬:"+kid1Mable+" 어린이2의 구슬:"+kid2Mable);
	}
	
	void play2Mables (int mables) {	//2차 게임동안 아이들이 주고 받은 구슬				
		int num = 0;
			num =mables;
		kid1Mable = kid1Mable - num;
		kid2Mable = kid2Mable + num;
		System.out.println("2차게임 결과 => 어린이1의 구슬:"+kid1Mable+" 어린이2의 구슬:"+kid2Mable);
	}	
	
	
	

	public static void main(String[] args) {
		
		PlayGames_My p = new PlayGames_My(); //객체의 인스턴스화
		
		//클래스안의 메서드사용
		p.showKidsMables();  //아이들이 처음 보유하고 있던 구슬개수
		
		p.play1Mables(2);    //1차 게임 결과
		
		p.play2Mables(7);    //2차 게임 결과
		
		p.showKidsMables();  //아이들이 최종적으로 보유하고 있는 구슬개수
		
	}
	
	
	
}
