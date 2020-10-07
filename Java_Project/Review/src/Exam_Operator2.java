
public class Exam_Operator2 {

	public static void main(String[] args) {
		
		//[1] 다음 연산의 결과를 적으시오.	
		int x = 2;
		int y = 5;
		char c = 'A'; // 'A'의문자코드는 65
		/*
		- 괄호의 우선순위가 제일 높다
		- 연산자 우선순위 : 산술 > 비교 > 논리 > 대입
		                             단항 > 이항 > 삼항
		                                   */
		System.out.println(y+= 10 - x++);  // y=y+(10-x++) -> 5 + 8 -> 13
		System.out.println(x+=2); //위에서 x가 증가하였으므로 x=3, x = x + 2 -> 5
		System.out.println(!('A' <= c && c <='Z') ); //문자 타입은 연산에서 int로 변환됨 
		System.out.println('C'-c); //int - int, 67-65 = 2
		System.out.println('5'-'0'); //5
		System.out.println(c+1); // char + int -> int + int -> int , 65 + 1=> 66
		System.out.println(++c); // 단항증감연산자는 형변환에 영향을 주지 않음. 그대로 char타입으로 출력
		                         // 증가 후 출력 -> B
		System.out.println(c++); // 출력 후 증가  -> B
		System.out.println(c);   // C
		
		
		
		
		//[2] 아래의 코드는 사과를 담는데 필요한 바구니(버켓)의 수를 구하는 코드이다.만일 사과의수가 123개이고 하나의 바구니에는10개의 사과를 담을 수 있다면,13개의 바구니가 필요할 것이다.(1)에 알맞은 코드를 넣으시오.
		//3항 연산자 : 다음에 풀어도 됩니다.
		
		int numOfApples =123; // 사과의 개수
		int sizeOfBucket =10;		
		
		// 바구니의 크기(바구니에 담을 수 있는 사과의 개수)		
	//	int numOfBucket = ( /* (1) */ );			
		/*
		(1) if문을 활용하기
	//	1.전체 사과를 10으로 나눈 몫이 바구니 개수
	//	2.전체 사과를 10으로 나눈 나머지가 0 보다 크면 바구니를 +1		
					
	    int numOfBucket = numOfApples/10; // 몫이 12
		if(numOfBucket%10>0) {	
			numOfBucket++;  //numOfBucket = numOfBucket + 1;
		}
	
	    (2) 삼항연산자 활용하기*/	
		int numOfBucket = numOfApples/10 + (numOfApples%10>0?1:0);
		
		// 모든 사과를담는데 필요한 바구니의 수
		System.out.println("필요한바구니의 수 :"+numOfBucket);
		
		// [실행결과] 13

		
		
		
	//	[3] 아래는 변수num의 값에 따라 ‘양수’,‘음수’,‘0’을 출력하는 코드이다.삼항 연산자를 이용해서(1)에 알맞은 코드를 넣으시오.
	//	[Hint] 삼항 연산자를 두 번 사용하라.
	//	3항 연산자 : 다음에 풀어도 됩니다.
	
		int num = 10;
	//	System.out.println( /* (1) */ );
		//삼항연산자의 복합사용!
		System.out.println(num>0?"양수":(num<0?"음수":"0"));
		
		// [실행결과] 양수
		
		
		
	//	[4] 아래는 변수num의 값 중에서 백의 자리 이하를 버리는 코드이다.
	//	만일 변수 num 의 값이‘456’이라면 ‘400’이 되고,
	//	‘111’이라면 ‘100’이 된다.(1)에 알맞은 코드를 넣으시오.
		
		 num = 456;
	//	System.out.println( /* (1) */ );
		
		System.out.println(num/100*100);
		
		//[실행결과] 400
	
		
		
	//	[5] 아래는 변수num의 값 중에서 일의 자리를1로 바꾸는 코드이다.
	//	만일 변수 num의값이 333이라면 331이 되고,777이라면 771이 된다.
	//	(1)에 알맞은 코드를 넣으시오.	
		
		num = 333;
	//	System.out.println( /* (1) */ );
		
		System.out.println(num/10*10+1); // 곱셈 나눗셈으로 계산하면 330 십의 자리까지는 변함 없음.
		                                 // +1해주면 일의 자리는 무조건 1이 오게됨.
		
		// [실행결과] 331
	
		
		
		
	//	[6] 아래는 변수num의 값보다 크면서도 가장 가까운10의 배수에서 변수num의 값을뺀 나머지를 구하는 코드이다.
	//	예를 들어, 24의 크면서도 가장 가까운10의 배수는 30이다.19의 경우 20이고,81의 경우 90이 된다.
	//	30에서 24를 뺀 나머지는6이기 때문에 변수num의 값이 24라면6을결과로 얻어야 한다.(1)에 알맞은 코드를 넣으시오.
	//	[Hint] 나머지 연산자를 사용하라.
	
		num = 24;
	//	System.out.println( /* (1) */ );
		
		System.out.println(10-num%10);
		
		// [실행결과] 6
		
	/*★★★★★자릿수 구하는 문제는 나누기와 곱셈, 나머지 구하는 연산자를 활용하면 된다!!! */
	
	
		
	//	[7] 아래는 화씨(Fahrenheit)를 섭씨(Celcius)로 변환하는 코드이다.
	//	변환공식이 'C =5/9 ×(F - 32)'라고 할 때,(1)에 알맞은 코드를 넣으시오.
	//	단, 변환 결과값은 소수점셋째 자리에서 반올림해야 한다.
	//	(Math.round()를 사용하지 않고 처리할 것)
		
		int fahrenheit =100;
	//	float celcius = ( /* (1) */ );
		float celcius = (int)(5/9f*(fahrenheit-32)*100+0.5)/100f;
	 /*
	    일단 5/9 연산 결과가 소수점 단위로 나오기 때문에 뒤에 리터럴f 붙여준다
	   소수점 자리의 절사는 int타입으로 계산해야하므로 연산식에 괄호처리하여 int를 붙인다.		                        
	   셋째 자리에서 반올림하면 출력받을 때 필요한 수는 소수점 둘 째자리까지 이므로
	  *100을 해준다. 문제는!소수점셋째 자리가 5 보다 클 경우에는 반올림이 되야 하는데
      int타입에서는 소수점 자리가 절사되어 0으로 나오기 때문에 +0.5를 해주어야 한다.
	   예로 0.2와 0.6을 놓고 봤을때,  0.2+0.5 = 0.7 -> (int)0.7 -> 0
	  0.6+0.5 = 1.1 -> (int)1.1-> 1 이 될 수 있다.
	    마지막으로 전체 값을 다시 float형으로 변환시켜주어야 하므로 /100f를 계산해준다
      */
		System.out.println("Fahrenheit:"+fahrenheit);
		System.out.println("Celcius:"+celcius);
		
		// [실행결과] Fahrenheit:100 Celcius:37.78

		
		
	//	[9] 다음은 문자형 변수 ch가 영문자(대문자 또는 소문자)이거나 숫자일 때만 
	//	변수b의 값이 true가 되도록 하는 코드이다.(1)에 알맞은 코드를 넣으시오.
		
		char ch = 'z';
	//	boolean b = ( /* (1) */ );
		
		boolean b = ('A'<= ch && ch <='Z'
				     ||'a'<= ch && ch <='z'
				     || '0'<= ch && ch >= '9');
		// && 연산이 우선이므로 괄호 필요 없음!
		System.out.println(b);
		
	    // [실행결과] true
		
		
		
		
	//	﻿[10] 다음은 대문자를 소문자로 변경하는 코드인데,문자 ch에 저장된 문자가 대문자인 경우에만 소문자로 변경한다.
	//	문자코드는 소문자가 대문자보다32만큼 더 크다.예를들어 'A‘의 코드는65이고 ’a'의 코드는97이다. 
	//	(1)~(2)에 알맞은 코드를 넣으시오.	﻿
		ch = 'A';
	//	char lowerCase = ( /* (1) */ ) ? ( /* (2) */ ) : ch; 삼항연산자 활용하기
		char lowerCase = (ch>='A' && ch<='Z')?(char)(ch+32):ch;
		System.out.println("ch:"+ch);
		System.out.println("ch to lowerCase:"+lowerCase);
		
		// [실행결과]ch:A   ch to lowerCase:a
		

		
		
}
	
}
