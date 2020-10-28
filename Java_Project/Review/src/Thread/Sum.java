package Thread;

public class Sum {

	int num;
	
	Sum(){
		num=0;
	}
	
	// 다른 스레드가 조작하지 못하도록 변수 Lock
	synchronized void addNum(int n) {
		num+=n;		
	}
	
	int getNum() {
		return num;
	}
	
}
