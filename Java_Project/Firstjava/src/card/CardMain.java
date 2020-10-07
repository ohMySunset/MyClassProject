package card;

public class CardMain {

	 static int weight = 5;
	
	 
	public static void main(String[] args) {

		
  System.out.println(Math.PI);	// 자바에서 제공해주는 static변수
		                 //상수
		
  System.out.println((int)(Math.random()*8));
  
  
  System.out.println(CardMain.weight);//CardMain클래스 안의 클래스 변수이므로		
		
  System.out.println("카드의 폭 사이즈: "+ Card.width); // 인스턴스 생성 필요없이 바로 불러올 수 있음
		                             //클래스이름.클래스변수이름
    
  Card.play(); //static메서드는 바로 불러올 수 있음
  
  Card c1 = new Card();
  Card c2 = new Card(); 
  
   System.out.println("=========================");
  System.out.println("카드 1의 정보");
  System.out.println("모양 :"+c1.kind+"숫자는:"+ c1.number);
  System.out.println("카드 2의 정보");
  System.out.println("모양 :"+c2.kind+"숫자는:"+ c2.number);
  
  c1.play();
  
   System.out.println("카드의 폭 사이즈: "+ c1.width);
                                     //참조변수.인스턴스변수이름
   System.out.println("카드의 폭 사이즈: "+ c2.width);
   
   Card.width = 120; //클래스 변수의 값을 변경.
   System.out.println("카드의 폭 사이즈 변경");
   
   System.out.println("카드의 폭 사이즈: "+ c1.width);
   System.out.println("카드의 폭 사이즈: "+ c2.width);
	}         

}
