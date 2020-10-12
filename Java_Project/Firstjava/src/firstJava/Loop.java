package firstJava;

public class Loop {

	public static void main(String[] args) {
  /*
    
     반복문!?
   반복의 조건  + 탈출의 조건   (탈출의 조건이 주어지지 않는다면? -> 무한루프)
  
   조건식 + {반복 처리할 구문} 또는 문장으로 구성. 
  
   반복의 횟수가 중요한 경우 -> for문  그 외 while문 사용
   
   ★for
   - 반복의 횟수가 정해졌을 때
   for (int i = 0, i < 0, i++){
        index    반복의 조건    증감식  
   }
   
     배열(데이터의 묶음, 순서[index]) ---> for 반복문	
  
   ★While
   - 반복의 횟수를 모를 때
        데이터 베이스를 활용
        
   ★do ~ While
   - 한 번은 반드시 처리

  
  While 반복문
  While (condition) {   앞의 조건식이 true 일 때 실행되는 문장.
        true/false
  }
  - while 문 안에 while문 중첩이 가능함.	
*/	
		
 //ex)		
 int i = 0;	 // 반복의 횟수를 체크하기 위한 인덱스
 while (i < 5) {
	System.out.println("자바 안녕~!!"+i);
	i++;  //탈출을 위한 연산식
}	
   //위의 while문을 실행하고 나면 i => 5
 
	System.out.println("===============================");
  
   //do while loop
   //최소 한번 실행 후 조건에 맞게 반복 실행
	
 do {
	System.out.println("안녕 자바!!"+i);
	i++;
} while (i<5);
  // 위에서 i가 5였기 때문에 조건이 충족하지 않음에도 무조건 한번은 실행하여 결과를 출력함.


  /*
   for 반복문
  for( (1)int i = 0; (2)i < 5; (4)i++ ){ (3)조건식이 true일 경우 수행되는 문장
                           초기화                    조건식              증감식
   }
   - 곱하기에서는 초기화를 1로 해준다. 0은 어떤 수를 곱해도 0이 나오기 때문에 
   */
  
  System.out.println("===============================");
  
  
  // 1~10까지의 합계 구하기
  int sum =0; //합을 구하기 위한 변수
  for(int k=1; k<11; k++) {
	  sum += k; //sum = sum + k;
	            // 블럭 안을 벗어나면 for문의 변수인 k는 소멸하게 됨.
	            // 블럭 안에서만 사용가능!
  }
  // System.out.println(k); //에러 괄호 밖에서는 변수k를 불러올 수 없음
  System.out.println("1~10까지의 합:"+ sum);
  
  System.out.println("===============================");
  
 /* 
   ★continue & break
   
  While(조건식){
                처리1  
       continue  (밑의 처리를 무시하고 다시 조건 검사로 이동)
                 처리2
  }
  */
  
  // 0부터 몇까지 더해나갔을 때 그 합이 100이 넘어가는지 확인
  sum = 0;
  i = 0;
  
  //몇 번이나 반복해야 하는지 모르는 경우 -> 무한반복 처리
  while(true) { // 무한 반복     
    // 탈출의 조건
	 if(sum > 100) {
     break; //break를 감싸고 있는 블럭(while문)을 탈출!
	 }
      i++;  //더하는 수의 증가
      sum += i; //합을 구하는 연산
  }
  System.out.println(i + "를 더했을 때 합이 100이 넘어갑니다. 100을 넘어가는 최초의 값은 "+sum +"입니다");

  System.out.println("==================================================");
  
  //1~10까지의 수 중에서 3의 배수를 생략하고 출력하기 
  for(i = 0; i < 11; i++) {
	/*  if(!(i%3==0)) {
		  System.out.println(i);
	  }
	*/	  
	  if(i%3==0) { //3의 배수를 찾는 조건
		  continue; //3의 배수일 시 밑에서 출력되지 않고 다시 조건문으로 올라감.
	  }
	  System.out.println(i);	  
	  
  }
  System.out.println("==================================================");
  
  //continue를 이용한 숫자 찾기!
  //0~100까지의 숫자 중에 5의 배수 이면서 7의 배수인 숫자를 출력하고 총 몇개가 존재하는지 개수를 출력
    int num = 0;
    int count = 0;
    while((num++)<100) {
    	  //num++;
    	if(num%5!=0||num%7!=0) { //=  !(num%5==0 && num%7==0)
    		continue;    		    	
    	}
    	count++;
    System.out.println(num);	  	
    }
    System.out.println("0~99사이의 숫자 중에 5의 배수이면서 7의 배수인 숫자는 모두" + count + "개가 있습니다");  
  
   System.out.println("==================================================");
     
    
   //자연수 1부터 모든 홀수와 3의 배수이면서 짝수인 수를 모두 더해나간다.
   
   
   
   
   
   System.out.println("==================================================");
   //이중 for문
  outerLoop : for(i = 1; i < 10; i++) {
	  
	   for(int j = 1; j< 10; j++) {
		   System.out.println("["+i+","+j+"]");  //[1,2] [1,3]
		   if(i%2==0 && j%2==0) {  // i와 j가 모두 짝수일 경우는 break
			   break;
			 //  break outerLoop; // 위의 if문이 만족했을 때 아예 전체 블록을 탈출
		   }
	   }
	   
   }
    
	// random
	int r;
	r = (int)(Math.random() * 10);  // math.random -> 더블형이므로 앞에 인티저를 넣어줌
	                               //*뒤의 숫자 범위 내에서 랜덤으로 출력
	System.out.println("r="+r);
   
   //java.lang.system  -> system 클래스들을 가진다
   //패키지 - 폴더 - 클래스 
   //System.currentTimeMillis  -> 1970.1.1.00시00분00초부터 현재 까지 밀리초로 반환(long타입)
 
   
    
    
	}

}
