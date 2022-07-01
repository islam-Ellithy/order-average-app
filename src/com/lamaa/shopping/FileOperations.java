package com.lamaa.shopping;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperations {

 	
	static public List<String> readOrdersFromFile(String filePath) {
		//read file
		File inputFile = new File(filePath);
		List<String> listOfOrders = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(inputFile);
			
			while(scanner.hasNext()) {
				String dataRow = scanner.nextLine();
				listOfOrders.add(dataRow);
			}
			
			scanner.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfOrders;
		//output in console
		//add file data in objects then list
		//calculate average of items per orders 5/4 - output 1
		//calculate most ordered brand - output 2
		//test cases to validate output in test 
		//write to files
	}
	
	
	static public void writeDataToFile(String inputFileName,List<String> rowData) {
		
	    try {  
	        FileWriter fwrite = new FileWriter(inputFileName);  
	        for(String line: rowData) {
	        	fwrite.append(line + "\n");
	        }
	        fwrite.close();   
	    } catch (IOException e) {  
	        System.out.println("Unexpected error occurred");  
	        e.printStackTrace();  
	        }  
	}

}
