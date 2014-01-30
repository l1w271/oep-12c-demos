package com.oracle.cache.store;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;

import javax.sql.DataSource;

//import oracle.jdbc.pool.OracleDataSource;
import org.apache.derby.jdbc.ClientDataSource;

import com.tangosol.net.cache.AbstractCacheStore;
import com.tangosol.util.SafeHashMap;

public abstract class AbstractDerbyStore extends AbstractCacheStore
{
	// ----- constructors ----------------------------------------------------

	protected AbstractDerbyStore(String sUsername, String sPassword, String dbName, String serverName, int portNumber)
        throws SQLException
    {
	    
            String sKey = dbName + serverName + portNumber + sUsername + sPassword;
    	    ClientDataSource ds = (ClientDataSource) s_mapDataSources.get(sKey);
	    if (ds == null)
	        {        
	            ds = new ClientDataSource();
                    ds.setDatabaseName(dbName);
	            ds.setUser(sUsername);  
	            ds.setPassword(sPassword); 
	            ds.setServerName(serverName);
	            ds.setPortNumber(portNumber);
 
	        s_mapDataSources.put(sKey, ds);
	        }
	    m_ds = ds;
    }

	// ----- internal --------------------------------------------------------

	protected Connection getConnection()
        throws SQLException
    {
		return m_ds.getConnection();
    }

	// ----- CacheLoader interface -------------------------------------------

	/**
	* {@inheritDoc}
	*/
	public Object load(Object oKey)
    {
		return loadAll(Collections.singleton(oKey)).get(oKey);
    }

	//----- static members --------------------------------------------------

	private static SafeHashMap s_mapDataSources = new SafeHashMap();

	// ----- data members ----------------------------------------------------

	private DataSource m_ds;

}
