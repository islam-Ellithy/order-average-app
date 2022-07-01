package com.lamaa.shopping;

import java.util.ArrayList;
import java.util.List;

import com.lamaa.shopping.models.OrderDetails;

public class ParseOrder {

	public ParseOrder() {
		// TODO Auto-generated constructor stub
	}

	public static List<OrderDetails>parseOrderFromCsv(List<String> listOfLines){
		
		List<OrderDetails> parsedOrders = new ArrayList<>();
		
		for(int i = 0 ; i < listOfLines.size();i++) {
			try {
				parsedOrders.add(new OrderDetails(listOfLines.get(i)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(parsedOrders.size());
		return parsedOrders;
	}
}
