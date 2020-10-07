package card;


public class NumberMain {

	public static void main(String[] args) {

		//인스턴스생성과 동시에 생성자가 만들어짐.
		Number number = new Number(100); // 값을 입력하여쓸 수 있는 생성자
	
		Number num = new Number(); // 값을 받아서 쓸 수 있는 생성자
		
		System.out.println(number.getNumber());
		System.out.println(num.getNumber());
		
	}

}
