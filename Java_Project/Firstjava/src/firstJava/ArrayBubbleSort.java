package firstJava;

public class ArrayBubbleSort {

	public static void main(String[] args) {
	
	   // < 버블정렬  >
	   // 소 --> 대  : 작은 수와 큰수를 비교해서 큰수를 오른쪽으로 정렬	
		
	   // 정수 데이터 10개를 저장하는 배열 생성
	  int[] number = new int[10];
	  
	   // 임의의 숫자 0~9까지의 숫자를 배열의 각 요소에 저장하자.
	  for(int i=0;i<number.length;i++){
		   number[i] = (int)(Math.random()*10); 
		   System.out.print(number[i] + "  ");
	  }
	  
	  System.out.println("\n------------------------------------"); 
	  
	   //각각의 자릿수 정렬 
	  for(int i=0;i<number.length;i++) { // 언제 끝날지 모르므로 일단 최대 요소의 개수만큼 돌려주어야 한다.
		 
		  boolean changed = false; // 자리바뀜이 발생 했는지 체크
		  		  
		//자리 바꿈 처리
		  for(int j=0;j<number.length-1-i;j++) { // 끝에서 이미 자리바꿈이 이루어진 것은 빼야하므로 -i 
			//왼쪽 인덱스 값과 오른쪽 인덱스의 값을 비교하고,
			  if(number[j]>number[j+1]) {
              //왼쪽 값이 크면 오른쪽으로 자리 변경 
				  int temp = number[j];
				  number[j] = number[j+1];
				  number[j+1] = temp;
				// 자리 바꿈이 있었을 경우 true  
				  changed = true; 
			  }
		  }
		  
		  if(!changed) {
			  break;
		  }
		  for(int k : number) {  //그냥 출력만
			  System.out.print(k+ " ");
		  }
		  System.out.println();
	  }
		

	}

}
