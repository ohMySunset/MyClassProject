package Exam;

public class Exam_Operator1 {

	public static void main(String[] args) {
		

	// 문제 1
		
	int num1=10;
	int num2=20;
	int num3=30;
	System.out.println(num1+","+num2+","+num3); //값을 처음 초기화 했을 때
	num1=num2=num3;
	
	              //ex) num1=num2=num3=50; 한번에 값을 대입해줄 때
	
	System.out.println(num1+","+num2+","+num3); //대입 연산을 했을 때(연산방향 <---)
	
	
	
	// 문제 3
	
	int oper1 = 3+6;
	/*
	int oper2 = 3+6+9; // ---> oper2 = oper1 + 9
	int oper3 = 3+6+9+12; // ---> oper3 = oper2 +12
	*/
	int oper2 = oper1 + 9;
	int oper3 = oper2 +12;
			
	
	
	// 문제 4
	
	int a = (((25 + 5) + (36 / 4) - 72) * 5);
	int b = ((25 * 5) + (36 - 4) - 71) / 4;
	int c = (128 / 4) * 2;
	
	//a>b>c
	boolean check = a>b && b>c; //논리형변수에 바로 true가 되는 값을 대입해도됨.
	
	System.out.println(check);  // 바로 false가 출력
	
	
	
	}

}
