package antony.cep.beans;

import poc.dell.DispatchAlert;
import com.bea.wlevs.ede.api.EventRejectedException;
import com.bea.wlevs.ede.api.StreamSink;
import com.bea.wlevs.ede.api.StreamSource;

public abstract class AbstractAlertEventProcessorBean extends AbstractCacheEventProcessorBean implements StreamSink {
	
	@Override
	public void onInsertEvent(Object event) throws EventRejectedException {
		if (event instanceof DispatchAlert) {
			DispatchAlert alert = (DispatchAlert) event;
			onInsertAlertEvent(alert);
		}
		else {
			System.err.println("Unexpected event type "+event.getClass().getCanonicalName());
			// Default behavior is always to forward event
			if (sink != null)
				sink.sendInsertEvent(event);
		}
	}
	
	abstract public void onInsertAlertEvent(DispatchAlert alert) throws EventRejectedException;

}
