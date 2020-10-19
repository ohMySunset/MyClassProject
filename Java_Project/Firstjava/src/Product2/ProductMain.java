package Product2;

public class ProductMain {

	public static void main(String[] args) {
		
		Buyer b = new Buyer(5000, 10);
		
	//	Tv tv = new Tv(150);
	//	Computer com = new Computer(100);
	//	Audio audio = new Audio(50);		
		
		
		b.buy(new Tv(5000));
		b.buy(new Computer(100));
		b.buy(new Audio(50));
		
		
		b.showData();
		
		
	}

}
