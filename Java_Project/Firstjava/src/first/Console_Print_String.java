package first;

public class Console_Print_String {

	public static void main(String[] args) {
		
	/*
	  - 출력문
	  println 출력 - 개행
	  print   출력 - 개행X
	  print, println --> 인스턴스의 참조값 전달 가능.
	  
	  
	  - 스캐너(Scanner)
	  다양한 리소스를 대상으로 입력받을 수 있도록 설계 
	  scanner(InputStream source)
	           System.in(참조변수)-->객체의 주소값 저장 
	              └static
	  public int nextInt()    -> 정수 입력         
	  public String nextLine() -> 문자열 입력
	   
	   
	  System(클래스이름).out(static변수이자 참조변수).println()
	                                                                        호출 --->
	
	
	
	- String 클래스?
	큰 따옴표로 묶여서 표현되는 문자열을 인스턴스화.		
	만약 같은 문자열이 또 쓰일 경우 주소를 공유해서 사용함.
	동일한 문자열의 인스턴스를 하나만 생성해서 공유
		
	 */
	String str = "My name is Sunny";  //인스턴스 생성, str-> 참조변수 
	int strLen1 = str.length();       //문자열의 길이. String을 이용하면 문자열을 필요한 형태로 바꿀수 있음.
	System.out.println("길이 1:"+ strLen1);	//출력 : 위 문자열의 길이는 16

	int strLen2 ="문자열의 길이는 어떻게?".length(); // 변수선언 없이 바로도 가능. ""가 있으면 String클래스
	System.out.println(strLen2);
	
	/* String 인스턴스에 저장된 문자열의 내용은 변경 불가 -> 변경시 새로운 인스턴스 생성	  
	 ex)String str = "ab" + "bc" + "cd";   --> 연산의 결과가 여러 개 만들어지므로 인스턴스도 매번 생성됨.
	  간단한 문자열 -> String 길고 복잡한 문자열 ->StringBuilder(문자열의 저장,변경), = 거의 같음 StringBuffer
	*/                                 //this의 반환(자신의 참조값 반환)       쓰레드(동시작업)에 안전
	
	String str1 = "My String";
	String str2 = "My String"; //위와 같은 문자열
	String str3 = "your String";
	String str4 = new String("My String"); //new키워드 사용-> 같은 문자열이지만 다른 인스턴스를 생성
	
	
	//참조변수 값의 동등 비교 : 같은 인스턴스를 참조한다?
	if(str1==str2) {
		System.out.println("같은 인스턴스를 참조한다.");
	} else {
		System.out.println("다른 인스턴스를 참조한다.");
	}
	
	if(str1==str3) {
		System.out.println("같은 인스턴스를 참조한다.");
	} else {
		System.out.println("다른 인스턴스를 참조한다.");
	}
	
	if(str1==str4) {
		System.out.println("같은 인스턴스를 참조한다.");
	} else {
		System.out.println("다른 인스턴스를 참조한다.");
	}
	
	System.out.println(str1.equals(str4)); //안의 텍스트 문자열(내용)을 비교해줌.
	System.out.println(str1.equals("str"));
	
	//charAt-> 해당 인덱스에 들어있는 문자를 뽑아낼 수 있음
	//★equals-> 문자열의 내용을 비교해줌. 자주 사용함.
	
	StringBuilder strBuf = new StringBuilder("AB");
	strBuf.append(25); //문자열 붙이기
	strBuf.append('Y').append(true);
	System.out.println(strBuf);
	//JAVA Api 참조!
	
	String strr = "ACDEFGHIJKLMN";
	for(int i= strr.length()-1;i>=0;i--) {
		System.out.println(strr.charAt(i));
	}

	
}
}
