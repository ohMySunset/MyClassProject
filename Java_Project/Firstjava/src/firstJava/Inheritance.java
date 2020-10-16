package firstJava;

public class Inheritance {

	public static void main(String[] args) {
		
/*
	 상 속? 
	 이미 만들어진 클래스를 상속해서 새로운 클래스를 정의한다.
	
	 클래스  : 변수, 메서드
          클래스를 상속한다는 것 -> 변수와 메서드를 상속받는다 (생성자, 초기화블럭 제외)
          상속받은 클래스를 재활용 + 알파 !
         사용목적 -> 클래스를 구성하는 규칙, 가이드
              
        
    class 새로운 클래스(자손클래스)  extends 부모클래스{
    
    }  
   
         ★ 자손클래스 생성자 내에서 부모클래스 생성자 호출하여 부모클래스의 인스턴스멤버를 초기화
         키워드 super  -> 상위클래스의 생성자 호출
                                         조상의 멤버를 가리키는 참조변수
    cf) this -> 인스턴스 나 자신을 가리키는 참조변수                                     
                                         
         자손의 생성자의 첫 문장에서 조상의 생성자를 호출해야함!
         
	상속을 위한 기본 조건!  -> is - a 관계 성립    /has - a(포함관계)의 의미와 구별
	                                       노트북 컴퓨터는 컴퓨터이다			 
	                                       
	                                       
	*오버라이딩 (상속의 관계)
	조상클래스로부터 상속받은 메서드를 해당 클래스에 맞게 변경하는것
	 조건 : 상속을 받은 메서드여야 함. 
	            ★ 선언부가 같아야 한다. (반환타입 이름 매개변수)                                     
                     하위클래스에서 정의된 메서드에 의해 상위클래스의 메서드는 가려짐.
                     
         자바클래스가 아무것도 상속하지 않을 경우, 자동으로 object를 상속함   (최고조상)
         모든 클래스는 object에 정의된 11개의 메서드를 상속받는다. 
         object 멤버클래스 : toString(), equals(object obj), hashcode()....
     


 */				
	
		
	}

}

