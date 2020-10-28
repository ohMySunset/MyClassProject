package thread;


// 쓰레드 클래스 정의는 Thread 클래스를 상속해서 정의
class thread1 extends Thread{
     
	String threadName;
	
	public thread1(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("안녕하세요"+ threadName+ "입니다." );
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
	 }
		System.out.println(threadName+"이 종료되었습니다.");
	}
	
	
}


// 쓰레드 클래스 정의할 때 상속이 필요한 경우 Runnable 인터페이스를 구현해서 쓰레드를 생략할 수 있다.
public class thread2 implements Runnable {
	
  

	@Override
	public void run() {https://meet.google.com/unsupported?meetingCode=hej-nved-mqn&ref=https://meet.google.com/_meet/hej-nved-mqn
		
		for(int i=0;i<10;i++) {
			System.out.println("안녕하세요 Runnable 입니다.");
			try { // Object클래스의 sleep(m/s)메서드 -> 현재 쓰레드를 1/1000초 간격으로 멈춤. ->100/1000 = 1/10초
			Thread.sleep(100); 
			} catch(InterruptedException e) {		
				e.printStackTrace();
			}
		}        
		System.out.println("Runnable이 종료되었습니다");
		
		
	}


	


	
	
}
