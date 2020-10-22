package Basic;

import java.util.Random;

public class RandomNumberGenerater {

	public static void main(String[] args) {
		
		Random r = new Random();
		
		System.out.println(r.nextBoolean()); // true/false 중에서 랜덤하게 출력
		System.out.println(r.nextInt());     // Integer 범위 안에서 램던하게 출력
		System.out.println(r.nextLong());
		System.out.println(r.nextFloat());
		System.out.println(r.nextDouble());
		
		// 6개의 숫자 랜덤하게 뽑기
		System.out.println("이번주 번호 예상");
		for(int i=0;i<6;i++) {
			System.out.print(r.nextInt(45)+1+"\t");
		}		
	//System.out.println(r.nextInt(45)+1); // (n)값을 지정하여 0~n-1 까지 랜덤하게 출력  (0 ~ 44)+ 1
		
		System.out.println();
		
		
		Random r2 = new Random(10); //seed값에 따라 같은 패턴을 반복한다. 
		System.out.println("이번주 번호 예상");
		for(int i=0;i<6;i++) {
			System.out.print(r2.nextInt(45)+1
					+"\t");
		}	
		
		System.out.println();
		
		
		System.out.println("System.nanoTime() => "+ System.nanoTime());
		System.out.println("System.currentTimeMillis() => "+System.currentTimeMillis());
		Random r3 = new Random(System.currentTimeMillis());	//seed설정을 왼쪽과 같이 설정하면 실행할 때마다 다른 값을 얻을 수 있음.	
		System.out.println("이번주 번호 예상");
		for(int i=0;i<6;i++) {
			System.out.print(r3.nextInt(45)+1+"\t"); 
		}		
		
	}

}
