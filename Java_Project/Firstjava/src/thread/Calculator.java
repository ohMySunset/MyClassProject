package thread;

public class Calculator {
 
	int opPlusCnt = 0;  //연산의 횟수
	int opMinCnt = 0;
	
    public int add(int n1, int n2) {
    	synchronized(this) { // 참조변수 this라는 키를 가지고 들어오면 실행
    		opPlusCnt++;
    	}
		return n1+n2;
	}
	
	public int min(int n1, int n2) {
		synchronized (obj) { // 위에서 this라는 키가 사용중이기 때문에 아래 -연산이 끝나더라도 위의 처리가 끝나면 실행할 수 있음.
			opMinCnt++;
		}	
		return n1-n2;		
	}
	
	
	// 새로운 인스턴스를 생성하여 새로운 동기화 키를 사용하도록 만들어줄 수도 있음.
	Object obj = new Object();  
	
	
	
}
