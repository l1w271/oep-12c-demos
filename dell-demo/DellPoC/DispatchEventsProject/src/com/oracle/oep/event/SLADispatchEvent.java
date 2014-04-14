package com.oracle.oep.event;

public class SLADispatchEvent extends DispatchEvent {
    
    public SLADispatchEvent() {
        super();
    }
    
    private int slaEnd ;


    public void setSlaEnd(int slaEnd) {
        this.slaEnd = slaEnd;
    }

    public int getSlaEnd() {
        return slaEnd;
    }
    
    @Override
    public String toString() {
        
        return "SLADispatchEvent [dispatchId=" + dispatchId 
                            + ", statusCode=" + statusCode 
                            + ", serviceHours=" + serviceHours 
                            + ", serviceLevel=" + serviceLevel
                            + ", serviceTag=" + serviceTag 
                            + ", slaEnd=" + slaEnd 
                            +  "]";
        
    }



}
