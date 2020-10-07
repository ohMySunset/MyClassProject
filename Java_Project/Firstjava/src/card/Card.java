package card;

public class Card {

	String kind;   // 카드의 종류
	int number;    // 카드의 숫자
	
	Card(String kind, int number){ //생성자 호출
		this.kind = kind; // 블럭 안에서는 지역변수가 우선이기 때문에 this를 붙여서 인스턴스 변수와 구별
		this.number = number;
	}
	
	Card(){ //생성자의 오버로딩, 컨트롤키로 어떤 생성자를 가리키고 있는지 확인 가능
		this("spade", 1); // 다른 생성자를 호출
	}
	
	
	//클래스 변수 선언   -> 인스턴스를 생성해도 아무런 영향을 받지 않음.
	//               같은 클래스 안에서 실행은 되지만 클래스에 종속적이지 않다
	static int width = 100; // 카드의 폭
	static int height = 250; // 카드의 높이

	
  static void play() {  //인스턴스 메서드 
	  System.out.println("카드 놀이를 합니다.");
  }
	
}
