package first;

import java.util.Scanner;

public class Loop {

	public static void main(String[] args) {
	/*
	 조건문, 반복문 => 프로그램의 흐름 (분기)
	 
	★ 배열   + 반복문	
	배열의 특징 -> 집합개체, 묶음, 순차적이기 때문에 뒤에 반복문으로 일괄 처리해준다.
	
	
	<조건문 if>
	
	     ┌─> true일 시 강제적으로 실행, false이면 실행X, 
	     │   조건식에는 비교연산, 논리연산이 들어갈 수 있음. 
	if(★조건식 true/false){      
	            true시 실행되는 영역  
	}else{      
	            false시 실행되는 영역
	}
    
    ex) 성인,여성만 참여 가능한 투표
	boolean check = true;
	if(age < 20){
	       check = false;	---> false일 경우만 제시해줌
	} 
	if(gender = 'M'){
	        check = false;
	}
	if(check){
	 system.out.println("투표한다");
	}
	
	
	<if문의 세가지 형태>
	if
	if - else
	if - else if(중복가능) - else(생략가능) --> 앞 if 문장에 따라 범위가 결정됨 
	     

	*/	
		int i = 0;
		if(i%2==0) {}  // 짝수     if(i%2!=0) {}  홀수		
		if(i%3==0) {}  // 3의 배수
		
		if(i <-1 || i >3 && i <5) {}
		//    4   5  1   3   2  --->  &&먼저 ||나중에
		
		boolean powerOn = false;
		   // ┌─>전원이 꺼져 있을 때이기 때문에 true값이 나와야 함
		if(!powerOn) {
			//전원이 꺼져 있으면 등을 켠다 
		}
	    // 위와 같음 ┐
		if(powerOn) {}
	    else { //전원이 꺼져 있으면 등을 켠다 
	    }
		
		
	// 문자열 처리 -> String 클래스 이용 -> 객체 생성 -> 클래스가 가지는 변수와 메서드를 메모리에 로드 한다. 	
	 String str = null; //참조변수가 객체의 주소값을 저장하고 있지 않는다.
	 str = ""; //공백문자를 이용해서 객체를 생성, 주소값을 str에 반환 (객체의 메모리 주소값을 저장)
	  //	"   "  -> 문자열을 저장하는 String 타입의 객체 생성
	if(str.equals("c")||str.equals("C")) {}	
	
    str = "abc";
	str.toString(); 
 	System.out.println(str.toString()); // 문자열을 그대로 다시 반환
 	System.out.println(str.equals("abc")); //euqals -> 내가 비교하고자 하는 변수와 비교해줌

   	
	if(str != null && !str.equals("")) {
		System.out.println(str.charAt(0)); //abc -> 0,1,2 
		                                   //문자열을 인덱스 처리하여 해당 문자를 뽑아냄
	}    
	
	int num = 10;
	if(num>0) {
		System.out.println("num은 0 보다 크다");
	}if((num%2)==0) {
		System.out.println("짝수이다");
	}else {
		System.out.println("홀수이다");
	}
	
	//if문은 제한없이 중첩해서 쓸 수 있지만 여러개 중복해서 쓰는 것 보다 간단하게 쓰는 것이 가독성이 좋다. 
	if(num > 0 && num%2==0) {
		System.out.println("num은 0 보다 크고 짝수이다");
	}
	
	/*
	  <if~else와 유사한 조건 연산자(삼항연산자)>
	 (true or false)? 숫자1(true) : 숫자2(false);	                	 	 
	*/
	int num1 = 20, num2 = 50;
	
	int big = 0; // 큰 수
	int diff = 0; // 두 수의 차이
	
	//삼항연산자 이용   --> 간단한 비교구문은 삼항연산자 사용 가능! (if로 해도 무관)
	//big = num1 > num2 ? num1 : num2;  //big = num2
	//diff = num1 > num2 ? num1 - num2 : num2 - num1; // diff = num2
	//   System.out.printf("큰수 : %d이고,큰 수와 작은 수의 차이는 %d입니다",big,diff);
	//%d ->정수형식으로 출력
	
	 if(num1 > num2) {
		 big = num1;
		 diff = num1 - num2;
	 }else {
		 big = num2;
		 diff = num2 - num1;
	 }
	 System.out.printf("큰수 : %d이고, 큰 수와 작은 수의 차이는 %d입니다.\n",big,diff);
	  
	 /*
	 <Switch>
	 조건식의 계산결과와 일치하는 case문으로 이동 - break(생략가능)를 만나면 탈출
	 break를 생략할 경우, 일치하는 case 값부터 그 아래 작업까지 순차적으로 모두 수행
         일치하는 case 값이 없을 경우 default값으로 처리됨(생략가능)
     switch 중복가능, if와 함께 사용가능
         
           ★ case 값으로는 변수사용 불가, 리터럴 혹은 상수만 가능!   
	  조건식에서 char,int,string 사용 가능 (int 자료형 이하의 값)
	 
	 */
	 
	 int n = 0;
	 
	 Scanner sc = new Scanner(System.in);	
	 
	 System.out.println("메뉴를 선택하세요\n 1.입력 2.보기 3.수정 4.삭제 ");
	 	 	 
	 n = sc.nextInt();
	 
	 switch (n) {
        	case 1:
        System.out.println("입력합니다.");
	//	System.out.println("Simple JAVA");
		    break;
        	case 2:
        System.out.println("데이터를 열람합니다.");		
    //    System.out.println("Funny JAVA");
            break;
        	case 3:
        System.out.println("정보를 수정합니다.");
    //    System.out.println("Fantastic JAVA");   
            break;
        	case 4:
        System.out.println("데이터를 삭제합니다.");
            break;
	   /*     default: 
	        	
	    System.out.println("Best JAVA");
	  */ 
	}
	 
	 
	 
	 
	 
	 
	}  

}
