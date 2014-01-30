package com.oracle.cache.store;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class LloydTest {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		String hostName = "localhost";
		int portNumber = 1527;
		String username = "shopping";
		String password = "shopping";
		String dbName = "ShoppingDemoDB";
		//String url="jdbc:oracle:thin:@"+host+":"+ip+":"+sid;
		//String url="jdbc:derby:ShoppingDemoDB;user=shopping;password=shopping";
		
		try {
			//CustomerDataCacheLoader loader = new CustomerDataCacheLoader(url, username, password);
			CustomerDerbyCacheLoader loader = new CustomerDerbyCacheLoader(username, password, dbName, hostName, portNumber);	
                        String myKey = "cdickens" ;
			loader.load(myKey);
			
			
			Collection c = new ArrayList();
                        c.add("mmitch");
                        c.add("wshake");
                        c.add("cdoyle");
                        c.add("istone");
			
			loader.loadAll(c);
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

}
