package firstJava;

public class StringIndex {
	
	
	public static void main(String[] args){
	
		//String index사용
		
		String str = "ABCDE";
		String result = " ";
		
		
/*
		for(int i=0;i<str.length();i++) {
			result += str.charAt(i);   // ""+'A' -> "A"+'B' -> "AB"+C -> "ABC
		
		}
			System.out.println("result -> "+ result);
*/
		// 문자열 거꾸로 출력
			for(int i=str.length()-1;i>=0;i--) {
				result += str.charAt(i);   
			
			}
				System.out.println("result -> "+ result);
	
}	
	
	
}	

