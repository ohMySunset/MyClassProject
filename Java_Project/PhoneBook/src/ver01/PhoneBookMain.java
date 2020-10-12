package ver01;

public class PhoneBookMain {

	public static void main(String[] args) {

	PhoneInfo info1 = new PhoneInfo("손흥민", "010-0000-0000", "1990.12.10");
	info1.showInfo(); //참조변수 info1이 가르키는 PhoneInfo 타입 객체의 메서드 호출
	
    PhoneInfo info2 = new PhoneInfo("박지성","010-1111-1111");
	info2.showInfo();	
		
	}

}
