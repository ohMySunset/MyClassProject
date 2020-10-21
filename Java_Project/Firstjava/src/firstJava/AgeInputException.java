package firstJava;

public class AgeInputException extends Exception {
            // 내가 새로 정의한 예외클래스            //자바에서 제공해주는 예외클래스
	private int age;
	
	public AgeInputException(int age) {
		super("유효하지 않은 나이가 입력되었습니다.");
		this.age = age;
	}

	@Override
	public String toString() {
		return "AgeInputException [age=" + age + ", getMessage()=" + getMessage() + "]";
	}	
	
	
}
    

	
