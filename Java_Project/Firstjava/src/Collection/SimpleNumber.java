package Collection;

public class SimpleNumber {

	
	int num;

	public SimpleNumber(int num) {
		super();
		this.num = num;
	}

	
	// Set 동등 비교를  위한 hashCode(), equals() 오버라이딩
	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + num;
		return num%3;  // 0 or 1 or 2
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) // 참조하고 있는 주소값 == 전달받은 참조 주소값
			return true;
		if (obj == null) 
			return false; // 비교할 대상이 없으므로
		if (getClass() != obj.getClass()) // 클래스 이름이 같아야 한다.(같은 타입이어야 한다) -> getClass() 클래스 이름 반환
			return false;
		SimpleNumber other = (SimpleNumber) obj;
		if (num != other.num)
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		//return "SimpleNumber [num=" + num + "]";
		return String.valueOf(num); // String -> int
	}


	
	
	
	
	
	
	
	
	
}
