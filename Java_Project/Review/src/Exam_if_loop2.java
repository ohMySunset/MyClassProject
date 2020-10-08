
public class Exam_if_loop2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 /*
		for(int i=0; i<=10; i++) {
		for(int j=0; j<=i; j++)
		System.out.print("*");
		System.out.println();
		}
		
		int i = 0;
		while(i<10) {	
			System.out.println("*");
			int j = 0;
			while(j<=i) {		
				System.out.print("*");		
				j++;
			}
		i++;
		}
		*/
	
  
		System.out.println("두 주사위 눈의 합이 6이 되는 경우의 수는 아래와 같다");
	for(int n=1;n<7;n++) {
		  int num1, num2;
		  num1 = n;
		  num2 = 6-n;
		  System.out.println(num1+" 과 "+num2+" 이 나오는 경우" );
	}

}}
