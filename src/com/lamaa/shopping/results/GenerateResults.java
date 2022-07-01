package com.lamaa.shopping.results;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.lamaa.shopping.models.OrderDetails;
import com.lamaa.shopping.models.Product;

public class GenerateResults {

	List<OrderDetails> listOfOrders;

	public List<OrderDetails> getListOfOrders() {
		return listOfOrders;
	}

	public void setListOfOrders(List<OrderDetails> listOfOrders) {
		this.listOfOrders = listOfOrders;
	}

	public GenerateResults(List<OrderDetails> newListOfOrders) {
		listOfOrders = newListOfOrders;
	}

	public static List<String> GenerateResultOne(List<OrderDetails> listOfOrders) {
		List<String> results = new ArrayList<>();

		int totalOrders = listOfOrders.size();

		List<String> uniqueProductNames = getUniqueProductNames(listOfOrders);
		
		Map<String,Integer> productsMap = countProducts(listOfOrders);
		
		for(Entry<String,Integer> entry: productsMap.entrySet()) {
		
			String row = entry.getKey() + "," + ((float)entry.getValue()/totalOrders);
			
			results.add(row);
		
		}
		
		
		return results;
	}

	public static Map<String,Integer> countProducts(List<OrderDetails> listOfOrders) {
		Map<String,Integer> productsMap = new HashMap<>();

		for (OrderDetails row : listOfOrders) {
			
			String key = row.getProductName();
						
			if(productsMap.containsKey(key)){
			
				productsMap.put(key, (int) (productsMap.get(key)+row.getQuantity()));
			
			}else {
			
				productsMap.putIfAbsent(key, (int) row.getQuantity());

			}
		}

		return productsMap;
	}

	public static List<String> getUniqueProductNames(List<OrderDetails> listOfOrders) {
		List<String> uniqueProducts = new ArrayList<>();

		//loop to get unique product names
		listOfOrders.forEach((order) -> {
			if(!uniqueProducts.contains(order.getProductName())) {
				uniqueProducts.add(order.getProductName());
			}
		});
		
		return uniqueProducts;
	}

	public static List<String> GenerateResultTwo(List<OrderDetails> listOfOrders) {
		
		List<String> lines = new ArrayList<>();

		List<Product> products = new ArrayList<>();

		List<String> uniqueProductNames = getUniqueProductNames(listOfOrders);
		
		Map<String,Integer> brandsMap = GenerateResults.countBrands(listOfOrders);

		for(String productName : uniqueProductNames) {
			
			Product product = new Product(productName);
			
			product.setBrandsByOrders(listOfOrders);
			
			product.getMostPopularBrand(brandsMap);
			
			products.add(product);
			
			lines.add(product.toString());
		}
		
		return lines;
	}

	public static Map<String, Integer> countBrands(List<OrderDetails> parseOrders) {
		
		Map<String,Integer> brandMaps = new HashMap<>();

		for (OrderDetails row : parseOrders) {
			
			String key = row.getBrand();
						
			if(brandMaps.containsKey(key)){
			
				brandMaps.put(key,(brandMaps.get(key)+1));
			
			}else {
			
				brandMaps.putIfAbsent(key, 1);

			}
		}

		return brandMaps;
	}

}
