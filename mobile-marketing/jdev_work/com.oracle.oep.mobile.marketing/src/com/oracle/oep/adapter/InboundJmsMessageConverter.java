package com.oracle.oep.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bea.wlevs.adapters.jms.api.InboundMessageConverter;
import com.bea.wlevs.adapters.jms.api.MessageConverterException;

import com.oracle.oep.event.DeviceEvent;

public class InboundJmsMessageConverter implements InboundMessageConverter {

	Log log_ = LogFactory.getLog(InboundJmsMessageConverter.class);
		
	@SuppressWarnings("rawtypes")
	public List convert(Message message) throws MessageConverterException {
		
		if (log_.isDebugEnabled()){
			log_.debug("convert(): RECEIVED MESSAGE!");
		}
				
		List result = null;
		if (message instanceof TextMessage) {
			result = handleMessage((TextMessage) message);
		} else {
			log_.warn("onMessage():skipping unexpected message type:" + message.toString());
			result = Collections.EMPTY_LIST;
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	private List handleMessage(TextMessage message) throws MessageConverterException {
		
		List<Object> result = new ArrayList<Object>();
		try {
			if (message != null){					
				String msg = message.getText();
				//System.out.println("msg: " + msg);
			    
				DeviceEvent event = new DeviceEvent();		
				List<String> items = Arrays.asList(msg.split(","));
				
				String deviceID = items.get(0);
				double latitude = Double.valueOf(items.get(1));
				double longitude = Double.valueOf(items.get(2));
						
				event.setDeviceID(deviceID);
				event.setLatitude(latitude);
				event.setLongitude(longitude);
				
				result.add(event);		
			}
			
			return result;
			
		} catch(JMSException jmse) {
			throw new MessageConverterException("Error getting JMS message",jmse);
		} catch (Exception ex) {
			//throw new MessageConverterException("Error converting message content.",ex);
			log_.warn("InboundJmsMessageConvert.handleMessage(): unexpected message content!");
			return result ;
		}
		
		
	}


}
