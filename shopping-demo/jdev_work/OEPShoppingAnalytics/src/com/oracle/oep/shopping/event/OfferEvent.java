package com.oracle.oep.shopping.event;

public class OfferEvent {

	
	public String offerID ;
	public String customerID ;
	public String sessionID ;
	public String productID ;
	public String imgSource ; 
	public String productName ;
	public float price ;

	public String getOfferID() {
		return offerID;
	}
	public void setOfferID(String offerID) {
		this.offerID = offerID;
	}
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
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	
	public String getImgSource() {
		return imgSource;
	}
	public void setImgSource(String imgSource) {
		this.imgSource = imgSource;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OfferEvent [offerID=" + offerID + ", customerID=" + customerID
				+ ", sessionID=" + sessionID + ", productID=" + productID
				+ ", imgSource=" + imgSource + ", productName=" + productName
				+ ", price=" + price + "]";
	}
	
	
	
}
