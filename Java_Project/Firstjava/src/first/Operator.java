package first;

//import java.lang.Math

public class Operator {

	public static void main(String[] args) {

		/*
		  a+b 
		  a,b -> 피연산자
		   +  ->  연산자
		 +,-,/,*같은 것들 -> 연산자
		  
		  단항 : 피연산자 1개 
		  이항 : 피연산자 2개 
		  삼항 :( )?"a":"b";
		  
		  
		  int num3 = num1 + num2
		       2 <--- 1                         오른쪽부터 연산
		  
		  비교연산 -> boolean
		  논리연산 -> true , false
		  
		  
		   ★ 알고리즘 -> 특정패턴 -> 연산식 
		 ex) 짝수판별 
		 -> 2로 나누었을 때 나머지가 0 -> if(n%2 == 0) true -> 짝수 false -> 홀수 
		 ★ 연산자의 종류, 순서, 결과 값을 미리 생각할 수 있어야 한다.
		  
		 */
		/*
		      종 류    |  방 향 |        연 산 자                         우선순위(위->아래) 
		   단항 연산자 | <----- | ++ -- + - (캐스팅->형변환) !(결과부정)
		   산술 연산자 | -----> | * / % 
		               |        | + - 
		               |        | << >> >>> ---> (비트연산) 	
		   비교 연산자 | -----> | < > <= >= instanceof 
		               |        | == != 
		   논리 연산자 | -----> | & ^ | && || 
		   삼항 연산자 | -----> | ( )?_:_; 
		   대입 연산자 | <----- | = *= /= %= += -= <<= 
		               |        | >>= >>>= &= ^= |=
		  
		- 괄호의 우선순위가 제일 높다
		- 연산자 우선순위 : 산술 > 비교 > 논리 > 대입
		                            단항 > 이항 > 삼항
		  
		  ex) 
		    x > 3  &&  x < 8 
		    1       3    2
		  
		  ||는 && 보다 우선순위가 낮다		  
		   ex) x < -1 || X > 3 && x < 5 
		          4    5    1   3   2
		  
		  
		 */
//	boolean check = true;
//	!check -> false

		/*
		  피연산자가 정수 -> 정수연산 
		  피연산자가 실수 -> 실수연산 (%연산자 제외) 
		 10 % -8 -> 2
		 -10 % 8 -> -2
		-10 % -8 -> -2
		  
		  7.0f / 3.0f = float / float -> float		  
         (float) 7 / 3 
		 (flaot)int / int = float / float -> float
		  
		 */

		int num1 = 10;
		int num2 = 8;

		System.out.println("10/8=" + num1 / num2);
		System.out.println("10/-8=" + num1 / -num2);
		System.out.println("10/8=" + num1 % -num2);
		System.out.println("10f/8f =" + 10f / 8f);
		System.out.println("10f/8 =" + 10f / 8);
		System.out.println("10/8 =" + num1 / (float) num2);
		// 뒤의 데이터만 float연산 해줄 뿐 변수 자체가 바뀌는 것은 아님

		/*
		  복합대입연산자
		 a = a + b --> a += b 
		 ex) int sum = 0; //초기화
		 sum = sum + i;
		 sum += i;
		  
		  관계비교연산자
		 ex) 피 연산자를 같은 타입으로 변환한 후에 비교
		 int == float
	   float == float 
		 ★ 결과값은 true 또는 false이다
		  
		  'A' < 'B' -> 65 < 66 (true)
		  '0' == 0 -> 48 == 0 (false) char ------> int 
		    보여지는 변수 형태는 char 이지만 저장할 때는 int 타입으로
		  
		  0.1d == 0.1f -> 0.1d == 0.1d (flase)
		  + 그 이유는?
		  0.1을 인코딩하면 그 정확한 값을 표현할 수 없어 비슷한 값으로 처리하는데
		  (1/3을 소수로 표현하면 0.3333...이 되는 것과 비슷한 개념), 
		  Double과 Float가 각각 표현할 수 있는 유효자리수가 차이가 나기 때문에 같은 값을 가질 수 없다
		  
		  0.1f == 0.100000001490116119384765625
		  0.1d == 0.1000000000000000055511151231257827021181583404541015625
		  
		  
		 */
		// ex)
		char c1 = 'A';
		char c2 = 'B';
		System.out.println("'A' < 'B'" + (c1 < c2)); // true 비교연산이 후 순서이기 때문에 소괄호 표기
		System.out.println("'0' == 0" + ('0' == 0)); // false
		System.out.println("10.0d == 10.0f => " + (10.0d == 10.0f)); // true
		// 10.0d == 10.0d 아래 소수점 부분이 없기 때문에 문제가 되지 않음
		System.out.println("0.1d == 0.1f => " + (0.1d == 0.1f)); // false
		// 0.1d == 0.1d 아래 소수점 부분이 있기 때문에 문제가 됨. 항상 flase 값이 나옴

		double d = (double) 0.1f; // 앞에 double을 써주지 않아도 자동 형변환 됨 명시적으로 써줌.
		System.out.println("d = " + d); // d = 0.10000000[149011612]
		System.out.println("(float)d == 0.1f" + ((float) d == 0.1f)); // true
		// float0.1d == 0.1f => 0.1f == 0.1f

		/*
		 논리연산자 
		 ★ 피연산자는 반드시 boolean이어야 하며 연산결과도 boolean 
		 우선순위 && > || , 같이 쓸 경우 괄호 사용
		 && (AND) : 피연산자 양쪽 모두 true -> true 
		 false && true -> 더 볼 필요도 없이 false 
		 || (OR) : 피연산자 어느 한 쪽이 true -> true 
		 ! (NOT) : 결과가 true -> false 결과값을 뒤집음.
		 
		 int i = 7;
		 i > 3 && i < 5 3~5의 범위값 
		 !(i > 3 || i < 0) 0~3의 범위값
		 
		 */
		// ex)
		char x = 'j';
		System.out.println(x >= 'a' && x <= 'z'); // int로 바뀌면서 비교 97~122 (대문자와 32차이)
		System.out.println(x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z');

		/*
		  논리연산자와 SCE(Short-Circuit Evaluation)
		 && 연산에서 좌변이 false이면 결과는 무조건 false
		 ||연산에서 좌변이 true이면 결과는 무조건 true
		 */

		num1 = 10;
		num2 = 20;

		boolean result1 = num1 == 10 && num2 == 20;
		// 3                  1(true)     2(true)
		boolean result2 = num1 <= 12 || num2 >= 30;
		// 3                  1(true)     2(false)
		System.out.println("num1 == 10 && num2 == 20 =>" + result1); // true
		System.out.println("num1 <= 12 || num2 >= 30 =>" + result2); // true

		// ★기억하세욤
		if (!(num1 == num2)) {
			System.out.println("num1과 num2는 같지 않다.");
		} else {
			System.out.println("num1과 num2는 같다.");

		}

		// 이항연산자는 연산 전에 피연산자의 타입을 일치 시킨다.
		// 1) int 보다 크기가 작은 타입은 int로 (int범위가 넘어가면 long으로)
		// 2) 피연산자 중 표현의 범위가 큰 것으로 변환

		// byte c = (byte)a+b; 에러
		// byte c = (byte)(a+b); OK

		// char c1 ='a'
		// char c2 = c1 + 1 에러
		// char c2 = (char)(c1 +1) OK
		// char c2 = c1++

		// int a = 1000000; 21억이 넘는 숫자 표현은 할 수 없음.
		// int b = 2000000;
		// long c = a * b -> int * int -> int 결과 : -1,454,759,936
		// long c = (long)a*b; -> long * int -> long 결과 : 2000,000,000,000

		// long a = 1000000 * 1000000; // int * int -> int 결과 a : -727,379,968
		// long b = 1000000 * 1000000L; // int * long -> long 결과 a : 1000,000,000,000

		/*
		  자릿수 연산
		 1)형변환
		 2)Math.round(): 소수점 첫째자리에서 반올림한 값을 반환 메서드
		  
		 ex)
		 */

		float pi = 3.141592f; // 3.14까지 표현하고 싶을 때
		float sPi = (int) (pi * 100) / 100f; // (int * int)float -> float
		System.out.println(sPi);

		
		int price = 11234;
		// 뒤에 백단위 밑으로 제외하고 출력하고 싶다면		
		int price2 = price / 1000 * 1000;
		System.out.println(price2);

		
		float sPi2 = Math.round(pi * 100) / 100f; //3.14까지 절사
		System.out.println(sPi2);

		
		float pi1 = 3.141592f; // 3.141까지 절사
		float longpi1 = Math.round(pi1 * 1000) / 1000f;
		// Math.round(3.141592f * 1000)/1000f;
		// Math.round(3141.592f)/1000f;
		// 3142/1000f;
		// 3142.0f/1000f; //결과 3.142f
		System.out.println(longpi1);

		
		/*
		 증가연산자(++) : 피연산자의 값을 1 증가시킴 
		 감소연산자(--) : 피연산자의 값을 1 감소시킴 <----- 결합방향
		  
		 val = ++n; 1.증가 -> 2.대입
		 val = n++; 1.대입 -> 2.증가
		  n = n + 1 / num+= 1
		 val = --n; 1.감소 -> 2.대입 
		 val = n--; 1.대입 -> 2.감소 
		 ex) ++의 위치에 따라 값이 달라짐. 
		 num1 = 7;
		 num2 = ++num1; 8로 증가한 다음 num2에 대입
		 num2 = num1++; 7이 먼저 대입되고 나서 8로증가
		  
		 */
		int i = 5, j = 5;
		System.out.println(i++); //출력 : 5, i = 6
		System.out.println(++j); //출력 : 5, j = 6
		System.out.println("i =" + i + ", j =" + j);

		
		
	}

}
