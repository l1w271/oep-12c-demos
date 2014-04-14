package com.oracle.oep.adapter;

import com.bea.wlevs.ede.api.Adapter;
import com.bea.wlevs.ede.api.RunnableBean;
import com.bea.wlevs.ede.api.StreamSender;
import com.bea.wlevs.ede.api.StreamSource;

import com.oracle.oep.event.SalesEvent ;

public class SalesAdapter implements RunnableBean, StreamSource, Adapter
{
  private StreamSender        eventSender;
  private boolean             suspended;

  public void run()
  {
    suspended = false;
    generateMessage();
  }

  private void generateMessage()
  {

    SalesEvent event ;
          
    //event 1
    event = new SalesEvent();
    event.setItem("basket ball");
    event.setPrice(888845.0);
    event.setUserId("jordan");
    
    eventSender.sendInsertEvent(event);
    //System.out.println("Sent: " + event.toString());

    //event 2
    event = new SalesEvent();
    event.setItem("soccer ball");
    event.setPrice(88825.0);
    event.setUserId("ronaldo");

    eventSender.sendInsertEvent(event);      
    //System.out.println("Sent: " + event.toString());

    //event 3
    event = new SalesEvent();
    event.setItem("car");
    event.setPrice(50000.0);
    event.setUserId("senna");
    
    eventSender.sendInsertEvent(event);
    //System.out.println("Sent: " + event.toString());
  }

  public void setEventSender(StreamSender sender)
  {
    eventSender = sender;
  }

  public synchronized void suspend() throws Exception
  {
    suspended = true;
  }

  public synchronized boolean isSuspended()
  {
    return suspended;
  }
}
