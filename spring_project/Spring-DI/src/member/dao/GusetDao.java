package member.dao;

public class GusetDao implements Dao {

	@Override
	public void insert() {
	  System.out.println("방명록 정보를 데이터 베이스에 저장합니다.");

	}

	@Override
	public void select() {
	  System.out.println("방명록 정보를 검색합니다.");
		 
	}

	@Override
	public void delete() {
	  System.out.println("방명록 정보를 삭제합니다.");
	}

	@Override
	public void update() {
	  System.out.println("방명록 정보를 수정합니다.");
	}

}
