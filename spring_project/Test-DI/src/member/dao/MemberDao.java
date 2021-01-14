package member.dao;

public class MemberDao implements Dao {

	@Override
	public void insert() {	
      System.out.println("회원정보를 등록합니다.");
	}

	@Override
	public void select() {
		System.out.println("회원정보를 검색합니다.");
	}

	@Override
	public void delete() {
		System.out.println("회원정보를 삭제합니다.");
	}

	@Override
	public void update() {
		System.out.println("회원정보를 수정합니다.");
	}

}