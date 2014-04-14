package com.oracle.mobile.marketing.data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CustomerData  implements Serializable {

    @SuppressWarnings("compatibility:8111763457549830856")
    private static final long serialVersionUID = 2027657268013415514L;
	
	protected String deviceID ;
	protected String customerName ;
	protected String customerEmail ;
	
	
	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	@Override
	public String toString() {
		return "CustomerData [deviceID=" + deviceID + ", customerName="
				+ customerName + ", customerEmail=" + customerEmail + "]";
	}

	public byte[] serialize() throws IOException
	  {
	    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
	    ObjectOutputStream objectOut = 
	      new ObjectOutputStream(byteStream);

	    objectOut.writeObject(this);

	    return byteStream.toByteArray();
	  }
	
	
	
	
}
