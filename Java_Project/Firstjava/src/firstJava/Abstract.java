package firstJava;

public class Abstract {
	
	public static void main(String[] args) {
		
		/*
		  추상클래스 (abstract) : 추상메서드를 하나 이상 포함하는 클래스. 
		                                              미완성된 클래스  -> 인스턴스를 만들지 못한다 -> 객체를 만들지 못한다!
		                                              근데 왜 사용??? -> 상속을 위해 사용!
		                     -> 가이드와 규칙을 정의하는 다른 클래스를 작성하는데 도움을 주는 목적으로 작성.
		★조상클래스의 역할, 다형성, 참조변수 선언 모두 가능함! 인스턴스의 생성만 못할 뿐이다. 
		
	*abstract class Test{  // 추상메서드를 포함한 클래스 -> 추상클래스
		
		*abstract void play();   // 추상메서드 
		           └> 메서드의 선언부 정의만 되어있고 구현부가 없다. -> 미완성
		                               하위클래스에서 추상클래스의 추상메서드를 오버라이딩 하여 정상메서드로 만들어 줌.
		                               (= 메서드를 구현한다)
		 }             		 
		 */
  //	Player player = new Player(); //추상클래스이기 때문에 인스턴스를 생성할 수 없음
  //	VideoPlayer player2 = new VideoPlayer(); //마찬가지로 추상클래스이기 때문에 인스턴스를 생성할 수 없음
	    AudioPlayer player3 = new AudioPlayer();
	}
}


abstract class Player{	
	 abstract void play(int num);
	 abstract void stop();
}

abstract class VideoPlayer extends Player{   //추상클래스를 상속해서 추상메서드 play, stop을 오버라이딩 하지 않았기 때문에
                                   //VideoPlayer도 추상클래스다	
	abstract void play(int num); 	
	abstract void stop();	
}

class AudioPlayer extends Player{
//추상클래스(상위클래스)의 void play(int num)과 void stop을 오버라이딩 하여 정상메서드로 만들어줌. 
	@Override
	void play(int num) {				
	}
	@Override
	void stop() {		
	}	
	
	
}