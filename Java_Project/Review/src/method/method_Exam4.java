package method;

public class method_Exam4 {

	//문제4.
	//전달되는 값이 소수(prime number)인지 아닌지를 판단하여, 소수인경우 true를,
	//소수가 아닌 경우 false를 반환하는 메서드를 정의하고,  
	//이를 이용해서 1이상 100 이하의 소수를 전부 출력할 수 있도록 main 메서드를 정의하자
	
	//소수 -> 1과 자기 자신으로만 나누어 떨어지는 수
	//ex) 2,3,5,7,11....
	//true, false -> boolean 타입
	static boolean isPrimeNumber(int num) {		
		int cnt=0;
		//소수인지 판별
		for(int i=1;i<=num;i++) { //1부터 자신을 포함한 수로 나누어보기 
			if(num%i==0) { //소수는 나누어 떨어지는 경우가 1번
				cnt++;     //cnt가 2회를 넘어가면 소수가 아님!
			}
		}				
		return cnt>2?false:true; //boolean 타입의 결과를 반환
	}
	
	
	public static void main(String[] args) {
	System.out.println(isPrimeNumber(3));
	System.out.println(isPrimeNumber(4));		
	
		//1~100까지의 범위에서 소수찾기
     for(int i=1;i<101;i++) {
    	 if(isPrimeNumber(i)) {  
    		 System.out.println(i);
    	 }
     }
     
	}

}
