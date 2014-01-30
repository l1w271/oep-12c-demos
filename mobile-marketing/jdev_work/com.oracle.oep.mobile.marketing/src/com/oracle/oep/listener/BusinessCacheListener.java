package com.oracle.oep.listener;

//import oracle.spatial.geometry.JGeometry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bea.wlevs.ede.api.EventBean;
import com.bea.wlevs.ede.api.RelationSource;
import com.bea.wlevs.ede.api.StreamSender;
import com.oracle.cache.demo.BusinessData;
import com.oracle.cep.cartridge.spatial.Geometry;
import com.oracle.oep.event.BusinessLocation;
import com.tangosol.util.MapEvent;
import com.tangosol.util.MapListener;

/**
 * This class implements the cache listener 
 * 
 */
public class BusinessCacheListener implements EventBean, MapListener, RelationSource {
		
	/**
	 * Spring uses this constructor to create the bean.
	 */
	public BusinessCacheListener() {
	}
	
	Log log_ = LogFactory.getLog(this.getClass());

	private StreamSender sender_;

	@Override
	public void setEventSender(StreamSender sender) {
		sender_ = sender;
	}
	
	
	public void entryDeleted(MapEvent event) {		
		System.out.println("BusinessCacheListener: entryDeleted: " + event.getOldValue());		
	}

	public void entryInserted(MapEvent event) {
		System.out.println("BusinessCacheListener: entryInserted: " + event.getNewValue());	
			
		BusinessData business = (BusinessData)event.getNewValue();
		sendLocation(business);
			
	}

	public void entryUpdated(MapEvent event) {
		System.out.println("BusinessCacheListener: entryUpdated: OLD: " + event.getOldValue() + " NEW: " + event.getNewValue());
		
		BusinessData business = (BusinessData)event.getNewValue();
		sendLocation(business);		
	}
	
	
	public void sendLocation(BusinessData bus){
		
		BusinessLocation loc = new BusinessLocation();
		loc.setBusinessID(bus.getBusinessID());
		loc.setBusinessName(bus.getBusinessName());
		loc.setIndustryID(bus.getIndustryID());
		loc.setLatitude(bus.getLatitude());
		loc.setLongitude(bus.getLongitude());
		Geometry geom = Geometry.createPoint(8307, bus.getLongitude(), bus.getLatitude());		
		loc.setGeom(geom);

		sender_.sendInsertEvent(loc);
		
	}

	
}
