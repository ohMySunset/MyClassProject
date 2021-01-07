package com.aia.firstspring.domain;

import java.util.List;

public class OrderCommand {  // Beans class : 자동으로 바인딩 할 수 있는 빈즈 (폼과 변수이름 맞춰줌!)
	                         //                (상품 정보 + 배송지 정보)
	private List<OrderItem> orderItems;
	private Address address;

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "OrderCommand [orderItems=" + orderItems + ", address=" + address + "]";
	}

	

}
