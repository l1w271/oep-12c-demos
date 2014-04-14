package antony.cep.beans;

import poc.dell.DispatchEvent;


import antony.cep.coherence.AddServiceTagEntryProcessor;

import com.bea.wlevs.ede.api.EventRejectedException;
import com.bea.wlevs.ede.api.StreamSender;
import com.bea.wlevs.ede.api.StreamSink;
import com.bea.wlevs.ede.api.StreamSource;
import com.tangosol.net.NamedCache;

public class FilterNonDuplicateServiceTagsEventProcessorBean extends AbstractDispatchEventProcessorBean implements StreamSource {
	@Override
	public void onInsertDispatchEvent(DispatchEvent dispatch)
			throws EventRejectedException {
		AddServiceTagEntryProcessor processor = new AddServiceTagEntryProcessor(dispatch.getDispatchId());
		cache.invoke(dispatch.getServiceTag(), processor);
		// System.out.println(System.currentTimeMillis()+": Added Cache:"+cache.getCacheName()+" tag:"+dispatch.getServiceTag()+" dispatchId:"+dispatch.getDispatchId());
		sink.sendInsertEvent(dispatch);
	}

}
