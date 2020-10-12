package method;

public class method_Exam1 {

    //  문제1
    //	두 개의 정수를 전달받아서, 두수의 사칙연산 결과를 출력하는 메서드와 
	//	이 메서드를 호출하는 main메서드를 정의해보자.
	//	단, 나눗셈은 몫과 나머지를 각각 출력해야 한다.
	
	// 두 개의 정수 값을 받을 변수 선언
	int num1;
	int num2;
	
	//두 변수의 초기화
	method_Exam1(int num1, int num2){
		this.num1 = num1;
		this.num2 = num2;
	}
	
    //두 수의 사칙연산 결과를 출력하는 메서드
    void operNum() {
    	int plus = num1 + num2;
    	int minus = num1 - num2;
    	int multi = num1 * num2;
    	int divi1 = num1 / num2;
    	int divi2 = num1 % num2;
    	
    	System.out.println("두 수의 덧셈 결과 : "+ plus);
    	System.out.println("두 수의 뺄셈 결과 : "+ minus);
    	System.out.println("두 수의 곱셈 결과 : "+ multi);
    	System.out.println("두 수의 나눗셈 결과 몫: "+ divi1 + "나머지 : "+ divi2);
    }
	
    
	public static void main(String[] args) {

		method_Exam1 op1 = new method_Exam1(3, 8);
        
		op1.operNum();
			
	}

}
