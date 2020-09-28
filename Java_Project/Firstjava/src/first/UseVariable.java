package first;

public class UseVariable {

	public static void main(String[] args) {
		
	//1. 정수형 타입의 변수 num1변수를 선언하자.	
		int num1;
	//2. 변수 num1에 숫자 데이터 10을 저장하자.
		num1 = 10;
	//3. 정수형 타입의 변수 num2를 선언하고 숫자 20을 대입하자.	
		int num2 = 20; 
	//4. 정수형 타입의 변수 num3을 선언하고 변수 num1과 num2를 합하는 연산한 결과를 
	//   변수 num3에 대입한다.
		int num3 = num1 + num2;
	//5. 연산의 결과를 출력하자.
		System.out.println(num3);
		
		
		
		
		
		
		
    float n1 = 1.000001f;
	double n2 = 1.000001;
	System.out.println((double)n1);
	System.out.println(n1 * n2);
	// 같은 실수 연산이지만 결과는 	1.0000002192093016 이렇게 나옴
	

	
	char c1 = 'A';
	char c2 = '한';
	System.out.println(c1);
	System.out.println((int)c1); //4바이트 짜리 정수형 데이터(int)로 변환
	System.out.println(c2);	                         
	System.out.println((int)c2);
		
	
	//boolean : true / false
	boolean check = true;
	if(check) {
		System.out.println(true);		
	}
	int i = 0;
	while(check) { //반복을 위한 조건식
		if(i > 5) {
			break;
		}
		i++;// 탈출의 연산식 *while 탈출식도 잘 만들어야함. 아니면 무한반복
		System.out.println(i);	
	}
	
	
	//상수 생성
	final double PI = 3.141592;
		//PI = 3.14;  파이 값을 재정의 하려고 하면 에러가 뜸. 
	
	
	
	//String s1 = ""; 공백문자	
		
	
	//int num5 = 10000000000; //에러 : 데이터 크기를 벗어남
	//int num5 = 10000000000L; // 에러 : 타입 미스매치
	long num5 = 10000000000L;
	
	/* 
	 자동형변환
	byte,short -> int
	byte + int -> int + int -> int(결과 또한 큰 자료형의 형태로 나오게됨)
	int + long -> long + long -> long
	int  < float  정수보다 실수의 범위가 더 크다고 판단하기 때문에 
	long < float
	
	double num2 = 3.5f + 12;
	          <--- 1번 연산
	              float + int  -----> float로 연산
	double num2 = float     	         
	       	         
	*/
	
	char ch3 = 'A';
	
	int chNumber = ch3;  // char값은 자동형변환되어 유니코드 값으로 출력됨
	
	System.out.println("A의 유니코드 값은 =>"+chNumber);
	
	chNumber += 1; // chNumber = chNumber + 1;
	System.out.println(chNumber);
	System.out.println((char)chNumber);
	
	int age = 200; // byte -128~127까지 표현 가능
	System.out.println((byte)age);
	// -56이 출력됨. 큰 사이즈 -> 작은 사이즈로 변환할 경우 우리가 원하는 값이 아닌 다른 값이 나오게 됨.
	
	/* 마지막 정리!!
	   1. 변수의 타입(자료형)을 미리 정의
	     int - 정수
	     float - 실수
	     char -  문자
	   2. 변수 사용 목적 -> 나중에 데이터를 다시 사용,변경,참조 하기 위해서 
	                                       메모리에 저장해놓고 꺼내쓴다.
	   3. 변수선언
	   4. 기본 자료형
	       논리값, 문자, 정수(4), 실수(2)      
	               *int          
       5. 변수, 상수(fanal), 리터럴 (변수가 아닌 한번 쓰고 버릴 데이터)                  
	   6.  자료형의 형변환                                      
	     byte -> short -> int -> long -> float -> double
	              char -> 
	   
	    
	   - 다루어야 할 데이터에 맞는 변수선언 필요
	   - 연산에 맞는 변수선언 필요
	              
	*/     
	}

}
