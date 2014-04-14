package com.oracle.cache.demo;

import java.io.IOException;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;

public class CustomerData implements PortableObject {

	public String deviceID ;
	public String customerName ;
	public String customerEmail ;
	
	
	public CustomerData() {
		super();
	}

	public void readExternal(PofReader in) throws IOException {
		deviceID = in.readString(0);
		customerName = in.readString(1);
		customerEmail = in.readString(2);	
	}

	public void writeExternal(PofWriter out) throws IOException {
		out.writeString(0, deviceID);
		out.writeString(1, customerName);
		out.writeString(2, customerEmail);
	}
	
	
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
	
	
	
	
	
}
