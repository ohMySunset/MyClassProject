package Basic;

public class Wrapper1 {
	

	public static void main(String[] args) {
		
		Integer i1 = new Integer(100);   // 인스턴스 생성, int -> Integer
		Integer i2 = new Integer("100"); // 인스턴스 생성 , String -> Integer
		
		System.out.println("참조변수의 비교 => i1==i2 : "+ (i1==i2)); //서로 다른 인스턴스 생성 , 주소값도 각각 다르게 생성
		System.out.println("저장하는 value 값의 비교 => i1.equals(i2) : " + (i1.equals(i2)));
		System.out.println("i1.toString() : " + i1.toString());
		System.out.println("i2.toString() : " + i2.toString());
		System.out.println("Integer.MAX_VALUE : " + Integer.MAX_VALUE);
		System.out.println("Integer.MIN_VALUE : " + Integer.MIN_VALUE);
		System.out.println("Integer.SIZE : "+ Integer.SIZE);
		System.out.println("Integer.TYPE : "+ Integer.TYPE);
		
		
		int num = i2.intValue();
		System.out.println("int num = i2.intValue(); => " + num);
		
		int num2 = Integer.parseInt("10"); //String -> int
		num2 += 1;
		System.out.println("num2 => " + num2);
		
		// String -> Integer, int -> Integer
		Integer i3 = Integer.valueOf("10");  //인스턴스 생성
		int num3 = i3.intValue();  //변수에 값 대입
		System.out.println("num3 => "+ num3);
		
		
	System.out.println("===================================================");
	    // Wrapper = primitive 래퍼클래스에 기본형 대입하기
	
		//Auto Boxing
		Integer iValue = 10;  
		//Integer iValue = new Integer(10);
		//Integer iValue = Integer.valueOf(10);		
		System.out.println(iValue);   //iValue.toString()
		
		Double dValue = 3.14;
		//Double dValue = new Double(3.14);
		//Double dValue = Double.valueOf(3.14);
		System.out.println(dValue);    //dValue.toString()
	
		//Auto UnBoxing
		int numA = iValue;    //Integer -> int 
		double numB = dValue; // Double -> double 
		System.out.println(numA);
		System.out.println(numB);
		

		
	}

}
