package Exam_Array;

import java.util.Scanner;

 public class Exam_Array1 {

	// 문제 1.
	//  int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최대값,
	//	그리고 최소값을 구해서 반환하는 메소드를 다음의 형태로 각각 정의.
    //	public static int miniValue(int[] arr) { . . . . } // 최소값 반환
	//	public static int maxValue(int[] arr) { . . . . } // 최대값 반환
    //	위의 두 매소드는 인자로 전달되는 배열의 길이에 상관없이 동작하도록 정의.
	//	두 매소드 실행을 확인인하기 위한 main 메소드 정의.
	//	int형 배열에 채워질 정수는 프로그램 사용자로부터 입력 받고, 배열의 길이는
	//	임의로 결정
 
	 
	   //최소값 구하는 메서드
	    public static int miniValue (int[] arr) {
	    	int min = 0;
	    	for(int i=1;i<arr.length;i++) {  
	    		min = arr[0];	    		    	
	    		if(arr[i]<min) {
	    			min = arr[i];			    		
	    	}        		
	    }
	    	return min;
	    }	
	    
	    //최대값 구하는 메서드
	    public static int maxValue (int[] arr) {
	    	int max = 0;
	    	for(int i=1;i<arr.length;i++) {
	    		max = arr[0];	    		
	    		if(arr[i]>max) {
	    			max = arr[i];
	    		}	        
	    }
	    	return max;
	    }	

 

	
	public static void main(String[] args) {
		
		int leng;
	    int[] arr;
	    
		 // 배열의 길이에 임의의 숫자 넣기 	
		leng = (int)(Math.random()*10)+1;	
    	System.out.println("배열의 길이 :"+ leng);
    	arr = new int[leng];
    
		 // 배열의 값 넣기	
		 
	 Scanner sc = new Scanner(System.in);		    		 
	 System.out.println("배열에 넣을 숫자를 입력하세요 . 최대"+ arr.length +"개 까지 가능합니다.");
		 
		 for(int i=0;i<arr.length;i++) {
		       arr[i] = sc.nextInt();  	   
		   }	      
		 System.out.println("입력하신 숫자를 확인해주세요.");		        
		        for(int n : arr) {	
		        System.out.print(n+"\t");
		        }  
		        
	   	System.out.println("\n다음의 수 중에서 최소값은"+Exam_Array1.miniValue(arr)+"입니다.");			           		
		System.out.println("다음의 수 중에서 최대값은"+Exam_Array1.maxValue(arr)+"입니다.");	 
		  
		 
	
		
		    
		
	

}}
