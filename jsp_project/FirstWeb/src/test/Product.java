package test;

// 상품 정보를 가지는 beans 형태로 정의
public class Product {
  	
	// 상품 목록
	private String[] productList = {"item1","item2","item3","item4","item5"};

    // 테스트 변수
	private int price = 100;
	private int amount = 1000;
	

	public Product() {
		super();
	}
	
	
	// getter 생성
	public String[] getProductList() {
		return productList;
	}
	public int getPrice() {
		return price;
	}
	public int getAmount() {
		return amount;
	}
	
	// 출력만 해주는 메서드
	public String getDisplay() {
		return "price : " + price + ", amount : " + amount;
	}
	
	
  


}
