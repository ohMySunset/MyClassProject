package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public static void main(String[] args) throws IOException { //예외처리 상위타입 
	
	/*
		☆ 자바의 입출력
		
		< 자바의 스트림 >
		입출력 장치와 프로그램을 연결 -> 데이터 흐름을 처리하는 sw기능
		
		입력스트림  : 입력장치 -> 자바 프로그램
		출력 스트림 : 자바 프로그램 -> 출력장치
		스트림클래스는 추상클래스이기 때문에 하위클래스에서 인스턴스의 생성을 형성해주어햐 한다.
		
		스트림 구조 : FIFO (First In First Out)
		                      데이터의 순서가 바뀌지 않음
		                      단방향 (읽기 쓰기가 동시에 되지 않음)
		                      
	        스트림 종류 : 바이트 스트림  -> 바이트 단위/ 1바이트씩 입출력/ 데이터의 기본단위/ 이미지 동영상 처리에 주로 사용
	                             문자 스트림  -> 유니코드 문자 입출력/ 2바이트씩/ 이미지나 동영상 불가, 문자데이터만 가능
	                             버퍼 스트림  (핀터 스트림) -> 버퍼링을 사용/ 문자, 문자배열, 문자열을 효율적으로 처리
		 
		  
		          
		 직렬화 -> 인스턴스를 파일로 저장, 읽기를 처리, 저장순서를 가짐.
		 ObjectInputStream(복원) , ObjectOutputStream(저장)
		  	 readObject            writeObject 
	 */  
		 // 읽어올 대상 파일의 InputStream 인스턴스 생성	
			InputStream in = new FileInputStream("org.pdf"); //예외가 발생할 수 있기 때문에 try-catch
         // 출력 대상 파일의 OutputStream 인스턴스 생성
			OutputStream out = new FileOutputStream("org_copy.pdf"); 
			// 해당 경로에 파일이 존재하지 않으면 파일을 생성해서 write
			// 해당 경로에 파일이 존재하면 덮어쓴다.
		
			int copyByte = 0; // 복사한 사이즈
		//	int bData = 0;    // 원본에서 복사한 바이트 사이즈의 데이터
			
			byte[] buf = new byte[1024]; //1kbyte 버퍼 생성  
			int readLength = 0;   //얼만큼 읽어왔는지
			
			
			System.out.println("복사를 시작합니다.");
						
			while(true) {
			//	bData = in.read();
				readLength = in.read(buf);
				// 더이상 가져올 데이터가 없으면 -1을 반환
				//if(bData==-1)
				if(readLength==-1) { 
					break;
				}
			//	out.write(bData); // 출력 : 파일에 바이너리 코드를 쓴다.
				out.write(buf, 0, readLength); //어디에서, 어디부터, 어디까지 가져올건지
				copyByte += readLength;  //읽어온 개수만큼 반환
			}
			//스트림 인스턴스 소멸
			in.close(); 
			out.close(); 
			
			System.out.println("복사가 완료되었습니다.");
			System.out.println("복사된 사이즈는 : " + copyByte + "byte");
			
			
			
			
			
			
			
			
	}
	

}
