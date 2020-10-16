package Exam;
import java.util.Scanner;

public class SelfTest_Operator {

	
	public static void main(String args[]) {


/*
  //주민등록번호를 입력할 변수를 선언하고 코드를 한줄로 적으시오	
   String regNo =  "123456-7898765";

	System.out.println(regNo);	

 //--------------------------------------------------------------------	
 // num1 = 10, num2 = 20, num3 = 30이라는 가정하에 변수를 선언 후 연산하여 출력한 결과에 대해 설명하시오
    int num1 = 10, num2 = 20, num3 = 30;
    
    System.out.println(num1=num2=num3);
    
 //--------------------------------------------------------------------     
 // 아래 연산식을 결과로 출력하시오
    int result;
    result = ((25*5+(36-4))-72)/5;
    System.out.println(result);
       
 //---------------------------------------------------------------------    
  // 3+6, 3+6+9, 3+6+9+1의 합을 구하는 연산식을 만드시오
   int sum = 3; // 3+6부터 계산하기 위해서 sum을 3으로 초기화
   for(int i = 2; i<5; i++) { // sum 초기값 3에 6을 더해주어야 하므로 i = 2, 이렇게 총 세번 계산하기 때문에  i < 5
   	sum += i*3;  // 3의 배수의 합
     System.out.println(sum); //세 번 계산한 합계가 순차적으로 출력
    }
    
 //----------------------------------------------------------------------   
    // a>b>c가 맞으면 true 아니면 false가 나오는 연산식을 완성하시오
    int a = (((25+5)+36/4)-72)*5;  
    int b = ((25*5+(36-4))-71)/4;  
    int c = 128/4*2;               
   
    boolean check = true;
	   if(a>b && b>c) {
		   System.out.println(check);
	   }
	   else {
		   System.out.println(!check);		  
	   }	 
 //-----------------------------------------------------------------------	 
// 아래 연산의 결과를 적으시오	
	 int x =2;
	 int y =5;
	 char c = 'A';
	   
  System.out.println(y+=10-x++); // 초기값 y=5 x=2 -> y=y+10-x++ -> y=13
  System.out.println(x+5);       // 이전 단계에서 대입 후 증가 하였으므로 x=3 
  System.out.println(x+=2);      // = 5 
  System.out.println(y+=2);      // = 15
  System.out.println(y+2);       // = 17
  System.out.println(++y);       // = 16
  System.out.println(!('A'<= c && c <='Z'));  //c=65 A=65 Z=90 이고, ('A'> c || c>'Z')와 같으므로  false
  System.out.println('C'-c);     //  C=67 c=65                                      
  System.out.println('5'-'0');  //5=53 0=48
  System.out.println(c+1); // = 66
  System.out.println(++c); // c=65 -> c=66 (++c는 증가 먼저) 66=>B
  System.out.println(c++); // (c++은 대입먼저) 이전 단계 그대로 대입되므로 c=66=>B         
  System.out.println(c); // 이전 단계에서 대입 후 증가하였으므로 67=>C

  */
 //------------------------------------------------------------------------	
  /*
	int Apple =123;
	int bucket = 10;
	int numBuk = 0;
	
	numBuk = (Apple%bucket>0)?Apple/bucket+1:Apple/bucket;
	System.out.println(numBuk);
  
  //------------------------------------------------------------------------
	int num = 10;

	System.out.println((num>0)?"양수":(num<0 && num!=0)?"음수":"0");
	
	
  //------------------------------------------------------------------------	
		
	int num = 456;
	System.out.println(num/100*100);
	
  //-------------------------------------------------------------------------	
	
//	int bigNum = (num/10)+1*10; 
	
	int num =81;
	System.out.println(10-(num%10));
	
	int num = 333;
	System.out.println(num/);
		
	
	int  fahrenheit = 100;
	float celcius = (int)(((float)5/9*(fahrenheit-32))*1000)/1000f ;
	
	//celcius = (int)(celcius*1000)/1000f;
	System.out.println(celcius);
	*/

float f2 = 0.1f;
double d = 0.1;
boolean result =  (float)d==f2;
	System.out.println(result);
	}
 
}
