package com.oracle.nosql.loader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.oracle.mobile.marketing.data.CustomerData;

public class FileReader {


    @SuppressWarnings("oracle.jdeveloper.java.nested-assignment")
    public ArrayList<CustomerData> readCustomerFile() {
	
    	ArrayList<CustomerData> list = new ArrayList<CustomerData>();
    	
    	String strLine ;
        String fileName;
        fileName = "/Users/Lloyd/Work/Demos/MobileMarketing/Customer.txt";
        BufferedReader br ;
		
		// Open the file
		FileInputStream fstream;
		try {
			fstream = new FileInputStream(fileName);
			br = new BufferedReader(new InputStreamReader(fstream));
			
			//Read File Line By Line
			try {
				while ((strLine = br.readLine()) != null)   {
				  // Print the content on the console
				  System.out.println (strLine);
				  CustomerData d = createEvent(strLine);
				  if (d != null){
                                    list.add(d); 
				  }
				  
				}
			} catch (IOException e) {
				System.out.println("Error Reading Line! ");
				e.printStackTrace();
			}
			

			//Close the input stream
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("Error Closing Input Stream!");
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND: " + fileName);
			e.printStackTrace();
		}
		
		return list ;
	
    }
	
    private CustomerData createEvent(String line){
    	
    	CustomerData d = null ;
    	
		if (line != null){					
		    		
			List<String> items = Arrays.asList(line.split(","));
			
			String deviceID = items.get(0);
			String customerName = items.get(1);
			String customerEmail = items.get(2);
			
			d = new CustomerData();
			d.setDeviceID(deviceID);
			d.setCustomerName(customerName);
			d.setCustomerEmail(customerEmail);
		}

		return d;
    	
    }
    
    
}
