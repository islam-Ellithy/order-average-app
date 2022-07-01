package com.lamaa.shopping;

import java.io.File;
import java.io.IOException;

public class MainDriver {

	public static void main(String[] args) {

        try {  
        	
        	if(args.length > 0) {
        		
            	String filePath = args[0];
            	
            	GenerationStrategy strategy = new GenerationStrategy(filePath);  
            	
            	strategy.runProgram();
            	
        	}else {
        		
        		System.out.println("Please enter file name");
        		
        	}

        } catch (Exception e) {  
            e.printStackTrace();  
        }  

		
	}

}
