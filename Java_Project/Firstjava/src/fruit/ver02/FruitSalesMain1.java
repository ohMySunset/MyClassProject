package fruit.ver02;

public class FruitSalesMain1 {

	public static void main(String[] args) {
		
     //FruitSeller타입의 참조변수 선언
		FruitSeller seller = null;
	 //FruitSeller의 객체생성
	 // 객체의 생성은 클래스에 정의된 멤버(변수, 메서드)들을 메모리에 등록하는 것	
		seller = new FruitSeller(0, 30, 1500); //객체생성 후 객체의 주소값을 반환한다.
		
		FruitSeller seller2 = new FruitSeller(0, 10, 2000);
			
	//seller 3
	FruitSeller seller3 = new FruitSeller(seller);
				
	 //FruitBuyer 타입의 참조변수 선언과 초기화
	 FruitBuyer buyer = new FruitBuyer(10000, 0);	
	 

	 
//=========================================================	 
// seller,buyer의 변수를 직접참조할 수 없도록 private처리 해주니 오류발생!
//	아래와 같이 직접참조하는 코드는 좋지 않음.
//  seller.myMoney += 500;
//	buyer.myMoney -= 500;
	 
//    seller.numOfApple -= 20;	 
//	buyer.numOfapple  += 20;
//==========================================================	 
	 
		
	 // 사과를 구매 : 2000 지불
	 buyer.buyApple(seller, 3000);
	 
	 // 사과 구매 : 4000지불
	 buyer.buyApple(seller2, 4000);
	 
	 buyer.buyApple(seller3, 3000);
	 
	 System.out.println("판매자1의 현재 지표");
	 seller.showSaleResult();
	 
	 System.out.println("판매자2의 현재 지표");
	 seller2.showSaleResult();
	 
	 System.out.println("판매자3의 현재 지표");
	 seller2.showSaleResult();
	 
	 
	 System.out.println("--------------------------------");
	 
	 System.out.println("구매자의 현재 지표");
	 buyer.showBuyResult();
	 
		
		
//     	String s = "FruitSeller";
//        seller = s;
	}

}
