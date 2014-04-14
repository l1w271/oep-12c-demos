package antony.cep.beans;

import poc.dell.DispatchEvent;

import com.bea.wlevs.ede.api.EventRejectedException;
import com.bea.wlevs.ede.api.StreamSink;
import com.bea.wlevs.ede.api.StreamSource;

public abstract class AbstractDispatchEventProcessorBean extends AbstractCacheEventProcessorBean implements StreamSink {
	
	@Override
	public void onInsertEvent(Object event) throws EventRejectedException {
		if (event instanceof DispatchEvent) {
			DispatchEvent dispatch = (DispatchEvent) event;
			onInsertDispatchEvent(dispatch);
		}
		else {
			System.err.println("Unexpected event type "+event.getClass().getCanonicalName());
			// Default behavior is always to forward event
			if (sink != null)
				sink.sendInsertEvent(event);
		}
	}
	
	abstract public void onInsertDispatchEvent(DispatchEvent dispatch) throws EventRejectedException;

}
