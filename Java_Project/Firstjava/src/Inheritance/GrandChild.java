package Inheritance;

public class GrandChild extends Child2 { 

	GrandChild(String name){  //Child2에 생성자 정의가 되어 있기 때문에 불러와서 초기화 해줘야 함.
		//조상 클래스의 생성자 호출. -> super()
		super(name); //초기화
	}
	
	
}
