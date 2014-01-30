package com.oracle.cache.demo;

import java.io.IOException;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;

public class CustomerData implements PortableObject  {

	protected String customerID ;
	protected String firstName ; 
	protected String lastName ;
	protected float totalPurchases ;
	protected int loyaltyStatus ;
	
	public CustomerData() {
		super();
	}
	
	public void readExternal(PofReader in) throws IOException {
		customerID = in.readString(0);
		firstName = in.readString(1);
		lastName = in.readString(2);
		totalPurchases = in.readFloat(3);
		loyaltyStatus = in.readInt(4);
		
	}

	public void writeExternal(PofWriter out) throws IOException {
		out.writeString(0, customerID);
		out.writeString(1, firstName);
		out.writeString(2, lastName);
		out.writeFloat(3, totalPurchases);
		out.writeInt(4, loyaltyStatus);
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
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
		return "CustomerData [customerID=" + customerID + ", firstName="
				+ firstName + ", lastName=" + lastName + ", totalPurchases="
				+ totalPurchases + ", loyaltyStatus=" + loyaltyStatus + "]";
	}

	


}
