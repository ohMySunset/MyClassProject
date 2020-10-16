package firstJava;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PackageTest {
	
	public static void main(String[] args) {
	/*
	     package -> 폴더의 개념
	     import -> 다른 폴더에 있는 클래스에 있는 기능을 추가할 때 쓰임. 
	      
	      
	    package : 서로 관련된 클래스와 인터페이스의 묶음 , 일종의 폴더
	                               서브 패키지를 가질 수 있음.
	              java.lang.String -> lang은 java의 하위 패키지, String은 lang에 속한 클래스파일
	              java.util.*; -> .*: util안에 있는 모든 클래스를 불러온다.
	                                이름이 같은 클래스가 속한 두 패키지를 import하면 클래스 앞에 패키지명 필요!
	*/	
		
		Date today = new Date();
		  
		//System.out.println(today);
		
		SimpleDateFormat date = null;
		
		//yyyy -> 년도
		//MM -> 월
		//dd -> 일
		//hh -> 시간
		//mm -> 분
		//ss -> 초
        // a -> 오전 / 오후
		// 2020.10.15 10:56
		
		date = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		String now = date.format(today); //클래스가 String 타입을 반환하므로 String 타입으로 변수선언
		System.out.println(now);		
		
		
		
	}

}
