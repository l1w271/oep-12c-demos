package com.oracle.oep.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bea.wlevs.ede.api.EventRejectedException;
import com.bea.wlevs.ede.api.RelationSink;
import com.bea.wlevs.ede.api.StreamSink;

//import oracle.cep.dataStructures.external.AttributeValue;
//import oracle.cep.dataStructures.external.TupleValue;

public class EventListener implements RelationSink, StreamSink  {

	Log log_ = LogFactory.getLog(this.getClass()); 
	
	private String nodeName_ = this.getClass().getName();
	
	public void setNodeName(String nodeName) {
		nodeName_ = nodeName;
		log_=LogFactory.getLog(nodeName_);
	}

	public void onInsertEvent(Object event) throws EventRejectedException {
		//System.out.println("Got an event!" + event.toString());
		
		printEvent("[+]",event);				
		
	}
	
	public void onUpdateEvent(Object event) throws EventRejectedException {
		//printEvent("[^]",event);	
	}
	
	public void onDeleteEvent(Object event) throws EventRejectedException {
		//printEvent("[-]",event);	 
	}
	
	private void printEvent(String operation,Object event) {
		try {
			if(log_.isDebugEnabled()) {
				log_.debug(formatEvent(operation, event));
			}
		} catch(Exception e) {
			log_.error("Error formatting event:"+e.getMessage());
		}
	}
	   

	private String formatEvent(String operation,Object event) {
		
		String s = "[NODE:"+nodeName_+"]"+operation +":";
                s += event.toString();
                /*
                if(event instanceof TupleValue) {
			TupleValue t = (TupleValue) event;
			long ts = t.getTime();
			int attrs = t.getNoAttributes();
			s += "[tupleTs:"+ts+"]";
			for(int i=0;i<attrs;++i) {
				try {
					AttributeValue attribute = t.getAttribute(i);
					String attributeName = attribute.getAttributeName();
					Object attributeValue = attribute.getObjectValue();
					// suppress zero/null attribute values
					if(
							(attributeValue != null) && 
							(! attributeValue.toString().equals("0")) && 
							(! attributeValue.toString().equals("0.0")) ) 
					{
						s += "["+attributeName+":"+attributeValue+"]";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			s += event.toString();
		}
                */
                
		return s;
	}

}
