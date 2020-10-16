package Exam;

public class Exam_StringTest {

	public static void main(String[] args) {
	
		
		
	//	문제 1. 다음 형태로 String 인스턴스를 생성.		 
	//	String str = “ABCDEFGHIJKLMN”;		 
	//	그리고 이 문자열을 역순으로 다시 출력하는 프로그램을 작성.

	//<방법1> for문 활용
	String str = "ABCDEFGHIJKLMN";
	String result = "";
	for(int i= str.length()-1;i>=0;i--) {
		result += str.charAt(i);
	}
	System.out.println(result);
	
	//<방법2> StringBuffer 활용
	StringBuffer sb = new StringBuffer(str);
	sb = sb.reverse();
	System.out.println(sb = new StringBuffer(str).reverse());		
		
		
	//문제 2. 다음 형태로 주민번호를 담고 있는 String 인스턴스를 하나 생성
	//String str = “990929-1010123”		 		 
	//이 문자열을 이용하여 중간에 삽입된 – 를 뺀 String 인스턴스를 생성.	
	
	str = "990929-1010123";
	//<방법1> 0~9가 아닌것 제외하고 이어붙이기
	sb = new StringBuffer();
	for(int i=0;i<str.length();i++) {
		char c = str.charAt(i);
		if(c>='0' && c<='9') {
			sb = sb.append(c);
		}		
	}
	   System.out.println(sb);
	//<방법2>	 '-'를 공백문자로 대체하기
	 str = str.replace("-", "");
	 System.out.println(str);
	
	   
		
		
		
	System.out.println("------------------------------------------------");
	
		/*
		 
		String str = "ABCEDFGHIJKLMN";
		int numOfStr = str.length();
		int index = numOfStr-1;    //배열이나 문자열의 위치 index는 0~N-1
		
		String result = "";
		
		StringBuffer  sb = new StringBuffer();	//긴 문자열을 사용할 때	
		
		//String 클래스의 charAt() 메서드를 이용해서 역순으로 출력
       for(int i=index; i>=0;i--) {
    	   result += str.charAt(i); // result = result + String
    	                            //          └새로운 String객체┘
          sb.append(str.charAt(i)); // 뒤의 처리가 이루어지면 sb만 남음
       }
		System.out.println(str);
		System.out.println(result);
		
		
		
		//StringBuffer 클래스 이용
		sb = new StringBuffer(str);  //StringBuffer안에 str의 문자열이 저장됨.
		//System.out.println(sb);
		//sb = sb.reverse();
		
		System.out.println(sb.reverse());
		
	*/
		
		
		/*
		//문제 2. 다음 형태로 주민번호를 담고 있는 String 인스턴스를 하나 생성
		//String str = “990929-1010123”		 		 
		//이 문자열을 이용하여 중간에 삽입된 – 를 뺀 String 인스턴스를 생성.
		
		str =  "990929-1010123";
		sb = new StringBuffer();  //총 16개의 문자를 저장할 수 있음.
		
		//String charAt() 이용
		for(int i=0; i<str.length();i++) {
			//'-'가 아닌 경우, '0'~'9' => 문자열을 붙이기
			char c = str.charAt(i);
			if(c>='0' && c<='9') {
				sb.append(c);
			}
		}
		System.out.println(sb);
		
		//String replace() 이용
		result = str.replace("-",""); //앞의 문자를 뒤의 문자로 변경
		System.out.println("result : "+result);
		
		*/

		
		
		
	}

}
