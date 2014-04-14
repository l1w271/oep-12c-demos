package com.oracle.oep.listener;

import com.bea.wlevs.ede.api.EventRejectedException;
import com.bea.wlevs.ede.api.RelationSink;
import com.bea.wlevs.ede.api.StreamSink;

public class OutputBean implements RelationSink, StreamSink  {

	public void onInsertEvent(Object event) throws EventRejectedException {
		System.out.println("[+] " + event.toString());				
	}
	
	public void onUpdateEvent(Object event) throws EventRejectedException {
		System.out.println("[^] " + event.toString());	
	}
	
	public void onDeleteEvent(Object event) throws EventRejectedException {
		System.out.println("[-] " + event.toString());	 
	}
	 
}
