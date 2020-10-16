package Overriding;

public class OverridingMain {

	public static void main(String[] args) {
		
		BaseEnSpeaker bs = new BaseEnSpeaker(); //자손클래스 인스턴스 호출

	   //bs.showCurrentState();  //상속 후 자손클래스에서 메서드 내용이 오버라이딩 되었다면 , 바뀐 내용만 출력됨.

		
	   //Speaker s = new Speaker(); //조상클래스 인스턴스 호출
	   //s.showCurrentState(); //조상클래스가 원래 가지고 있던 메서드 출력
 
		
		
      //★다형성★
	  // 조상클래스 타입의 참조변수에 자손클래스타입의 인스턴스를 참조할 수 있는것.
	  // 참조변수는 해당 타입의 멤버만 사용겠다라고 선언
	  //여러타입을 하나의 타입으로 관리할 수 있다.
		
		Speaker s = new BaseEnSpeaker();
		// 참조변수 s는 volumeRate변수와  showCurrentState(), setVolume()만 사용할 수 있다.
		
		// Speaker 클래스가 가지는 멤버
		s.setVolume(10);
		
		// BaseEnSpeaker가 가지는 멤버
		//s.setBaseRate(20); 오류발생
		
		// Speaker가 아닌 BaseEnSpeaker에서 오버라이딩한 메서드가 호출된다.
		// 메서드 안의 BaseEnSpeaker의  변수들도 참조하여 값을 출력할 수 있다. 
		s.showCurrentState();
		
	  /*
		< 참조변수의 형변환 >
		서로 상속관계에 있을 때 가능, 자손타입 -> 조상타입 형변환생략 가능!
		                                             조상타입 -> 자손타입  명시적형변환必
		
		< instanceof연산자 >
		형변환의 결과가 옳은지 판단해줌.
		이항연산  : 왼쪽 ----> 오른쪽
		        fe instanceof FireEngine  fe가 FireEngine으로 형변환이 되는지 판단
		
	  */		
		
		
	}

}
