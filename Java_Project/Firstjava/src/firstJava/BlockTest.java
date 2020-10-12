package firstJava;

public class BlockTest {
	
	static int[] arr = new int[10];
	
	static {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*10)+1; // (int)(0.0 <= r <10.0) => 0~9+1 -> 1~10 사이의 랜덤
		}
		System.out.println("배열의 요소의 초기화 작업완료 ");
		
	}
	
   //클래스 초기화 블록 : 코드가 메모리에 로드될 때 블록의 코드가 실행 (가장 빠름!) 
	static {
		System.out.println("static { }");
		 
	}
	
	//인스턴스 초기화 블록  : 인스턴스가 생성될 때 블록의 코드가 실행, 생성자 보다 우선한다.
	{
		System.out.println("인스턴스 { }");
	}
	
	BlockTest(){
		System.out.println("생성자");
	}
	
	public static void main(String[] args) {
		
	//아무것도 입력하지 않고 메인메소드를 실행하면 static블록은 실행됨. 초기에 딱 한번	
	
	System.out.println("BlockTest 인스턴스 생성");	
	BlockTest bt1 = new BlockTest();
		
	System.out.println("BlockTest 인스턴스 생성");	
	BlockTest bt2 = new BlockTest();
		
	for(int i = 0;i < arr.length;i++ ) { //처음 시작할 때 초기화 해야 할 작업이 있다면 static블록으로 미리 초기화
		System.out.println("arr["+i+"]" + arr[i]);
	}
	
	}

}
