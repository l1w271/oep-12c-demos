package com.oracle.oep.event;

public class Customer {

	public String deviceID ;
	public String customerName ;
	public String customerEmail ;
	
	
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
		return "Customer [deviceID=" + deviceID + ", customerName="
				+ customerName + ", customerEmail=" + customerEmail + "]";
	}
	
	
	
}
