package Basic;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
	
		String strData = "cool|진|jin@gmail|서울|010-9999-8888"; //구분자는 변경 가능
		StringTokenizer st = new StringTokenizer(strData, "|", false); //뒤에 true를 붙여주면 , 까지 토큰으로 인식
		//hasMoreToken()  --> true/false  해당 위치에 토큰이 있는지 없는지 확인
		//nextToken() 
		while(st.hasMoreTokens()) { // 반복문으로 돌려주어야함
			System.out.println(st.nextToken());
		}
	
	
	System.out.println("------------------------------------");	
		
	String pNum = "Tel 82-010-9999-7777 son";
	StringTokenizer st1 = new StringTokenizer(pNum); //구분자가 없을 경우 공백(스페이스)가  엔터키와 같이 처리됨.
	
	while(st1.hasMoreTokens()) {
		System.out.println(st1.nextToken());
	}
	
	System.out.println("------------------------------------");	
	
	StringTokenizer st2 = new StringTokenizer(pNum, " -"); //구분자는 "-"," " 둘다 사용
	 while(st2.hasMoreTokens()) {
		 System.out.println(st2.nextToken());
	 }
	 
	 System.out.println("------------------------------------");	
	 
	StringTokenizer st3 = new StringTokenizer(pNum, "- ", true);
	while(st3.hasMoreTokens()) {
		System.out.println(st3.nextToken());
	}
	
	}
	
}
