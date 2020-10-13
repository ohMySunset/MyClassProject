package firstJava;

public class Array1 {
	
	public static void main(String[] arg) {


/*
	★배열 - 많은 변수들의 묶음
	      (같은 타입의 변수)
	 Q. 어떨때 사용하나요?
   1. 변수선언 10번, 연산도 10번 훨씬 쉽게 可
   2. 일련번호, 연속된 번호,data
     -> for반복문!! 배열과 따페이
   3. 모든 변수에 +10 => 반복문이용!
   
	  참조방법 배열이름[index]  --> 순차작업에 용이
	★배열을 이용하면 공통작업을 빠르게 할 수 있고, 코드도 줄일 수 있다. 
	
	<배열 변수의 선언>	
	
	int numArr[]
	int[] numArr = null; 참조변수이기 때문에 초기값은 null을 가짐
	                                          배열의 요소 또한 기본값으로 초기화
	int[] numArr = new int[n];
	-> n개의 int값을 저장할 수 있는 배열을 생성하고 묶음을 만든다.
	*numArr.length => 배열의 길이정보(요소의 개수)
	
	배열 또한 인스턴스이다!
	numArr (0x100) -> numArr[0],numArr[1],numArr[2],....
	       배열의 주소를 생성      numArr[위치값=index]
	                          0 ~ n-1까지
	                          
	int[] score;  
	score = new int[5]; -> 인스턴스를 생성했을 때 비로소 저장할 공간이 생김.                      
	                          
	★참조형변수를 다루는 배열                        
	String[] -> 변수의 값을 저장하는 것이 아닌 String 타입의 주소값을 저장하는 참조변수들의 집합임!
	                        배열의 인스턴스로 객체의 주소값을 생성하면 훨씬 더 많은 데이터를 활용할 수 있음. 
	           
	
*/	
   //배열의 선언 : 자료형[] 배열이름
   //정수형 배열을 선언	
    int[] arr = null;
    
   //배열의 생성 : 변수들의 저장 공간을 생성 
   //new 자료형[요소의 개수] : 개수 만큼의 변수를 생설하고 묶음을 만든다. 
    arr = new int[3];
		
	//배열의 참조 : 입력, 대입, 읽기	
    //배열이름[index] : 배열의 변수는 순차적으로 위치하기 때문에 index값으로 참조한다.
	//index : 0부터 요소의 개수-1 까지의 index를 가진다. 	
    //요소의 개수는 ★배열이름.length 인스턴스 변수에 저장된다. 
    arr[0] = 1;
    arr[1] = 2;
    arr[2] = 3;
    
    System.out.println("배열 arr요소의 개수 : "+ arr.length);
    
    for(int i=0;i<arr.length;i++) {
    	System.out.println(arr[i]);
    }
    //int sum = arr[0]+arr[1]+arr[2];
    int sum = 0;
    for(int i=0;i<arr.length;i++) { //배열 요소의 개수를 모를때, for반복문 이용
    	sum += arr[i];
    }
    System.out.println("arr배열 요소들의 합 : "+sum);
    
    
   // int[] arr2 = new int[3];
   //생성과 동시에 배열 요소의 초기화
    int[] arr2 = {1,2,3}; //내가 써야하는 데이터가 정해져있는 경우
    System.out.println("배열 arr2의 요소의 개수 : "+arr2.length);
    for(int i=0;i<arr2.length;i++) {
    	System.out.println(arr2[i]);
    }
    
       
    
    int[] arr3 = null;
    arr3 = arr2;
    arr3 = arr;
  
    
    
    //  ★예제 1 
    int[] arr4 = {1,2,3,4,5}; // 원본데이터
    int[] ref;
    ref = addAllArray(arr4,7);
     
    if(ref==arr4) {
    	System.out.println("동일한 배열을 참조한다");
    } else {
    	System.out.println("동일한 배열을 참조하지 않는다");
    }
    for(int i=0;i<arr4.length;i++) {
    	System.out.println(arr4[i]);
    }
 
    System.out.println("=================================");
    for(int i=0;i<ref.length;i++) {
    	System.out.println(ref[i]);
    }
 
   
    
    
    System.out.println("=================================");
    // ★예제 2
    // 로또 번호 축출 프로그램
     
    // 정수데이터 1~45까지 숫자를 저장하는 변수 45개 생성 -> int타입의 배열 선언, 생성
    int[] ball = new int[45];
    // 각 변수에 1~45까지의 숫자를 중복되지 않게 저장.
    for(int i=0;i<ball.length;i++) {
    	ball[i] = i+1; //(0~44) + 1 --> 1~45까지의 숫자를 저장   
    //	System.out.println(ball[i]); //1~45까지의 숫자가 정상적으로 저장되었는지 확인	
    }
    // 각 index의 값들을 섞는 처리 : index=0의 값과 임의의(1~44) index의 값을 서로 바꾼다.
     int j = 0;   //임의의 index
     int temp = 0; //각 변수의 값을 바꾸기 위한 임시변수

     for(int i=0;i<10000;i++) {
    	 //임의의 index를 구한다 : 1~44
    	 j = (int)(Math.random()*44)+1; //0~43 -> 1~44번지
    	 
    	 temp = ball[0];
    	 ball[0] = ball[j];
    	 ball[j] = temp;    
     }
     
     // 배열에서 0~5까지의 변수값을 출력
     System.out.println("6개 번호 축출==============");
     for(int i=0;i<6;i++) {
    	 System.out.print(ball[i]+"\t");
     }
        
  
     
}
	//int 타입의 배열을 받고, 증가시킬 정수값을 받아서
	//각 배열의 요소에 받은 정수값 만큼 증가시키고
	//전달 받은 배열을 반환하는 메서드   
	//1차원 배열을 매개변수로 받아올 수 있음.
	
	 static int[] addAllArray(int[] ar, int addValue) { //메인메서드에서 호출하려면  static메서드 
		for(int i=0;i<ar.length;i++) {
			ar[i] += addValue;
		}		 
		 return ar;
	    }
	
	 
	 	 
}
