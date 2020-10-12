package firstJava;

public class MyMeth {

	//변수 선언   -> 멤버, 밑에 있는 메서드에서 다 사용할 수 있음
    int num;
    
    //정수 2개를 받아 덧셈 연산을 하고 그 결과를 반환하는 메서드
    //데이터의 형태에 따라 변수 설정
	long add(long n1, long n2) {
		
	   long result = n1 + n2;
	   
	   return result;
	}
	
	
	void sayHello() { 
		System.out.println("안녕하세요 여러분~!!");
	}
	
	
	
	//정수 두개를 받아서 덧셈의 결과를 출력하는 메서드
	void plus(int num1, int num2) {
		int result = num1 + num2; //result-> 변수의 이름이 같더라도 위의 메서드에서 실행된 변수와는 상관없이 독립적으로 실행
	 System.out.println(result);
	}  

	boolean check() {
		boolean result = num > 20;
		
	  return result;	
	}
	
	
	
	//정수 두개를 받아서 나눗셈한 결과를 출력하는 메서드 
	void divide(int num1, int num2){
	if(num2==0) {
		System.out.println("0으로 나눌 수 없습니다");
		return; //  메서드의 종료를 의미
	}		
		System.out.println("나눗셈의 결과 : " + num1/num2);
	
	
	}
}
