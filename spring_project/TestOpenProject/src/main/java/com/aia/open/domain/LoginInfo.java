package com.aia.open.domain;

public class LoginInfo { // 로그인 정보를 받을 빈즈 객체
	
	private String userId;
	private String userPw;
	private String chk;
	

	public String getChk() {
		return chk;
	}
	public void setChk(String chk) {
		this.chk = chk;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	@Override
	public String toString() {
		return "LoginInfo [userId=" + userId + ", userPw=" + userPw + ", chk=" + chk + "]";
	}

	
	

}
