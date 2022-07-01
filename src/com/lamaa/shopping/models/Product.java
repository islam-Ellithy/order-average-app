package com.lamaa.shopping.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {

	String productName;
	ArrayList<String> brands;
	String mostPopularBrand;
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ArrayList<String> getBrands() {
		return brands;
	}

	public void setBrands(ArrayList<String> brands) {
		this.brands = brands;
	}
	
	public void setBrandsByOrders(List<OrderDetails> listOfOrders) {
		
		for(OrderDetails order : listOfOrders) {
			if(order.getProductName().equals(productName)) {
				this.addBrand(order.getBrand());
			}
		}

	}
	
	

	public String getMostPopularBrand() {
		return mostPopularBrand;
	}

	public void setMostPopularBrand(String mostPopularBrand) {
		this.mostPopularBrand = mostPopularBrand;
	}

	public void addBrand(String brand) {
		this.brands.add(brand);
	}

	public Product() {
		brands = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	

	public Product(String productName) {
		brands = new ArrayList<>();
		this.productName = productName;
	}

	public String getMostPopularBrand(Map<String,Integer> brandsMap) {
		//Order - Brand
 		int maxBrand = 0;
		for(String brand : brands) {
			int temp = brandsMap.get(brand);
			if(temp > maxBrand) {
				maxBrand = temp;
				mostPopularBrand = brand;
			}
		}
		return mostPopularBrand;
	}
	
	
	@Override
	public String toString() {
		return this.productName + "," + this.mostPopularBrand + "\n";
	}

}
