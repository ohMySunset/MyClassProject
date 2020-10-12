package firstJava;

public class Pick {

	public static void main(String[] args) {
		
	// 배열 생성  -> 배열도 인스턴스
	// 자료형[] 배열변수명 = new 자료형 [배열이 총수];
	// 자료형 배열변수명[] = { }; 선언과 동시에 초기화	
	// new String[18]	
	String[] members = {
			"고한경","김정현","김효영","남서아","서지민",
			"양선경","이도경","이수진","이정민","장명지",
			"장윤혁","정인수","진효선","최정은","최지혜",
			"최혜인","한우리","한주량"
	};
		System.out.println("배열의 요소의 개수:" +members.length);
    //배열의 index는 0부터 시작
    //index의 범위는 0 ~ n-1
	//배열과 반복문(for)은 절친이다.	
	for(int i = 0; i < members.length; i++) {
		System.out.println(members[i]);
	}
	//임의의 요소 하나를 추출한다.
	int index =(int)(Math.random()*18); //랜덤은 더블 타입이기 때문에 0.0 <= index < 18.0 
	                                    //앞에 인티저를 붙여주어서  0 <= index < 18으로 바뀜
	System.out.println("축출된 index :" + index);
	System.out.println("반장 당선을 축하합니다->" + members[index]);
	
	
	}

}
