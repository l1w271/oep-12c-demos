package com.oracle.oep.shopping.event;

public class TotalCartEvent {

	public String customerID ;
	public String sessionID ;
	
	public Float totalCart ;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public Float getTotalCart() {
		return totalCart;
	}

	public void setTotalCart(Float totalCart) {
		this.totalCart = totalCart;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	@Override
	public String toString() {
		return "TotalCartEvent [customerID=" + customerID + ", sessionID="
				+ sessionID + ", totalCart=" + totalCart + "]";
	}

	

	
	
	
	
}
