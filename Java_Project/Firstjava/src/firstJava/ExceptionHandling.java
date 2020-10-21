package firstJava;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {  //예외 처리

	public static void main(String[] args) {
	
		/*예외 처리
		 
		- 예외클래스
		  ArrayIndexOutOfBoundException : 배열에 잘못된 인덱스 값을 사용할 때
		  ClassCastException : 허용할 수 없는 형변환 진행 시
		  NegativeArraySizeException : 배열선언에서 배열의 크기를 음수로 지정할 때
		  NullPointerException : 참조변수가 null로 초기화된 상태에서 메서드를 호출할 때
		  
		  자바에 정의되지 않은 예외 클래스
		  사용자가 만드는 예외클래스 -> 직접 정의하여 예외상황을 강제로 발생
		  
		- 예외타입
		 
		 ex) 나이를 입력하세요.
		    입력값이 -20, ten 같은 경우 오류발생.
		  
		
		- 오류의 분류
		  1. 에러 -> 메모리 부족 등의 이유로 발생하면 코드로 복구할 수 없음.  
		  2. 예외  -> 적절한 코드를 미리 작성함으로써 충분히 수습할 수 있음.
		                         목적 : 프로그램의 비정상적 종료를 막고, 정상적인 실행상태 유지.
		
		
		  *try-catch
		예외를 처리할 때 사용. --> 트렌잭션 처리에 유용. 여러가지 처리 과정중에 오류가 생기면 다시 처음부터 
		
		try{
		     // 예외가 발생할 가능성이 있는 코드
		     // 예외는 아니지만 정상처리가 됐을 때 진행되야 하는 코드도 들어감! (예외가 아닐 시에 실행되야 하기 때문에)
		     // 순서대로 검증하면서 내려가고
		     // try블럭 안에서 예외가 발생하면 -> 바로 예외타입의 인스턴스와 일치하는 catch블럭을 찾으러 내려감.
		} catch ( Exception1 e1) {  
		        Exception1이 발생했을 경우, 어떤 처리를 할 것인지
		} catch ( Exception2 e2) {
		          Exception2이 발생했을 경우, 어떤 처리를 할 것인지
		}
		  위에서부터 아래로 검증하면서 내려가고, 위에서 예외가 해결되면 아래의 catch는 무시하고 멈춤.
		  만약, catch블럭을 찾지 못하면 예외는 처리되지 않음.  
		  
		*/
		
		// ex)
		//DivideByZero
		Scanner sc = new Scanner(System.in);
		
		int num1 = 0, num2 = 0;
		
		while(true){  // 예외를 거르고 입력을 반복하기 위해서 
		try {
			System.out.println("두 개의 정수를 입력해주세요.");		
			System.out.println("숫자 1>>");
		    num1 = sc.nextInt();
		    sc.nextLine();
		    System.out.println("숫자 2>>");
			num2 = sc.nextInt();
			sc.nextLine();
		} catch(InputMismatchException e){
			System.out.println("올바른 메뉴를 선택하지 않았습니다.");
			System.out.println("다시 선택해주세요.");
			sc.nextLine();
			continue; // 잘못된 예외를 거르고 다시 입력을 받기 위해서 
		}		
		break;  // 정상적인 입력이 끝났기 때문에
		}	
		
		
		try {
		System.out.println("나눗셈의 몫 :"+ (num1/num2));
		System.out.println("나눗셈의 나머지 :"+ (num1%num2));
		} catch(ArithmeticException e){
			  System.out.println("0으로 나눌 수 없습니다.");
			  System.out.println(e.getMessage());  // / by zero
		}  
		System.out.println("프로그램을 종료합니다.");
		
		
	//	Exception in thread "main" java.lang.ArithmeticException: / by zero
                                              //예외 타입		                                    
	//	at firstJava.ExceptionHandling.main(ExceptionHandling.java:48)
                              //클릭하면 어디에서 오류가 날 수 있는지 보여줌.  
		
		
		/*
	      *finally
		 예외와 상관없이 무조건 수행되는 코드(선택적)
		  try - catch - finally
		  try - finally
		 		
		 */
		
		try {
			System.out.println("try블록에 진입");
		} catch(Exception e) {
			System.out.println("예외발생~!!");
		} finally {
			System.out.println("try구문에 진입하면 무조건 실행하는 finally블록");
		}
		
		
		try {
			int num = 10/0;
		} catch(Exception e) {
			System.out.println("예외발생~!!");
		} finally {
			System.out.println("try구문에 진입하면 무조건 실행하는 finally블록");
		}
		
		/* 예외클래스 정의, throw
		예외클래스와 예외 발생을 직접 정의 
		try블록에서 연산자 new를 사용하여 발생시키려는 예외의 객체를 만들어줌.
		-> 키워드 throw를 통해 예외 발생 		  
		 */
		try {
			//프로그래머가 강제로 예외를 발생시킨다
			// 1. 예외 클래스의 인스턴스 생성
			Exception e = new Exception("강제로 발생한 예외");
			// 2. 실제로 예외를 발생 : throw 예외타입 인스턴스 참조값
			throw e;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace(); // 예외발생 순서
		}
		System.out.println("프로그램 종료");
		
		
	}

}
