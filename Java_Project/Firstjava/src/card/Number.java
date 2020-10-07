package card;

public class Number {
	  int num;

	  // ┌클래스이름과 같다     성격---> 메서드와 유사하기 때문에 매개변수처럼 값을 받을 수 있다.
	   Number(int number){   //-> 생성자
		   num = number;  //값의 초기화
		   System.out.println("생성자가 실행되었습니다.");
	   }
	   
	   Number(){   //-> 생성자
		   num = 10;  //값의 초기화
		   System.out.println("생성자가 실행되었습니다.");
	   }
	   
	   
	   int getNumber() {
		   return num;
	
		   
		   
		   
	
}
}