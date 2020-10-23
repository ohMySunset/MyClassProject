package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		
		
		// List<E> : 저장 순서가 유지 (반복문 이용 可),  중복 저장 허용
		// 인스턴스 저장을 목적으로 하는 클래스
		// java.util 안에 있으므로 import 해주어야 함.
		// List 인스턴스 생성
		// ArrayList<Integer> list = new ArrayList<Integer>();		
		// LinkedList<Integer> list = new LinkedList<Integer>();
		
		// List<E>가 ArrayList<E>의 상위클래스이기 때문에 이렇게 사용해도 상관없음!
		   List <Integer> list = new ArrayList<Integer>();
		   ArrayList list1 = new ArrayList();
		// List<Integer> list = new ArrayList(); -> 사용은 가능하지만 안전하지 않음.
		
/* 
     ArrayList<E>    
           저장소의 용량을 늘리려면 시간이 오래걸림. 
           데이터 삭제가 불편함
           데이터 참조가 편리함
     
     LinkedList<E>
           저장소의 용량을 늘리기가 용이함. 
           데이터 삭제가 편리함
           데이터 참조가 불편함 
 
	// LinkedList<E>는 데이터가 연속적이지 않고 노드값을 가진 데이터들이 분산되어 있기 때문에 
	// 삭제처리를 한다고 했을 때, 데이터마다 시프트를 할 필요가 없어서 처리 속도가 빠르긴 하지만!
	// 사용자가 처리한 데이터의 삭제, 처리의 작업은 주로 DB가 하기 때문에 List클래스에서는 할 필요가 없다.
	// ★ ArrayList<E>는 반복을 위해 배열에 담아놓는 역할, 데이터가 순차적이기 때문에 일괄참조에 용이하다는 이유로 많이 사용한다. 
     
*/ 		 
		// 데이터 저장 : 참조값을 저장
		// add(<T>) -> 위에서 지정한 제네릭 타입만 들어갈 수 있음.
		list.add(new Integer(11));
		list.add(new Integer(22));
		list.add(new Integer(33)); 
		list.add(55);   //Auto Boxing
		list.add(44);
		
		// List의 요소 참조
		// <T> get()
		System.out.println("list 의 첫번째 요소의 값 : "+ list.get(0));
		
		// List 요소의 개수
		// ★size()
		System.out.println("List 요소의 개수는  : "+ list.size());
		
		// 반목문을 이용한 모든 요소의 참조
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
				
		System.out.println("-------------------");
		// for - each
		for(Integer i : list) {
			System.out.println(i);
		}
		
		System.out.println("-------------------");
		// list 요소의 삭제
		// remove (index값)
		// 첫 번째 요소를 삭제 -> 뒤의 값들이 시프트 처리됨. 
		list.remove(0);
		for(int i : list) {  // int i => Integer(11) ~> *AutoBoxing
			System.out.println(i);
		}
		
		
		
		
		
		
	}

}
