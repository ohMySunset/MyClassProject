package fruit.ver02;

/*
파일이름 : FruitSeller.java
설명 : 사과 장수의 객체를 정의 
작성일시 : 2020.10.08
수정내용 : fruit.FruitSeller.java 를 기반으로 생성자를 추가.

*/

public class FruitSeller { //과일 판매자 입장

	// 클래스에는 변수와 메서드를 정의한다.
	// 공통된 특징, 성격을 가진 변수와 메서드를 정의해야 한다.

	
	//1. 변수 : 인스턴스 변수, 멤버 변수 // {}안에 있는 문장끼리는 바로 호출할 수 있다.

	// 수정 : 2020.10.08
	//      변수의 초기화를 생성자에서 처리, 변수 선언시의 초기화 코드 삭제	
	// int appleprice = 1000; // 사과의 가격
	final int APPLE_PRICE; // 사과의 가격, 변경이 불가하도록 상수처리
	private int numOfApple; // 사과의 보유 개수
	private int myMoney; // 수익 금액

	//2020.10.08 생성자 추가
//	FruitSeller(){
//		this(0, 20, 1000);
//	}
	FruitSeller(int money, int num, int price){
		APPLE_PRICE = price;
		numOfApple = num;
		myMoney = money;
	}
	
	FruitSeller(FruitSeller seller){
//		APPLE_PRICE = seller.APPLE_PRICE;
//		numOfApple = seller.numOfApple;
//		myMoney = seller.myMoney;
		this(seller.myMoney, seller.numOfApple, seller.APPLE_PRICE);
	}
	
	
	//2. 기능 : (1)판매, (2)정산 출력
	
	// (1) 판매 매서드 : 
	// 돈을 받고 ->
	// 반환하는 사과의 개수 선언 
	// 수익금 증가      
	// 보유한 사과의 개수가 감소 ->
	// 사과의 개수 반환 
	
                    // ┌호출되면서 값이 입력되기 때문에 따로 초기화 필요없음
   int saleApple(int money) { //매개변수 money -> 받은 돈
    	int num = 0     ; //반환할 사과의 개수, 블럭안의 지역변수는 반드시 초기화 해주어야함.
    	//반환할 사과의 개수를 구한다
    	num = money/APPLE_PRICE; //받은 돈 / 사과의 가격
    	//수익금 증가
    	myMoney = myMoney + money;
    	//사과의 개수가 감소
    	numOfApple = numOfApple - num;    	
    	return num;
    }
   
    // (2) 정산 매서드 : 
    // 보유한 사과의 개수를 출력
    // 보유한 금액 출력
     public void showSaleResult() { //반환할 값이 없으므로  반환 타입을 void타입으로 메서드 정의
      System.out.println("현재 보유한 사과의 개수 :" + numOfApple);
      System.out.println("판매 수익 금액 :" + myMoney);
    }
    
}
