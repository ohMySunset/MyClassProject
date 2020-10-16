package PackageTest1;

public class AAA {

	//public AAA(){} //생성자 자동으로 생성
	
    int num; //default
    
    public static int n = 100; //static변수는 자신을 포함, 클래스에도 public을 붙여주어야
                               //외부에서 사용할 수 있다.
    
    //static AAA a = new AAA(); //내부에서 자신의 인스턴스를 만들 수 있다.
    
    AAA(){ //default 클래스가 public이어도 다른패지키에서 보이지 않음.
    	
    }
	
	//setter (값을 설정하는 메서드)
	public void setNum(int num) {
		this.num = num;
	}
	
	//getter (값을 읽어오는 메서드)
	public int getNum() {
		
		return num;
	}
	
	
	
}
