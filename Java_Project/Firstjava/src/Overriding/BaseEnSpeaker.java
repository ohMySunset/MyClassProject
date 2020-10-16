package Overriding;

public class BaseEnSpeaker extends Speaker {

	private int baseRate;
	
	public void setBaseRate(int base) {
		baseRate = base;
	}
	 
	//★오버라이딩 : 상속관계에서 상속받은 메서드를 선언부는 동일하게 하고 처리부를 재구성 하는 것.
	
	/*
	void showCurrentState() {   //부모클래스와 같은 선언부	
		System.out.println("메서드 내용이 변경되었습니다."); // 새로운 값을 입력함으로써, 조상클래스가 가지고 있던 메서드 데이터가 사라짐
	}
	*/
	@Override  //★ 어노테이션  : 자바의 키워드는 아니다. 주석도 아니다. 추가적인 의미를 부여한다. 
	           // ★밑에 있는 메서드가 오버라이딩 하고 있음을 의미, 메서드 선언부 이름이 다르면 오류발생, 오버라이딩을 하는게 아니라면 지워야 함.
	void showCurrentState() {   //★부모클래스와 같은 선언부, 접근제어자가 조상 클래스보다 좁은 범위일 수 없음. 
		super.showCurrentState();  //super를 써주면 조상클래스가 가지고 있던 메서드를 호출할 수 있음.
		System.out.println("베이스 크기 :" + baseRate);  //자손클래스에 새롭게 입력된 값.
	}
	
}
