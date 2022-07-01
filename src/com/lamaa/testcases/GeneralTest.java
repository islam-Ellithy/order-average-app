package com.lamaa.testcases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.lamaa.shopping.ParseOrder;
import com.lamaa.shopping.models.OrderDetails;
import com.lamaa.shopping.results.GenerateResults;
import com.lamaa.shopping.FileOperations;

class GeneralTest {

	List<String> listOfOrders;
	String filePath = "input.csv";
	int length = 2;
	int lengthOfOrders = 5;

	@Test
	void testReadOrdersFromFile() {
		listOfOrders = FileOperations.readOrdersFromFile(filePath);
		assertEquals(lengthOfOrders, listOfOrders.size());
	}

	@Test
	void parseLengthOfOrdersFromCSV() {
		listOfOrders = FileOperations.readOrdersFromFile(filePath);
		List<OrderDetails> parseOrders = ParseOrder.parseOrderFromCsv(listOfOrders);
		assertEquals(lengthOfOrders, parseOrders.size());
	}

	@Test
	void checkOrderAfterParse() {
		listOfOrders = FileOperations.readOrdersFromFile(filePath);
		List<OrderDetails> parseOrders = ParseOrder.parseOrderFromCsv(listOfOrders);
		OrderDetails order = parseOrders.get(0);

//		assertEquals("ID1", order.getId());
//		assertEquals("Minneapolis", order.getOrderAddress());
//		assertEquals("shoes", order.getProductName());
//		assertEquals(length, order.getQuantity());
//		assertEquals("Air", order.getBrand());

	}

	@Test
	void generateFirstResult() {

		listOfOrders = FileOperations.readOrdersFromFile(filePath);

		List<OrderDetails> parseOrders = ParseOrder.parseOrderFromCsv(listOfOrders);

		List<String> uniqueProductNames = GenerateResults.getUniqueProductNames(parseOrders);

		assertEquals(length, uniqueProductNames.size());

		Map<String, Integer> productsMap = GenerateResults.countProducts(parseOrders);

//		assertEquals(8, productsMap.get("shoes"));

		List<String> firstResult = GenerateResults.GenerateResultOne(parseOrders);

		assertEquals(length, firstResult.size());

		FileOperations.writeDataToFile("0_" + filePath, firstResult);

		System.out.println(firstResult);

	}

	@Test
	void generateSecondResult() {

		listOfOrders = FileOperations.readOrdersFromFile(filePath);

		List<OrderDetails> parseOrders = ParseOrder.parseOrderFromCsv(listOfOrders);

		List<String> uniqueProductNames = GenerateResults.getUniqueProductNames(parseOrders);

		assertEquals(length, uniqueProductNames.size());

		List<String> secondResult = GenerateResults.GenerateResultTwo(parseOrders);

		assertEquals(length, secondResult.size());

		FileOperations.writeDataToFile("1_" + filePath, secondResult);

	}

}
