package com.lamaa.shopping.models;

import java.util.List;

public class OrderDetails {

	private String id;
	private String orderAddress;
	private String productName;
	private int quantity;
	private String brand;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public OrderDetails(String rowData) throws Exception {
		
		String[] separatedValues = rowData.split(",");

		if(separatedValues.length == 5) {
			this.id = separatedValues[0];
			this.orderAddress = separatedValues[1];
			this.productName = separatedValues[2];
			this.quantity = Integer.parseInt(separatedValues[3]);
			this.brand = separatedValues[4];			
		}else {
			throw new Exception("Expected 5 values in row");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
