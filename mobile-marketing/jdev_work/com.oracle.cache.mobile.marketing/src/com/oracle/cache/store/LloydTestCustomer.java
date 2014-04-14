package com.oracle.cache.store;

import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Collection;

public class LloydTestCustomer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String host = "localhost";
		String ip = "1521";
		String username = "hol";
		String password = "hol";
		String sid = "demo";
		String url="jdbc:oracle:thin:@"+host+":"+ip+":"+sid;
		
		
		try {
			CustomerDataCacheLoader loader = new CustomerDataCacheLoader(url, username, password);
			String myKey = "2185551000" ;
			loader.load(myKey);		
			
			
			//Collection c = new ArrayList();
            //c.add(1);
            //c.add(2);
            //c.add(3);
            //c.add(4);
            
			
			//loader.loadAll(null);
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
