package com.aia.open.domain;

public class LoginInfo { // 로그인 정보를 받을 빈즈 객체
	
	private String memberid;
	private String password;
	private String chk;
	
	
	public String getChk() {
		return chk;
	}
	public void setChk(String chk) {
		this.chk = chk;
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
	@Override
	public String toString() {
		return "LoginInfo [memberid=" + memberid + ", password=" + password + ", chk=" + chk + "]";
	}

	

	
	
	

}
