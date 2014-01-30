package com.oracle.cache.store;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

import com.tangosol.net.cache.AbstractCacheStore;
import com.tangosol.util.SafeHashMap;

public abstract class AbstractOracleStore extends AbstractCacheStore
{
	// ----- constructors ----------------------------------------------------

	protected AbstractOracleStore(String sUrl, String sUsername, String sPassword)
        throws SQLException
    {
	    String sKey = sUrl + sUsername + sPassword;
	    OracleDataSource ds = (OracleDataSource) s_mapDataSources.get(sKey);
	    if (ds == null)
	        {
	        ds = new OracleDataSource();
	        ds.setUser(sUsername);
	        ds.setPassword(sPassword);
	        ds.setURL(sUrl);
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
