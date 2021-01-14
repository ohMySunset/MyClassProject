package com.aia.op.member.domain;

import java.sql.Timestamp;
import java.util.Date;

public class Member {
	
	private int idx;
	private String memberid;
	private String password;
	private String membername;
	private String memberphoto;  //DB에 저장은 Multipart 타입이 아닌 String으로 이름만 저장되는 것.
	private Timestamp regdate;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getMemberphoto() {
		return memberphoto;
	}
	public void setMemberphoto(String memberphoto) {
		this.memberphoto = memberphoto;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	// Member -> LoginInfo
	public LoginInfo toLoginInfo() {
		return new LoginInfo(memberid, membername, memberphoto);
	}
	
	public Date getToDate() {
		return new Date(this.regdate.getTime());
	}
	
	@Override
	public String toString() {
		return "Member [idx=" + idx + ", memberid=" + memberid + ", password=" + password + ", membername=" + membername
				+ ", memberphoto=" + memberphoto + ", regdate=" + regdate + "]";
	}
	
	
	

}
