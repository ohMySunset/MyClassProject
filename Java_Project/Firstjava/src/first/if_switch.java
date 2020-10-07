package first;

import java.util.Scanner;

public class if_switch {

	public static void main(String[] args) {

	 Scanner sc = new Scanner(System.in);
  // 공백문자열 + if + 논리연산자		
  String str = "";    
  char ch = ' ';
  boolean result;
  if (result = ch == ' '|| ch == '\t') {
 	  System.out.println(result);
  }
  ch = 'c';
  if ((ch == 'c')|| (ch == 'C')) {
	  System.out.println(ch);
  }
  if (str.equals(null)||str.equals("\t")){
	  System.out.println(str);
  }
   
  //문자열 "3" -> 문자 '3'변환하기
  str = "3"; 
  if(str!=null && !str.equals("")) {
	  ch = str.charAt(0);
	  System.out.println(ch);
  }
  /*
   // 성적 입력받고 출력하기
   int score;
   String grade;
  
   System.out.println("점수를 입력하세요");
   score = sc.nextInt();
   
   if(score>=90) {
	   grade = "A";
	   if(score >= 95) {
		   grade += "+";
	   }
   } else if(score >=80) {
	    grade = "B";
   } else {
	   grade = "c";
   }
   System.out.println("성적은 "+grade+" 입니다.");
  */
  /* 
   // Switch문 하나의 부류로 묶어보기
   int n; 
   System.out.println("오늘 배운 자바 학습 내용 어떠셨나요?\n 1.매우 쉽다 2.쉽다 3.보통 4.어렵다 5.매우 어렵다");
   n = sc.nextInt();
   switch(n) {
   case 1 : case 2 :
	   System.out.println("고수이시군요!");
	   break;
   case 3:
	   System.out.println("아주 좋아요!");
	   break;
   case 4 : case 5 :	
	   System.out.println("괜찮아요 조금 더 노력해보아요!");
	   break;
   }
   */
    int score;
    System.out.println("당신의 성적은 몇 점 인가요?");
    score = sc.nextInt();
    String grade;
   switch(score/10) {
              case 10 :
             grade = "A+";
             System.out.println("아주 잘했어요!"+grade+"입니다");
             break;
             case 9 :
	         grade = "A";
	         System.out.println("아주 잘했어요!"+grade+"입니다");
	         break;
             case 8 :
             grade = "B";
             System.out.println("분발하세요"+grade+"입니다");
             break;
             case 7 :
             grade = "c";
             System.out.println("분발하세요"+grade+"입니다");
             break;
             default:
             System.out.println("시험에 통과하지 못했습니다"); 	 
   }
   
   
   
   
   sc.close();
		
	}

}
