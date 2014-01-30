package com.oracle.oep.shopping.event;

public class CustomerEvent {

	public String customerID ;
	public String sessionID ;
	public String firstName ; 
	public String lastName ;
	public float totalPurchases ;
	public int loyaltyStatus ;
	
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public float getTotalPurchases() {
		return totalPurchases;
	}
	public void setTotalPurchases(float totalPurchases) {
		this.totalPurchases = totalPurchases;
	}
	public int getLoyaltyStatus() {
		return loyaltyStatus;
	}
	public void setLoyaltyStatus(int loyaltyStatus) {
		this.loyaltyStatus = loyaltyStatus;
	}
	@Override
	public String toString() {
		return "CustomerEvent [customerID=" + customerID + ", sessionID="
				+ sessionID + ", firstName=" + firstName + ", lastName="
				+ lastName + ", totalPurchases=" + totalPurchases
				+ ", loyaltyStatus=" + loyaltyStatus + "]";
	}
	
	
	
	
}
