package NewFruit;

public class Buyer {

	int myMoney;
	int numOfApple;
	
	Buyer(){ //생성자 호출
		myMoney = 10000;
		numOfApple = 0;
		System.out.println("구매자가 보유한 사과 :"+ numOfApple +" 구매자가 가진 금액:" + myMoney);
	}
	                
	public void buyApple(Seller sell, int money) { 
		                    //메인메서드 실행하면 인수값 호출>> 매개변수 자리에 seller1과 seller2의 인스턴스값이 들어옴
		numOfApple += sell.saleApple(money); //판매자클래스>>saleApple메서드 실행>>리턴값 불러옴
	    myMoney -= money;	
	}
	//결과값
	public void showbuyresult() {
		System.out.println("구매자가 보유한 사과 개수 :"+ numOfApple);
		System.out.println("구매자의 현재 잔액 :" + myMoney);
	}		
	
}
