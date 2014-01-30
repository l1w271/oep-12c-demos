/* (c) 2006-2013 Oracle.  All rights reserved. */
package com.oracle.oep.adapter;

import java.util.Map;

import com.tangosol.net.cache.CacheLoader;
import java.util.Collection;

import com.oracle.cache.store.BusinessDataCacheLoader;
import com.bea.wlevs.ede.api.InitializingBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BusinessCacheLoadAdapter implements InitializingBean, CacheLoader {

	public BusinessDataCacheLoader loader ;
	
	public String url ;
	public String username ;
	public String password ;
	
	
	Log log_ = LogFactory.getLog(BusinessDataCacheLoader.class);
	
	@SuppressWarnings("rawtypes")
	private Map businessCache;
	
    @SuppressWarnings("rawtypes")
	public void setBusinessCache(Map businessCache) {
		this.businessCache = businessCache;
	}

	public BusinessCacheLoadAdapter() {
        super();

    }

 	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
 		if(log_.isInfoEnabled()) {
			log_.info("Loading caches ...");
		}
 		
 		loader.setDS(url, username, password);
 		businessCache.putAll(loader.loadAll(null));
 		
 		if(log_.isInfoEnabled()) {
			log_.info("Loading caches complete!");
		}
 		
	}

	public void setLoader(BusinessDataCacheLoader loader) {
		this.loader = loader;
	}

	@Override
	public Object load(Object arg0) {
		return loader.load(arg0);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map loadAll(Collection arg0) {
		
 		return loader.loadAll(arg0);
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
 	
	
	
 	
 	
 	
}
