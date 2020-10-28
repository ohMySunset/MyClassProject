package thread;

public class threadMain {

	public static void main(String[] args) {
		
		//Thread 생성
		thread1 st1 = new thread1("1번 쓰레드");
		thread1 st2 = new thread1("2번 쓰레드");
		
		//Runnable 인터페이스를 이용한 Thread
	//	Runnable r = new thread2();			
		Thread st3 = new Thread(new thread2());
		
		
		// 우선 순위 설정 1~10 : 기본 5
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		st1.setPriority(Thread.MAX_PRIORITY);
		
		
		st1.start();
		st2.start();
		st3.start();
		
		for(int i=0;i<10;i++) {
			System.out.println("안녕하세요 메인쓰레드 입니다.");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}
		
		System.out.println("쓰레드가 종료되었습니다");
	}

}
