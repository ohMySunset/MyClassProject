package firstJava;

public class CastingTest {

	public static void main(String[] args) {
		
	 // 조상클래스 타입의 참조변수
		Car1 car = null;
		FireEngine fe = null;
		
		car = new FireEngine();
		fe = new FireEngine();
		
      //fe = new Car1();   에러   조상클래스는 자손클래스의 참조변수에 바로 대입할 수 없음. 
		
	    FireEngine fe2= null;
	    fe.water();
	   
	  // 형변환 연산 생략 가능  
	    car = fe;  // car = (car1)(fe);   Car1 = (Car1)FireEngine
	  //  car.water();  에러    //타입이 Car1이기 때문에 Water() 사용이 불가하다. 
	    
	   fe2 = (FireEngine)car;   //조상타입에서 자손타입으로의 형변환은 명시적으로 연산자를 사용해야함.
	   fe2.water();
	   
	   //car = new Ambulance();
	   
	   FireEngine f3 = null;
	   if(car instanceof FireEngine) {
		   f3 = (FireEngine)car;
		    f3.water();
	   } else {
		   System.out.println("불을 끌 수 없습니다. ");
	   }

	   
	}

}

class Car1{
	private String color;
	private int door;

  
 void drive() {
	 System.out.println("운전한다.");
 }
 void stop() {
	 System.out.println("멈춘다.");
 }

 }

class FireEngine extends Car1{
	void water() {
		System.out.println("물을 뿌린다.");
	}
}

class Ambulance extends Car1{
	
}