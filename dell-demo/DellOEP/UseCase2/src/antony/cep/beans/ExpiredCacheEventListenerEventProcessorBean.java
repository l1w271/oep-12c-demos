package antony.cep.beans;

import java.util.Map;

import poc.dell.DispatchEvent;

import com.bea.wlevs.ede.api.StreamSender;
import com.bea.wlevs.ede.api.StreamSource;
import com.tangosol.net.NamedCache;
import com.tangosol.net.cache.CacheEvent;
import com.tangosol.util.MapEvent;
import com.tangosol.util.filter.MapEventFilter;

public class ExpiredCacheEventListenerEventProcessorBean extends AbstractCacheEventProcessorBean implements StreamSource {
	private EventListener listener;
	private MapEventFilter filter;
	
	public class EventListener implements com.tangosol.util.MapListener {

		@Override
		public void entryDeleted(MapEvent arg0) {
			// System.out.println("Deletion Event Description:"+arg0.getDescription(arg0.getId())+" Key:"+arg0.getKey());
			CacheEvent cevent = (CacheEvent)arg0;
			Object event = cevent.getOldValue();
			if (cevent.isSynthetic()) {
				if (event instanceof DispatchEvent) {
					DispatchEvent dispatch = (DispatchEvent)event;
					sink.sendInsertEvent(event);
					// System.out.println(System.currentTimeMillis()+": Expired Cache:"+cache.getCacheName()+" tag:"+dispatch.getServiceTag()+" dispatchId:"+dispatch.getDispatchId());
				}
				else {
					System.err.println("Unexpected event type "+event.getClass().getCanonicalName());
				}
			}
		}

		@Override
		public void entryInserted(MapEvent arg0) {
			// Ignore
		}

		@Override
		public void entryUpdated(MapEvent arg0) {
			// Ignore
		}
		
	}
	
	public ExpiredCacheEventListenerEventProcessorBean() {
	}

	@Override
	public void setCache(Map map) {
		super.setCache(map);
		listener = new EventListener();
		filter = new MapEventFilter(MapEventFilter.E_DELETED);
		cache.addMapListener(listener, filter, false);
	}

}
