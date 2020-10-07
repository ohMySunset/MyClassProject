package NewFruit;

public class FruitMain {

	public static void main(String[] args) {
	
	//판매자 클래스의 인스턴스생성과 현재 상황 출력	
    Seller seller1 = new Seller(1, 30, 0, 1500);    
    Seller seller2 = new Seller(2, 20, 0, 1000);	
    
    //구매자 클래스의 인스턴스생성과 현재 상황 출력	
    Buyer buyer = new Buyer();
    
    System.out.println("=====================================");
    
    //구매자와 판매자간의 주고 받는 메서드를 실행
    buyer.buyApple(seller1, 4500);
    buyer.buyApple(seller2, 2000);
    
    //결과값 출력
    System.out.println("\n판매자 1의 현재 상황");
    seller1.showsaleresult();
    
    System.out.println("\n판매자 2의 현재 상황");
    seller2.showsaleresult();
    
    System.out.println("\n구매자의 현재 상황");
    buyer.showbuyresult();
    
    
	}

}
