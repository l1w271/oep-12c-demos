package com.oracle.oep.shopping.event;

public class CartEvent {

	public String sessionID ;
	public String customerID ;
	public String product ;
	public String category ;
	public int quantity ;
	public float price ;
	
	
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CartEvent [sessionID=" + sessionID + ", customerID="
				+ customerID + ", product=" + product + ", category="
				+ category + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}
	

	
	
}
