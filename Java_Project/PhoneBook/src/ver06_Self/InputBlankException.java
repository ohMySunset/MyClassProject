package ver06_Self;

public class InputBlankException extends Exception{

	private static final long serialVersionUID = 1L;

    public InputBlankException() {
    	
    }
	public InputBlankException(String e) {
		super(e);
	}



public void exception(String select) throws InputBlankException {	
		throw new InputBlankException("메뉴의 선택이 올바르지 않습니다.\n"+ "다시 선택해주세요.");
	
}

}