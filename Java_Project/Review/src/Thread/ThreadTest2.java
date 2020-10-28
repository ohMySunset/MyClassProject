package Thread;

import javax.swing.JOptionPane;

public class ThreadTest2 {

	public static boolean check = false;
	
	public static void main(String[] args) {
		
		
		InputAgeThread it = new InputAgeThread();
		CountDownThread ct = new CountDownThread();
		
		it.start();
		ct.start();
		
		
		
	}

}

class InputAgeThread extends Thread{

	@Override
	public void run() {
	  System.out.println("10초 안에 입력을 해주세요.");	
      String age = JOptionPane.showInputDialog("나이를 입력해주세요.");			
	  System.out.println("저의 나이는 "+ age + "살 입니다.");
       ThreadTest2.check = true;
	}

}

class CountDownThread extends Thread{

	@Override
	public void run() {
		
		for(int i=10;i>0;i--) {
			if(ThreadTest2.check==true) {  // 카운트를 세다가 true값이 입력되면 break;
				break;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}	
		
		System.exit(0);
	}
	

}