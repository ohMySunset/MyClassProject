package Exam;


public class Exam_Variable {

	public static void main(String[] args) {

     //주의! JAVA는 대/소문자 구분이 확실함
		
	// 문제 2
	// 주민등록번호를 표현   ex) 930000-0000000 
	//13자리를 넘어가기 때문에 int로 표현할 수 없고 long으로 혹은 String으로 하이픈까지 표현가능. 
    
	//int regNo = 9300000000000;	
	//long regNo = 0000000000000L; 2000년대 생은 표현하기 힘듬
	String regNo = "001234-5678901";	
	
	/*
	// 변수 문제 되짚어보기
	 
	문자열 + anytype  => 문자열
	anytype + 문자열  => 문자열
	
	null 참조형 변수 -> 참조값이 없을 때 초기화 값.
	                == != 주소값의 비교만 가능할 뿐 연산은 불가능하다
	참조형 변수 -> 인스턴스 객체의 주소값을 저장하는 변수. 4byte 크기, 음수표현 불가능.  
	              
	              
	★ 자동형변환     (꼭 기억하기!)         
	
	           ↗  short ↘        
	 byte            int → long → float → double
	           ↘   char ↗      
	
	
	
	char 2byte -> 8bit가 2개 
	             2의16승 -> 0을 포함해 65536개를 표현 -> -32768 ~ 32767
	byte 1byte -> 8bit
	             2의 8승  -> -128 ~ 127
	
	*/
	
	}

}
