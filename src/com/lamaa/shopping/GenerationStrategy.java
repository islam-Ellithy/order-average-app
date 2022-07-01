package com.lamaa.shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import com.lamaa.shopping.models.OrderDetails;
import com.lamaa.shopping.results.GenerateResults;

public class GenerationStrategy {
	
	private String filePath ;
	List<String> listOfOrders;
	List<OrderDetails> parseOrders;
	public GenerationStrategy(String filePath) {
		// TODO Auto-generated constructor stub
		this.filePath = filePath;
	}

	
	public void runProgram() {
		
		listOfOrders = FileOperations.readOrdersFromFile(filePath);
		
		parseOrders = ParseOrder.parseOrderFromCsv(listOfOrders);

		this.firstOutputGeneration();
		
		this.secondOutputGeneration();
	}
	
	public void firstOutputGeneration() {
				
		List<String> firstResult = GenerateResults.GenerateResultOne(parseOrders);		

		FileOperations.writeDataToFile("0_"+filePath, firstResult);
				
	}
	
	
	public void secondOutputGeneration() {		
		
		List<String> secondResult = GenerateResults.GenerateResultTwo(parseOrders);

		FileOperations.writeDataToFile("1_" + filePath, secondResult);
				
	}
	
}
