package thread;

public class AdderThreadMain {

	public static void main(String[] args) {
		
		Adderthread at1 = new Adderthread(1,5000);
		Adderthread at2 = new Adderthread(5000,100000);
		
		//쓰레드 생성
		Thread t1 = new Thread(at1);
		Thread t2 = new Thread(at2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();  // t1 쓰레드가 종료될 때 까지 다른 스레드는 멈춤 상태.
			t2.join();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		
		
		System.out.println("1~100합은 :" + at1.getNum()+at2.getNum());
	}

}
