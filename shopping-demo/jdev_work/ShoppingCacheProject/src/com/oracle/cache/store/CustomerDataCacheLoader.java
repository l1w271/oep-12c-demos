package com.oracle.cache.store;

//import java.math.BigDecimal;
//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.oracle.cache.demo.CustomerData;

//import oracle.jdbc.internal.OracleTypes;

public class CustomerDataCacheLoader extends AbstractOracleStore {

	private static final String COL_CUSTOMER_ID = "CUSTOMER_ID" ;
	private static final String COL_FIRST_NAME = "FIRST_NAME" ;
	private static final String COL_LAST_NAME = "LAST_NAME" ;
	private static final String COL_TOTAL_PURCHASES = "TOTAL_PURCHASES" ;
	private static final String COL_LOYALTY_STATUS = "LOYALTY_STATUS" ;
	
	private static final String VIEW_NAME = "CUSTOMER" ;

	private static final String SQL_SELECT = "SELECT " 
	+ "b." + COL_CUSTOMER_ID + ","
	+ "b." + COL_FIRST_NAME + ","
	+ "b." + COL_LAST_NAME + ","
	+ "b." + COL_TOTAL_PURCHASES + ","
	+ "b." + COL_LOYALTY_STATUS 
	+
	" FROM " +
	VIEW_NAME + " b " ;
   //SELECT b.* FROM prospects b WHERE ID IN (10000,10001,10002);
	
	private static final String SQL_FETCH_ALL = SQL_SELECT ;
	private static final String SQL_FETCH_SOME = SQL_FETCH_ALL + "WHERE CUSTOMER_ID IN (%s)" ;
	
	    public CustomerDataCacheLoader(String sUrl, String sUsername, String sPassword) throws SQLException
		{
	    	super(sUrl, sUsername, sPassword);
		}

	    // ----- CacheLoader interface -------------------------------------------

	    @SuppressWarnings({ "unchecked", "rawtypes" })
	    public Object load(Object oKey)
	    {
	    	Collection collection = new ArrayList(1);
	    	collection.add(oKey);
	    	Map map = this.loadAll(collection);
	    	Set entries = map.entrySet();
	    	Iterator iter = entries.iterator();
	    	while (iter.hasNext())
	    	{
	    		return ((Entry)iter.next()).getValue();
	    	}
	    	
	    	return null;
	    }
	    
		/**
		* {@inheritDoc}
		*/
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Map loadAll(Collection colKeys)
		{
			//Map mapResults = new HashMap(colKeys.size());
			//FIX TO FETCH ONLY ROWS FROM THE KEYS
			Map mapResults = new HashMap();
			Connection connection = null;
			//Statement statement = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
		
			Set<String> ids = new HashSet<String>() ;
			
			Iterator itr = colKeys.iterator();

			while (itr.hasNext()) {
				
				Object element = itr.next();
				String key ;
				if (element instanceof String){
					key = (String)element;
					ids.add(key);
				} else {
					ids.add((String) itr.next());
				}
				
				
				
				
			}
			
			
			try
		    {
				connection = getConnection();			
				String sql = String.format(SQL_FETCH_SOME, preparePlaceHolders(ids.size()));
				System.out.println(sql);
				
				ps = connection.prepareStatement(sql);
				setValues(ps, ids.toArray());
				rs = ps.executeQuery();

				while(rs.next()) {
					
					String customerID = rs.getString(COL_CUSTOMER_ID);				
					String firstName = rs.getString(COL_FIRST_NAME);
					String lastName = rs.getString(COL_LAST_NAME);
					float totalPurchases = rs.getFloat(COL_TOTAL_PURCHASES);
					int loyaltyStatus = rs.getInt(COL_LOYALTY_STATUS);

					// set values on the new event
					CustomerData event = new CustomerData();
					event.setCustomerID(customerID);
					event.setFirstName(firstName);
					event.setLastName(lastName);
					event.setTotalPurchases(totalPurchases);
					event.setLoyaltyStatus(loyaltyStatus);
					
					mapResults.put( customerID, event );
					//System.out.println("RESULT: " + event.toString());
		    	}
				
				return mapResults;
		    }
			catch (SQLException e)
			{
				log(e);
				throw new RuntimeException(e);
			}
			finally
			{
				if (ps != null)
				{
					try { ps.close(); } catch (SQLException e) {}
				}
				if (connection != null)
				{
					try { connection.close(); } catch (SQLException e) {}
				}
			}
		}
		
		
		public static String preparePlaceHolders(int length) {
		    StringBuilder builder = new StringBuilder(length * 2 - 1);
		    for (int i = 0; i < length; i++) {
		        if (i > 0) builder.append(',');
		        builder.append('?');
		    }
		    return builder.toString();
		}

		public static void setValues(PreparedStatement preparedStatement, Object... values) throws SQLException {
		    for (int i = 0; i < values.length; i++) {
		        preparedStatement.setObject(i + 1, values[i]);
		    }
		}

	}
