package Exam_Array;

public class Exam_Array2 {

	
	//문제 2.
	//	다음 메서드는 int형 1차원 배열에 저장된 값을 두 번째 매개변수로 전달될 값의 크기만큼 전부 증가시킨다.
    //	public static void addOneDArr(int[] arr, int add){
	//          for (int i=0, i<arr.length; i++) arr[i] +=add;
	//    }
	//  이 메서드를 기반으로(이 메서들르 호출하는 형태로)int형 2차원 배열에 저장된 값 전부를 증가시키는 메서드를 다음의 형태로 정의하자.
	//	public static void addOneDArr(int[][] arr, int add) { . . . . . }
	//	단 위 메서드는 2차원 배열의 가로, 세로 길이에 상관없이 동작해야 하며, 
	//  위의 메서드가 제대로 동작하는지 확인하기 위한 main 메서드도 함께 정의해야 한다.
	
	
	public static void addOneDArr(int[][] arr, int add) { 
		System.out.print("변경된 2차원 배열의 값 :\n");
		for(int i=0;i<arr.length;i++) {    //2차원 배열이 가지는 1차원 배열의 개수만큼 반복	
			       for(int j=0;j<arr[i].length;j++) {  //각각의 1차원 배열을 반복
			    	  System.out.print(arr[i][j]+add+"\t");
			       }		
			       System.out.println();
		}	
	}
	

	public static void main(String[] args) {

		
		int[][] arr1 = new int[][] {
			                        {1,2,3},
			                        {1,2,3,4}
		                           };	
		System.out.println("2차원 배열의 초기값 : ");
		for(int i=0; i<arr1.length; i++) {
			for(int j=0;j<arr1[i].length;j++) {
				System.out.print(arr1[i][j]+"\t");
			}
			System.out.println();
		}
		
		//값을 변경시키는 메서드  호출
		addOneDArr(arr1,3);	
		
		
		
		
	}


	
	
	
}
