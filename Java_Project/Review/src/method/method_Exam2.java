package method;

public class method_Exam2 {

	//메서드 -> 1.데이터를 받아서, 2.처리하고, 3.결과를 반환하는 기능
	
	
	//문제2.
    //두 개의 정수를 전달 받아서, 두수의 절대값을 계산하여 출력하는 메서드와
	//이 메서드를 호출하는 main메서드를 정의해 보자. 
	//단 메서드 호출 시 전달되는 값의 순서에 상관없이 절대값이 계산되어서 출력되어야 한다.
	//return이 없다
/*	
	//두 수를 저장할 변수선언
	int num1;
	int num2;
	
	//생성자 불러오기
	method_Exam2(int num1, int num2){
		this.num1 = num1;
		this.num2 = num2;
	}
*/	
	//두 수의 절대값을 계산하여 출력하는 메서드
	static void abValue(int num1, int num2) { 
		
	//★삼항연산자 활용하기!!!!!
	//System.out.println("num1의 절대값 :" + (num1>0?num1:num1*-1));
	//System.out.println("num1의 절대값 :" + (num2>0?num2:num2*-1));
		
	if(num1<0){
		System.out.println("두 수의 절대값 : "+(-1*num1)+","+num2);
	}else if(num2<0){	
		System.out.println("두 수의 절대값 : "+ num1+","+(-1*num2));
	} else {
		System.out.println("두 수의 절대값 : "+ num1+","+num2);
	}
	
	}
	public static void main(String[] args) {
	
	//method_Exam2 ab1 = new method_Exam2(-3, 6);
	//ab1.abValue();
		
	abValue(3,-7);	
	
	}

}
