package method;

public class method_Exam3 {

	//문제3
	//원의 반지름 정보를 전달하면, 원의 넓이를 계산해서 반환하는 메서드와 (반지름*반지름*3.14)
	//원의 둘레를 계산해서 반환하는 메서드를 각각 정의하고, (반지름*3.14)
	//이를 호출하는 main메서드를 정의하자. (2*π*r), (π*r∧2)
    
	//원주율이 double형 -> 실수타입으로 정의
	//return타입 -> 반환타입도 double형
	                    //         ┌반지름
	static double cirArea(double radius) {
		return Math.PI * radius * radius; //넓이 구하는 공식
	}
	static double circu(double radius) {
		return 2* Math.PI * radius;  //둘레 구하는 공식
	}
	
	
	public static void main(String[] args) {
    //원의 넓이
	System.out.println(cirArea(5));	
	//원의 둘레	
	System.out.println(circu(5));
	}

}
