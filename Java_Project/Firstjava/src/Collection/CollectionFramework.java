package Collection;

public class CollectionFramework {

	public static void main(String[] args) {
		/*
		 <컬렉션 프레임워크>
		 
		  클래스를 표준화, 정형화한 설계
		  다수의 데이터를 쉽게 처리할 수 있는 방법을 제공
		  
		  컬렉션 클래스 -> 다수의 데이터를 저장할 수 있는 클래스
		  
		  컬렉션 -> 인스턴스를 저장하는 것이 목적
		 
		 자료구조 : 저장방식에 따라 분류
		                 배열, 리스트, 스택, 큐, 트리, 해시 등.
		 알고리즘 : 정렬, 탐색, 최대, 최소 등.
		  
		 
		- List<E> : 인터페이스 구현 클래스의 인스턴스 저장 특징을 가진 제네릭 타입 
		 -> *ArrayList<E>  LinkedList<E>
		  배열형식의 저장, 중복저장을 허용, 인스턴스의 저장 순서 有  -> 반복문이 가능
                   사용하는 메서드 :  add(), get(index), remove()
  
  
        - Set<E> : 순서를 유지하지 않는 데이터의 집합 , 중복이 불가함.                
         -> HashSet<E>  TreeSet<E>       
          HashSet<E>                     
          TreeSet<E> : 정렬이 가능! 
                  
           
        - Map : key-value 형식으로 저장하는 객체
                     인터페이스 Collection<E>를 상속하지 않음
                     순서는 유지되지 않음, 키는 중복을 허용하지 않지만 값은 중복을 허용             
          *HashMap<K, V>            
                      사용하는 메서드 : put(), get(key)
                      
		 */
				
	}

}
