package Thread;

import javax.swing.JOptionPane;

public class ThreadTest1 {

	public static void main(String[] args) {
		
		
		String age = JOptionPane.showInputDialog("이름을 입력해주세요.");
		
		// String 타입을 입력받을 때 int 타입으로 받기
		int ageNumber = Integer.parseInt(age);
		
		System.out.println("저의 나이는 "+ age + "살 입니다.");
		
		for(int i=10;i>0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
