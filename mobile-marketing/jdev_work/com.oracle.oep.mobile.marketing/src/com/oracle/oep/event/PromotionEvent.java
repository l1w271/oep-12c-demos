package com.oracle.oep.event;

public class PromotionEvent extends MarketingEvent {

	private String customerName ;
	private String customerEmail ;
	
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
		return "PromotionEvent [customerName=" + customerName
				+ ", customerEmail=" + customerEmail + ", deviceID=" + deviceID
				+ ", businessID=" + businessID + ", businessName="
				+ businessName + ", industryID=" + industryID + ", latitude="
				+ latitude + ", longitude=" + longitude + ", distance="
				+ distance + "]";
	}
	
	
	
	
	
	
}
