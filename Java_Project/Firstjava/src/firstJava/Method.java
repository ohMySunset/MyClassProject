package firstJava;

public class Method {

	public static void main(String[] args) {

				/*
	 
   ★ 객체가 가지는 함수 -> 메서드 -> 기능, 행위
   ★ 함수 -> 특정 1.데이터를 받고 2.처리한 후 3.결과값을 반환하는 기능 
      (but, 입력받는 값이 없을 수도 있고, 결과를 돌려주지 않을수도 있다)
  
   자바는 객체 지향이기 때문에 함수가 없고 메서드가 존재, 기능은 같다.
   
   데이터(숫자,문자열,boolean,참조값)
             ▼
                     숫자  * 숫자                             --> 이러한 일련의 과정을 code화 시킨것 = 함수
   		     ▼
   		        반 환
   
     메서드 이름 main
   public static void main(String[] args)
      자바프로그램의 시작은 main 이라는 이름의 메서드를 실행하는데서 시작!  
    
    메서드는 언제 사용?
   - 공통,반복되는 코드를 줄일 때
   - 반복되는 문장을 쓸 때 
   
                             ┌ (1)매개변수 정의
   ★ 리턴타입 메서드이름(타입 변수명, 타입 변수명, ...)
     └ 어떤 타입으로 결과를 반환할건지 설정. 
   {
           메서드 호출시 수행될 코드 ((2)처리)
     ((3)return --> 결과값은 리턴타입과 같아야 한다.)    
   }   
   
   void -> 반환값이 없다. 반환하지 않는다. 리턴타입 대신 void 사용     
   */	
			
		{
	MyMeth my = new MyMeth(); //인스턴스(객체)생성. 만들어놓은 클래스를 메모리에 올려줌.
	   //  └참조변수 
	System.out.println(my.add(1,5));
	
	my.sayHello(); //메서드에 만들어 놓은 출력구문을 실행
   //참조변수.메서드
	
	my.plus(10, 20);
	
	System.out.println(my.check());
	
	my.divide(10, 2);
	my.divide(10, 0);
	
	//System.out.println(true);  오버로딩
		
    }
		hiEveryone(); 
	}
		
	static void hiEveryone() {
		System.out.println("안녕하세요!");
	
	/*
	 return -> 종료
	 메서드의 블럭{}끝에 도달했을 때
	 메서드의 블럭{}을 수행 도중 return을 만났을 때	 	
	 
	 - return은 최소한으로 사용!
	 int max(int a, int b){
	     int result = 0;
	     if(a>b)
	     result = a;
	     else
	     result = b;
	     return result;
	     }
	 */
	
	/*
	 메소드 오버로딩
         ※매개변수 타입이 다르거나 개수가 다르면,
	하나의 클래스에 동일한 이름의 메소드를 둘 이상 동시에 정의 할 수 있다.	 	 	
	 */

		
   /*
         클래스, 메서드, 변수의 이름 -> 식별자 -> 한글 사용X 
    	                                                          숫자로 시작X
    	                          _, $를 제외한 특수문자 사용불가
    	                                                          
     클래스 이름 -> Camel Case
             대문자로 시작, 둘 이상의 단어일 시 새 단어는 대문자로 시작 (MyClass)
     변수, 메서드의 이름 -> 변형된 Camel Case
             소문자로 시작, 둘 이상의 단어일 시 새 단어는 대문자로 시작 (myMoney)             
     상수 이름 ->               
             전부 대문자로 표현,둘 이상의 단어일 시 두 단어 사이에_삽입(COLOR_RAINBOW)
	
	*/	
		
}
}
