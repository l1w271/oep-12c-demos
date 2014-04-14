package antony.cep.beans;

import poc.dell.DispatchAlert;

import com.bea.wlevs.ede.api.EventRejectedException;
import com.bea.wlevs.ede.api.StreamSink;
import com.bea.wlevs.ede.api.StreamSource;

public class AlertSinkEventProcessorBean extends AbstractAlertEventProcessorBean {

	@Override
	public void onInsertAlertEvent(DispatchAlert alert)
			throws EventRejectedException {
		System.out.println(System.currentTimeMillis()+" Alert:"+alert.getAlertType()+" ServiceTag:"+alert.getServiceTAG()+" DispatchId:"+alert.getDispatchID());
	}

}
