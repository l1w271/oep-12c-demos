package com.oracle.oep.listener;

import com.bea.wlevs.ede.api.EventRejectedException;
import com.bea.wlevs.ede.api.RelationSink;
import com.bea.wlevs.ede.api.StreamSink;

import java.util.Calendar;

public class OutputBean implements RelationSink, StreamSink  {

	public void onInsertEvent(Object event) throws EventRejectedException {
		System.out.println("[+] " + formatOutput(event));				
	}
	
	public void onUpdateEvent(Object event) throws EventRejectedException {
		System.out.println("[^] " + formatOutput(event));	
	}
	
	public void onDeleteEvent(Object event) throws EventRejectedException {
		System.out.println("[-] " + formatOutput(event));	 
	}
        
    public String formatOutput(Object event){
        String dateString = Calendar.getInstance().getTime().toString();
        String output = "[ " + dateString + " ] " + event.toString(); 
        return output ;
    }
	 
}
