package com.oracle.oep.event;

public class DispatchEvent {
    
    public DispatchEvent() {
        super();
    }
    
    protected String dispatchId;
    protected String serviceHours;
    protected String statusCode;
    protected String serviceLevel;
    protected String serviceTag;

    /**
     * @param dispatchId
     */
    public void setDispatchId(String dispatchId) {
        this.dispatchId = dispatchId;
    }

    public String getDispatchId() {
        return dispatchId;
    }
    public void setServiceHours(String serviceHours) {
        this.serviceHours = serviceHours;
    }

    public String getServiceHours() {
        return serviceHours;
    }
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }
    public void setServiceLevel(String serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public String getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceTag(String serviceTag) {
        this.serviceTag = serviceTag;
    }

    public String getServiceTag() {
        return serviceTag;
    }


    @Override
    public String toString() {
        
        return "DispatchEvent [dispatchId=" + dispatchId 
                            + ", statusCode=" + statusCode 
                            + ", serviceHours=" + serviceHours 
                            + ", serviceLevel=" + serviceLevel
                            + ", serviceTag=" + serviceTag 
                            +  "]";
        
    }

    


}
