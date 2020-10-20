package firstJava;

public class interfaceMarking {

	public static void main(String[] args) {
	
	PointOne pos1 = new PointOne(1, 1);
	PointTwo pos2 = new PointTwo(2, 2);
	PointOne pos3 = new PointOne(3, 3);
	PointTwo pos4 = new PointTwo(4, 4);
	
	String test = "test";
	
      ClassPrinter.print(pos1);
      ClassPrinter.print(pos2);
      ClassPrinter.print(pos3);
      ClassPrinter.print(pos4);
      ClassPrinter.print(test);
      
	}

}

interface UpperCasePrintable{  // 추상메서드가 존재하지 않음.
	                           // 아무것도 존재하지 않는 인터페이스클래스로 상위클래스를 만들 수 있다. -> 마킹의 효과		
}

class PointOne implements UpperCasePrintable{  //PointOne은 인터페이스를 구현하고 있음.
	private int xPos;
	private int yPos;
	
	PointOne(int x, int y){
		xPos = x;
		yPos = y;
	}
	@Override
	public String toString() {
		return "[x pos:"+ xPos+", y pos:"+yPos+"]";
	}
}

class PointTwo{
	private int xPos, yPos;
	
	PointTwo(int x, int y){
		xPos = x;
		yPos = y;
	}

	@Override
	public String toString() {		
		return "[x pos:"+ xPos+", y pos:"+yPos+"]";
	}
		
}

class ClassPrinter {
	public static void print(Object obj) {
		String str = obj.toString();
		// UpperCasePrintable 형변환 가능 여부 확인 후 대문자로 변환
		if(obj instanceof UpperCasePrintable) {
			str = str.toUpperCase(); //대문자로 바꾸어서 반환해줌.
		}
		System.out.println(str);
		}
}