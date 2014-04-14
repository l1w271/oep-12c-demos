package antony.cep.beans;

import java.util.Map;

import poc.dell.DispatchEvent;


import com.bea.wlevs.cache.spi.coherence.CoherenceCachingSystem;
import com.bea.wlevs.ede.api.EventRejectedException;
import com.bea.wlevs.ede.api.StreamSink;
import com.tangosol.net.NamedCache;

public class AddToCacheWithDelayEventProcessorBean extends AbstractDispatchEventProcessorBean {
	private static final long TwoDayExpiry = 48;
	private static final long HolidayLength = 24;
	private static final long DelayScaleFactor = 1000;
	private static final String HolidayFlag = "Holiday";

	@Override
	public void onInsertDispatchEvent(DispatchEvent dispatch) throws EventRejectedException {
		// Call Holiday Service
		long delay = TwoDayExpiry;
		if (dispatch.getServiceHours().equalsIgnoreCase(HolidayFlag)) {
			delay += HolidayLength;
		}
		cache.put(dispatch.getDispatchId(), dispatch, delay*DelayScaleFactor);
		// System.out.println(System.currentTimeMillis()+" Added Cache:"+cache.getCacheName()+" tag:"+dispatch.getServiceTag()+" dispatchId:"+dispatch.getDispatchId()+" Expiry:"+delay*DelayScaleFactor);
	}
}
