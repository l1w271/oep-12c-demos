package antony.cep.beans;

import poc.dell.DispatchAlert;
import poc.dell.DispatchEvent;

import antony.cep.util.DispatchDataMessageHelper;

import com.bea.wlevs.ede.api.EventRejectedException;
import com.bea.wlevs.ede.api.StreamSender;
import com.bea.wlevs.ede.api.StreamSink;
import com.bea.wlevs.ede.api.StreamSource;

import dsp.dell_services.DispatchDataMessage;

public class CorticonCallEventProcessorBean extends AbstractAlertEventProcessorBean implements StreamSource {

	@Override
	public void onInsertAlertEvent(DispatchAlert alert) throws EventRejectedException {
			// Call Corticon Web Service
			if (alert.getServiceTAG().endsWith("T")) {
				// Call Corticon and if true answer then emit event
				sink.sendInsertEvent(alert);
			}
	}
}
