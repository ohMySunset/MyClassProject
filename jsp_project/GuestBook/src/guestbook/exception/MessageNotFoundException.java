package guestbook.exception;

public class MessageNotFoundException extends Exception {

	public MessageNotFoundException() {
		super("게시물을 찾을 수가 없습니다.");
	}

}