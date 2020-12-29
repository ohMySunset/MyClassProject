package member.model;

import java.util.List;

public class MemberListView {
	
	private int memberTotalCount; // 전체 회원의 수
	private int memberCountPerPage; // 한 페이지에 몇 명을 출력
	private List<Member> memberList; // 회원정보를 담을 리스트 
	private int pageTotalCount; //총 페이지의 수
	private int firstRow; // 첫번재 행
	private int pageNumber; // 현재 페이지 
	
	
	public MemberListView(int memberTotalCount, 
			              int memberCountPerPage,
			              List<Member> memberList,
			              int firstRow,
			              int pageNumber) {
		this.memberTotalCount = memberTotalCount;
		this.memberCountPerPage = memberCountPerPage;
		this.memberList = memberList;
		this.firstRow = firstRow;
		this.pageNumber = pageNumber;
		calTotalPageCount();
	}
	
	private void calTotalPageCount() {
		
		if(memberTotalCount==0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = memberTotalCount/memberCountPerPage;
			// 삼항연산자 활용
			pageTotalCount = memberTotalCount%memberCountPerPage>0? ++pageTotalCount:pageTotalCount;
		   //*pageTotalCount = pageTotalCount++ 대입 후 증가
		}		
	}

	public int getMemberTotalCount() {
		return memberTotalCount;
	}

	public int getMemberCountPerPage() {
		return memberCountPerPage;
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	@Override
	public String toString() {
		return "MemberListView [memberTotalCount=" + memberTotalCount + ", memberCountPerPage=" + memberCountPerPage
				+ ", memberList=" + memberList + ", pageTotalCount=" + pageTotalCount + ", firstRow=" + firstRow
				+ ", pageNumber=" + pageNumber + "]";
	}
	
	
	
	

	
	
}
