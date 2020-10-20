package firstJava;

public class Interface {

	public static void main(String[] args) {
		
		/*
		 interface 클래스 : 추상클래스의 일종이다
		                                       실제 구현된 것이 전혀 없는 기본 클래스 .
		                                       추상메서드와 static상수형태의 변수만을 멤버로 가짐! (java jdk_9 이하 버전까지)
		                                       인스턴스 생성 불가, 규칙과 가이드를 정의하여 하위클래스 작성에 도움을 줄 목적
	                                                상속, 다형성(하위클래스의 인스턴스 참조),매개변수 타입, 리턴 타입 모두 가능
		// 인터페이스의 구현                   
		class 클래스명  implements 인터페이스 이름 {         
		           └> 클래스가 인터페이스를 상속, 구현한다.
		}		 
		-> 인터페이스를 구현하는 것 = 클래스를 상속 받는것.
		
		// 인터페이스 선언
				interface 인터페이스 이름 {
		public static final 타입 상수이름 -> 상수
		public abstract 메서드 이름   -> 추상메서드
	
		}
		// 상수의 표현
		 * 인터페이스이름.상수이름 
		 
		★인터페이스의 역할 : 두  결과물의 연결고리가 되는 약속.
		
		- 다중 상속이 가능하다! -> 잘 사용하지 않음.
		- 상속과 구현이 동시에 가능하다!
		ex)
		class Fighter *extends Unit *implements Fightable{
		
		Fighter < Unit < object
		Fighter < Fightable		
		}
		
		마킹 -> instanceof와 함께 사용
		
		
		 */
		
		
	}

}
