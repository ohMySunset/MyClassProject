package fruit.ver02;

/*
파일이름 : FruitBuyer.java
설명 : 사과 장수의 객체를 정의 
작성일시 : 2020.10.08
수정내용 : fruit.FruitBuyer.java 를 기반으로 생성자를 추가.

*/

public class FruitBuyer { //과일 구매자 입장

	//변수와 메서드 정의
	
	// 수정 : 2020.10.08   변수의 초기화 코드 생략
	//구매자의 소유 금액, 소유한 사과의 개수
	private int myMoney;  // 구매자의 보유 금액
	private int numOfapple;  // 보유한 사과 개수
	
	//2020.10.08 : 생성자 정의, 변수의 초기화 목적
//	public FruitBuyer() {
//			this(5000, 0);
//	}
		
	public FruitBuyer(int myMoney, int numOfapple) {
		this.myMoney = myMoney; //this -> 자신을 가르키는 참조변수
		this.numOfapple = numOfapple;
	}


	// 기능 : (1)사과 구매, (2)현재 상태값(금액, 사과의 개수)를 출력  -> 반환되는 값이 없음.
	
	// (1)사과 구매 :
	// 판매자 정보(객체)와 금액을 받아
	// 판매자의 판매 메서드 호출 >> 구매하는 사과의 개수를 얻는다.
	// 나의 사과의 개수를 증가
	// 나의 보유 금액을 감소
	
	// 참조변수는 객체의 주소를 저장하고 있다. -> 셀러의 참조값을 받도록 참조변수를 매개변수로 정의한다
	// FruitSeller seller -> FruitSeller 클래스로 만든 객체의 주소를 저장하는 변수
	public void buyApple(FruitSeller seller, int money) { 
		
		// 구매할 사과의 개수를 구한다.
		int num = seller.saleApple(money); //여기서 호출한 seller의 메서드를 실행 후 반환된 값이 들어옴.
		// 나의 사과의 개수를 증가
		numOfapple += num;
	    // 나의 보유 금액이 감소
		myMoney -= money;
	}	
	

	//(2)현재 상태값(금액, 사과의 개수)를 출력	
	public void showBuyResult() {
		System.out.println("보유금액 ; "+ myMoney);	
	    System.out.println("보유한 사과의 개수 : "+ numOfapple);
	}
	
	
	
}
