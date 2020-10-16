package product;

public class Buyer { //자동으로 object 클래스를 상속

	private int money;
	private int bonusPoint;
	
	// 구매한 제품을 담을 장바구니 배열 생성
	//Tv[] tv;
	//Computer[] com;
	//Audio[] audio;
	
	Product[] cart = new Product[10];
	int cnt =0; // 배열의 인덱스역할, 반복의 역할
	
	
	public Buyer() {
		this(1000);
	}
	
	public Buyer(int money) {
		this.money = money;
		this.bonusPoint = 0;
	}

// 아래의 형식을 형변환과 오버라이딩을 활용하여 간단하게 만들 수 있다!	
//	void buy(Tv tv) {
//	
//	}
//	
//	void buy(Computer com) {
//		
//	}
//	
//	void buy(Audio audio) {
//		
//	}
	
/*	이 단계를 생략하고 메인메서드에서 바로 오버라이딩한 클래스들을 불러올 수 있음.
	void buy(Product p) {
		Product p1 = new Tv(100);
		Product p2 = new Computer(100);
		Product p3 = new Audio(100);
	}
*/	
	
	
	// 구매자가 물건을 사는 메서드
	void buy(Product p) {  
		
	 if(money<p.price) {
		 System.out.println("보유한 돈이 부족해서 구매할 수 없습니다.");
		 return;
	 }
	 //제품금액에 따른 돈과 보너스 포인트의 변화
	 money -= p.price;
	 bonusPoint += p.bonusPoint;
	 
	 // 카트에 제품을 넣는다.
	 cart[cnt++] = p;  //p에 제품이 추가될때마다 배열의 길이 ++
	 
	  
	 System.out.println(p+"를 구입했습니다");  // 조상클래스 참조변수 p만 쓰면 toString메서드가 보여짐
	 
	}

	
	void showData() {
		System.out.println("남은 돈:" + money);
		System.out.println("보너스 포인트 :"+ bonusPoint);
		
	// 구매목록 출력, 구매 총액
	int sum = 0;
	
	 System.out.println("구매 목록==============");
   for(int i=0; i<cnt; i++) { 
		System.out.println(cart[i]);
	     sum+= cart[i].price;
	}
	System.out.println("=====================");
	System.out.println("총 구매 금액 : "+sum);
	System.out.println("보너스 포인트 : "+bonusPoint);
	System.out.println("남은 돈 :"+ money);
	
	
	}
	

}
