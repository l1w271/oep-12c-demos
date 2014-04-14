package antony.cep.beans;

import java.util.Map;

import poc.dell.DispatchEvent;


import com.bea.wlevs.ede.api.EventRejectedException;
import com.bea.wlevs.ede.api.StreamSink;
import com.tangosol.net.NamedCache;

public class RemoveFromCacheEventProcessorBean extends AbstractDispatchEventProcessorBean {
	@Override
	public void onInsertDispatchEvent(DispatchEvent dispatch) throws EventRejectedException {
		cache.remove(dispatch.getDispatchId());
		// System.out.println(System.currentTimeMillis()+": Removed Cache:"+cache.getCacheName()+" tag:"+dispatch.getServiceTag()+" dispatchId:"+dispatch.getDispatchId());
	}
}
