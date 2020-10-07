package Triangle;

public class TriangleClass {

	//삼각형의 밑변, 높이 정보를 지정할 수 있는 triangle 클래스를 정의하고,
	//밑변과 높이 정보를 변경시킬 수 있는 메서드와 삼각형의 넓이를 계산하여 반환하는 메서드를 함께 정의하자
	
	
	//1. 밑변, 높이 정보를 저장할 변수선언
   float width; //밑변
   float height;   //높이
	
	
	//2. 메서드 기능 1) 변수 밑변과 높이 정보를 변경 2)삼각형의 넓이를 구하고 결과를 반환
   
	// 1) 변수의 값을 변경하는 메서드
	public void triangleInfo(float num1, float num2) {
			width = num1;
			height = num2;		
			System.out.println("밑변 :"+ num1 +" 높이 :"+ num2);
	}
	// 2) 삼각형의 넓이를 계산하는 메서드 밑변*높이/2 -> 결과는 실수타입으로
	public float area () {		
		float result = 0.0f; //초기화		
		result = width*height/2;
		return result;
		// return width*height/2;
		
	}
	


 public static void main(String[] args) {
    //참조변수 선언
	TriangleClass t = new TriangleClass();
	
	//밑변을 구하고 높이 값을 설정
	t.triangleInfo(10, 56);
	// 넓이를 구하고 변수에 담는다.
	float result = t.area();  //참조변수.메서드();
    System.out.println("삼각형의 넓이 :"+result);
    
    
    //밑변을 구하고 높이 값을 설정
  	t.triangleInfo(10.1f, 32);
  	// 넓이를 구하고 변수에 담는다.
  	result = t.area();
  	 System.out.println("삼각형의 넓이 :"+result);
}

}