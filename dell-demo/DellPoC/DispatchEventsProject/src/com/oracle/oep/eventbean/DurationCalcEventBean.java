package com.oracle.oep.eventbean;

import com.bea.wlevs.ede.api.EventBean;
import com.bea.wlevs.ede.api.InitializingBean;
import com.bea.wlevs.ede.api.EventRejectedException;
import com.bea.wlevs.ede.api.StreamSender;
import com.bea.wlevs.ede.api.StreamSink;
import com.bea.wlevs.ede.api.StreamSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oracle.oep.util.SimpleCalendar;
import com.oracle.oep.event.DispatchEvent ;
import com.oracle.oep.event.SLADispatchEvent ;

import java.util.Calendar;

public class DurationCalcEventBean implements EventBean, StreamSource, StreamSink, InitializingBean {
    
    public DurationCalcEventBean() {
        super();
    }

            
    Log log_ = LogFactory.getLog(this.getClass());
            
    private StreamSender streamSender_;
    private SimpleCalendar sCal ;


    @Override
    public void setEventSender(StreamSender sender) {
        
        streamSender_ = sender;
    }

    @Override
    public void onInsertEvent(Object object) throws EventRejectedException {
        
        //System.out.println("DurationCalc Received an Event!");
        
        if (object instanceof DispatchEvent){
            SLADispatchEvent d = (SLADispatchEvent)object ;
            //long slaEnd = sCal.getTwoBusinessDayInterval(Calendar.getInstance().getTime());
            int slaEnd = SimpleCalendar.getRandomLowInterval(d.getDispatchId());
            
            System.out.println("[" +Calendar.getInstance().getTime().toString() + "] For dispatchId: " + d.getDispatchId() + " the interval is: " + slaEnd);
            
            d.setSlaEnd(slaEnd);
            streamSender_.sendInsertEvent(d);
        }
        
        
    }


    @Override
    public void afterPropertiesSet() throws Exception {
       //Initialize the class that will help set the duration
        //sCal = new SimpleCalendar();
        //sCal.init();
        
    }
}
