package Inheritance;

public class CarMain {
		
		//문제 1. 상관관계에 놓여있는 클래스의 생성자 정의 및 호출방식에 대해 알아보았다.  
		//이 내용을 바탕으로 다음 클래스에 적절한 생성자를 넣어보자.  
		//그리고 이의 확인을 위한 main메서드로 적절히 정의 해 보자. 		 
		
	public static void main(String[] args) {
		
		//클래스 멤버도 상속의 대상이다. 클래스멤버는 한번만 생성, 자손클래스의 이름으로도 참조, 호출이 가능.				
		System.out.println(Car.name);
		System.out.println(HybridCar.name);
		System.out.println(HybridWaterCar.name);
			
		Car car1 = new Car(100);
		HybridCar car2 = new HybridCar(100,50);
		HybridWaterCar car3 = new HybridWaterCar(100,50,40);
		
		car3.showCurrentGauge();
		
	}
		
  static class Car {  
	   static String name = "CAR";	
		
			int gasolinegauge;	
			
			Car(int gasolinegauge){ 
				this.gasolinegauge = gasolinegauge;		
			}
			
			} 
		
  static class HybridCar extends Car {
			
			int electronicGauge; 

			 HybridCar(int gasolinegauge, int electronicGauge) {
			 //조상 클래스의 멤버를 초기화 하는 생성자 호출 (무조건 먼저)
			 super(gasolinegauge);
			 // 새롭게 정의한 클래스의 멤버를 초기화
			 this.electronicGauge = electronicGauge;
			}
			
			} 
  static class HybridWaterCar extends HybridCar {
			
			int waterGauge; 
			
			HybridWaterCar(int gasolinegauge, int electronicGauge, int waterGauge){
				super(gasolinegauge,electronicGauge);
				this.waterGauge = waterGauge;				
			}
						
			public void showCurrentGauge() { 
				System.out.println("잔여 가솔린 : " + gasolinegauge);  
				System.out.println("잔여 전기 : " + electronicGauge);  
				System.out.println("잔여 Water : " + waterGauge);  
				
				} 
			}
		

		
	}


