package com.aia.firstspring.domain;

public class OrderItem { // Beans class  : 상품 정보를 담을 객체 
	
	private String id;    // 상품 아이디
	private int number;   // 상품 개수
	private String remark;  // 주의
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", number=" + number + ", remark=" + remark + "]";
	}
	
	
	
	
 	

}
