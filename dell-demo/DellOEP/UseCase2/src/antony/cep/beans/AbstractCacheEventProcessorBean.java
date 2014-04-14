package antony.cep.beans;

import java.util.Map;

import com.bea.wlevs.ede.api.StreamSender;
import com.bea.wlevs.ede.api.StreamSink;
import com.bea.wlevs.ede.api.StreamSource;
import com.tangosol.net.NamedCache;

public abstract class AbstractCacheEventProcessorBean {

	protected StreamSender sink;
	protected NamedCache cache = null;

	public AbstractCacheEventProcessorBean() {
		super();
	}

	public void setEventSender(StreamSender sender) {
		sink = sender;
	}

	public final Map getCache() {
		return cache;
	}

	public void setCache(Map cache) {
		this.cache = (NamedCache)cache;
	}

}