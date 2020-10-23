package Collection;

import java.util.ArrayList;
import java.util.Iterator;

public class iteratorTest {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("First");
		list.add("Second");
		list.add("Third");
		list.add("forth");
		
		//iterator<E> 인스턴스 생성 : Collection<E>가 포함하는 interator() 메서드를 호출
		System.out.println("요소 출력");
		
		Iterator<String> itr = list.iterator();
		
		// hasNext(), next(), remove()
		while(itr.hasNext()) { //다음 요소가 있는지 검사
			String str = itr.next(); //있을 때
			System.out.println(str);
			
			if(str.compareTo("Third")==0){ //논리값이 나와야 하므로  ,비교연산		
				itr.remove(); //원본이 삭제
			}
		}
		System.out.println("요소 삭제 후 리스트 출력");
		
		itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
