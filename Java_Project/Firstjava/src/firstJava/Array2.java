package firstJava;

public class Array2 {

	public static void main(String[] args) {

/*    < 注意 >
         배열 -> 여러 개의 변수를 묶어놓은 집합
	 ☆ 배열에 저장하는 data는 참조값! = 주소값☆	
	 참조변수에는 변수의 값이 저장되어 있는 것이 아닌 어딘가에 저장되어 있는 변수의
	 주소값을 반환시키는 역할을 함
	
	 
	 < 2차원 배열 > 	 
  EX)                  세로길이   가로길이
	                                       행의개수  열의개수
	 int[][]arr2 = new int[3] [4];
	   └> 배열 선언             └>생성	  
	  
	 arr2[행 index][열 index]
	  └> 위치 정보로 참조	 
	 	
	->> arr2 2차원 배열은 1차원 배열 세 개를 만들어서 저장한 것과 같다.  	
	
     행\열        1      2      3      4
	1   [0][0] [0][1] [0][2] [0][3]   arr2[0].length = 4  arr2의 0번지 길이
	2 	[1][0] [1][1] [1][2] [1][3] → arr2[1].length = 4  arr2의 1번지 길이
	3 	[2][0] [2][1] [2][2] [2][3]   arr2[2].length = 4  arr2의 2번지 길이
    ↓
 1차원 배열이 세 개 모인것
 arr2.length = 3
 
 
 
*/
	int[][] arr = null;
	arr= new int[3][4];
	arr[0][0] = 10;
	System.out.println("arr[0][0] => "+arr[0][0]);
	arr[1][3] = 13;
	System.out.println("arr[1][3] => "+ arr[1][3]);
	
	
	//2차원 배열 arr은 1차원 배열이 세 개 저장된 주소값을 가진다
	System.out.println(arr.length);  //2차원 배열 arr의 length값 = 1차원 배열의 개수. = 행의 개수
	//2차원 배열은 1차원 배열을 가지는 배열이다
	System.out.println(arr[0].length);  //첫번째 1차원 배열의 주소값을 가짐. = 열의 개수
	System.out.println(arr[1].length);	//두번째 1차원 배열의 주소값을 가짐
	System.out.println(arr[2].length);	//세번째 1차원 배열의 주소값을 가짐

	
//	System.out.println("2차원 배열의 모든 요소 출력======================");
	showData(arr);
	//for반복문을 이용해서 2차원 배열의 모든 요소를 참조
	
//	for(int i=0;i<arr.length;i++) { //0,1,2번지
//		for(int j=0;j<arr[i].length;j++) { //0,1,2,3번지
//			System.out.print(arr[i][j]+"\t");
//		}
//		System.out.println();
//	}	
	System.out.println("2차원 배열의 모든 요소에 데이터 저장====================");
	//전체 요소에 값을 대입
		for(int i=0;i<arr.length;i++) { //0,1,2번지
			for(int j=0;j<arr[i].length;j++) { //0,1,2,3번지
		     arr[i][j] = i+j;
		     System.out.print(arr[i][j]+"\t");
			}	
			System.out.println();
		}


		
/*  < 2차원 배열의 가변배열 >	
   int[][] score = new int[5][];
   1차원 배열의 사이즈를 지정하지 않고 밑에서 정의해줄 수 있음!! 
   score[0] = new int[4];   0 0 0 0
   score[1] = new int[3];   0 0 0
   score[2] = new int[2];   0 0
   score[3] = new int[7];   0 0 0 0 0 0 0
   score[4] = new int[5];   0 0 0 0 0
*/	
	//가변배열 
  int[][] arr2 = new int[3][];
  arr2[0] = new int[3];
  arr2[1] = new int[5];
  arr2[2] = new int[2];
 
  
  
   //< 배열을 이용한 자리배치 > 
  
   //배열의 요소 출력
  System.out.println("가변배열의 요소 출력 =================");
  showData(arr2);
  
   String[][] place = new String[6][];
   place[0] = new String[2];
   place[1] = new String[4];
   place[2] = new String[3];
   place[3] = new String[3];
   place[4] = new String[3];
   place[5] = new String[3];
   
   System.out.println("자리배치==========================");
   showData(place);
   
 
   
   //< 배열의 선언과 초기화 동시에 진행하기 >
   
   int[][] arr3 = { //2차원 배열 표현
		   {1,2},      //1차원 배열 표현
		   {3,4,5},
		   {6,7,8,9},		   
   };
   //2차원 배열의 크기 출력
   System.out.println("2차원 배열의 세로길이(1차원 배열의 개수) : "+ arr.length);
   //1차원 배열의 크기 출력
   for(int i=0;i<arr3.length;i++) {
	   System.out.println("arr3["+i+"].length : "+ arr3[i].length );
   }
   
 
   
   
   
   
/*
   < for - each >   
         배열의 전체 참조가 필요한 경우 사용!         
	 코드 분량이 짧아짐.
	but, 배열 값의 변경이 불가능하기 때문에 참조목적으로만 사용한다! 
	  
	  for(int i=0;i<arr.length;i++)
	  System.out.print(arr[i] + " ");
	             ↓
	  for(int e : arr)   e라는 임시변수에 배열arr의 모든 요소를 차례로 넣어서 반복해줌.
	  System.out.print(e + " ");	 
*/
   
   //for-each 구문 : 배열의 원본데이터의 수정이 아닌 일괄참조의 목적일 때 사용한다. 
   int[] arr4 = {1,2,3,4,5};
   
   int sum = 0;
   for(int n:arr4) { //n이라는 임시 변수에 arr4배열의 모든 요소를 넣어줌.
	  // System.out.println(n);
	   sum += n;
   }
     System.out.println("배열 arr4 요소들의 합 :" + sum);
     
   // for-each에서의 값의 변경은 배열과 무관, 영향을 주지 않음.
   for(int n : arr4) {
	   n++;   //변수들의 값은 증가함.  2,3,4,5,6
	   System.out.println(n);
   }
      System.out.println();
    
      for(int n:arr4) {  //위에서 값을 변경했음에도 배열은 영향을 받지 않음.
    	  System.out.println(n); //1,2,3,4,5
      }
   //인스턴스 배열에 저장된 참조값(주소값)의 변경은 불가능하나, 주소값을 통해 인스턴스 객체에는 접근할 수 있다.
   
  
      
      
      
      
      
}		
 	
  // 정수형 2차원 배열을 전달 받아
  // 모든 요소의 값을 출력하는 메서드	
  // 반환하는 데이터는 없다.
	                     //┌>배열을 매개변수로 받을 수 있다!
	static void showData(int[][] arr) {
		System.out.println("2차원 배열의 모든 요소 출력======================");
		    for(int i=0;i<arr.length;i++) { //0,1,2번지
				for(int j=0;j<arr[i].length;j++) { //0,1,2,3번지
					System.out.print(arr[i][j]+"\t");
				}
				System.out.println();
	            }
	  }
	

	
	static void showData(String[][] arr) {  //메서드의 오버로딩 , 메서드 이름이 같아도 타입이 다르므로 상관 없음
		System.out.println("2차원 배열의 모든 요소 출력======================");
		    for(int i=0;i<arr.length;i++) { //0,1,2번지
				for(int j=0;j<arr[i].length;j++) { //0,1,2,3번지
					System.out.print(arr[i][j]+"\t");
				}
				System.out.println();
	            }
	     
	            }
		
	
}	

