package com.oracle.oep.listener;

//import com.bea.wlevs.ede.api.StreamSender;
//import com.bea.wlevs.ede.api.StreamSource;
import com.tangosol.util.MapEvent;
import com.tangosol.util.MapListener;

/**
 * This class implements the cache listener 
 * 
 */
public class CacheListener implements MapListener {

/*
	StreamSource {

	private StreamSender streamSender_;
	
	@Override
	public void setEventSender(StreamSender sender) {
		streamSender_ = sender ;
		
*/	
	
	/**
	 * Spring uses this constructor to create the bean.
	 */
	public CacheListener() {
	}

	public void entryDeleted(MapEvent event) {		
		System.out.println("entryDeleted: " + event.getOldValue());		
	}

	public void entryInserted(MapEvent event) {
		System.out.println("entryInserted: " + event.getNewValue());	
			
	}

	public void entryUpdated(MapEvent event) {
		System.out.println("entryUpdated: OLD: " + event.getOldValue() + " NEW: " + event.getNewValue());
	}
	
}
