package com.self.testspring.domain;

import java.util.List;

public class OrderCommand { // 담겨진 상품정보와 배송지 정보를 같이 담을 빈즈 객체
	                        // 자동 바인딩 할 수 있도록 변수를 폼과 일치 시켜야함

	
	private List<OrderItem> orderitems;
	private Address address;
	
	public List<OrderItem> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(List<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "OrderCommand [orderitems=" + orderitems + ", address=" + address + "]";
	}
	
	
	
	
}
