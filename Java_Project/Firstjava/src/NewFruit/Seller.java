package NewFruit;

public class Seller {
 
	//변수 선언
	int numOfApple;
	int myMoney;
	int man;
	final int APPLE_PRICE;
	
	//생성자 호출 및 인스턴스 변수 초기화
	public Seller(int man, int appleNum, int money, int Price) { 
		this.man = man;
		numOfApple = appleNum;
		myMoney = money;
	    APPLE_PRICE = Price;
	    System.out.println(man+"번 판매자가 보유한 사과의 수 :"+appleNum+" 사과의 가격 :"+ Price);
	}
      
	//판매자의 기능
    public int saleApple(int money) { //사과를 파는 프로세스
		int num = money/APPLE_PRICE;
        numOfApple -= num;
        myMoney += money;
        return num;    	
}
    //결과값
    public void showsaleresult() {
    	System.out.println("남은 사과의 개수 :"+ numOfApple);
        System.out.println("판매수익 :" + myMoney);
    }
   
    
    
    
}