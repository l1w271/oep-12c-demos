package com.oracle.oep.shopping.event;

public class LoginEvent {

	public String customerID ;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	@Override
	public String toString() {
		return "LoginEvent [customerID=" + customerID + "]";
	}
	
	
	
}
