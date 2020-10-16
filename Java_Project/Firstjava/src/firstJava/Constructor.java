package firstJava;

public class Constructor {

//	    생성자(constructor)
/*	   
	      인스턴스가 생성될 때마다 호출되는 인스턴스 초기화 메서드.(한번 실행)
	      인스턴스 변수의 초기화 기능 -> 인스턴스 변수에 적절한 값을 저장.
	                                                메서드를 이용하면 언제든지 값의 변경이 가능하기 때문에 좋지않음.
	                        final상수의 초기화도 가능
	      모든 클래스에는 반드시 하나 이상의 생성자가 있어야함.
	      리턴값이 없지만 void를 쓰지 않음
	      
	     ┌ 생성자의 이름은 클래스 이름과 같다.
	     클래스이름 (타입 변수명, 타입변수명,...){
	              인스턴스 생성시 수행될 코드  
	              인스턴스 변수의 초기화 코드!
	    }
	   
	     인스턴스 생성시 생성자는 반드시 호출됨! 
	    
	     ★생성자도 오버로딩이 가능하다!
	     오버로딩? -> 생성자의 이름은 같지만 매개변수와 개수가 다르거나 타입이 다름
	     키워드 this를 이용하면 다른 생성자 호출 가능
	     참조변수 this를 이용하여 같은 이름의 변수를 구별하여 사용할 수 있다.

*/
		
	
//	 < 변수의 초기화  >  
/*	 
	 변수 선언 후 처음으로 값을 정하는것.
	 멤버변수와 배열은 기본값으로 자동초기화 -> 생략가능
	 지역변수는 사용전에 초기화가 필수 !
	 
	 - 멤버변수의 초기화 
	 1) 명시적 초기화  ex) Fruit f = new Fruit();
	 2) 생성자  -> 변수의 초기화 多
	 3) 초기화 블럭 { }-> 복잡한 연산의 초기화
      static가 인스턴스 보다 빨리 처리 , 생성자 보다 블럭이 더 빨리 처리
	  + BlockTest.java 참고
	  
	 - 초기화 시기
	  클래스변수 초기화 -> 클래스가 처음 로딩될 때 단 한번
	  인스턴스변수 초기화 -> 인스턴스가 생성될 때 마다
	  
	  
*/
   
	
	
	
}