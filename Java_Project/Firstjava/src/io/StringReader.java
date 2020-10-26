package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class StringReader {

	public static void main(String[] args) throws IOException {
		
		// 문자 기반의 기본 스트림 인스턴스 생성
		Reader reader = new FileReader("TimeTable.txt");
		
		// 필터 스트림 BufferedReader는 기본 스트림이 필요
		BufferedReader in = new BufferedReader(reader);
		
		// 한 행의 문자열을 담을 변수
		String str = null;
		while(true) {
			
			str = in.readLine(); // 한 줄을 읽어 문자열을 반환 : 반환할 문자열이 없으면 null반환
		    if(str==null) {  // 마지막 줄일 때, 더 이상 가져올 문자열이 없음.
		    	break;
		    }
		    str = str.replace(":","시");
		    System.out.println(str);
		}
		
		
		
		in.close();		
	}

}
