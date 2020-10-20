package Product2_Self;

public class ProductClass {
	// 변수설정
	private int price;
	private int bonusPoint;
	
	// 생성자로 초기화, 금액만 입력받을 것.
	public ProductClass(int price) {
		this.price = price;
		this.bonusPoint = (int)(price*0.1f);  //가격의 10%가 보너스로 적립
	}

	// 게터 설정
	public int getPrice() {
		return price;
	}
	public int getBonusPoint() {
		return bonusPoint;
	}
	
    // object클래스를 오버라이딩
	@Override
	public String toString() {
		return "ProductClass [price=" + price + ", bonusPoint=" + bonusPoint + "]";
	}	
	}



//Tv 클래스 
class Tv extends ProductClass{

	public Tv(int price) {
		super(price);

	}
	
	@Override
	public String toString() {
		return "Total $"+ getPrice()+", Tv";
	}
}	

//Computer 클래스
class Computer extends ProductClass{

	public Computer(int price) {
		super(price);	
	}

	@Override
	public String toString() {
		return "Total $"+getPrice()+ ", Computer";
	}
	
}
//Audio 클래스
class Audio extends ProductClass{

	public Audio(int price) {
		super(price);		
	}

	@Override
	public String toString() {
		return "Total $"+getPrice()+", Audio";
	}
	
}

class Buyer{
	// 구매자의 돈과 보너스 포인트
	int money;
	int bonusPoint;
	int cnt;
	
	// 물건을 담을 장바구니 배열생성
	ProductClass[] cart;
	
	// 생성자로 초기화
	Buyer(){
		this(10000, 10);
	}	
	Buyer(int money, int cnt) {
		this.money = money;
		bonusPoint = 0;
		cart = new ProductClass[cnt];
		cnt = 0;
	}
	
	public void buy(ProductClass p) {				
		// 구매 프로세스
		if(p.getPrice()>money) {
			System.out.println("소지 금액이 부족합니다.");
			return;
		}
		
		money -= p.getPrice();
		bonusPoint += p.getBonusPoint();		
		// 배열에 구매한 품목을 저장
		cart[cnt++] = p;
				
		System.out.println(p+"를 구입했습니다.");
	}
	
	// 데이터 출력메서드
    public void showData() {
    //	System.out.println("남은 금액 : " + money);
    //	System.out.println("보너스 포인트 : "+ bonusPoint);
    
    	int sum = 0; //총 구매 금액
    	
    	System.out.println("-----장바구니-----");
    for(int i=0; i<cnt; i++) {
    	System.out.println(cart[i]); // 구매한 목록
    	sum += cart[i].getPrice();   // 총 구매 금액
    }
    System.out.println("총 구매금액 :$ "+ sum);
    System.out.println("남은 돈 :$ "+ money);
    System.out.println("보너스 포인트 : "+ bonusPoint);
       
    }
	
}



	
