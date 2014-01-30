package com.oracle.oep.demo.admin;

public class OfferQuery implements OEPQueryInterface {

	public String queryID ;
	public String processorID = "OfferProcessor" ;
	public String query ;

	public String offerID ;
	public String imgSource ;
	public String productID ; 
	public String productName ;
	public float price ; 
	public int loyaltyStatus ;
	public String compare ;
		
	public String getQuery() {
				
		String template = "ISTREAM( " +
				"SELECT customerID, sessionID, '%s' as offerID, '%s' as imgSource," +
				" '%s' as productID, '%s' as productName, %s as price " +
				"FROM CustomerChannel " +
				"WHERE loyaltyStatus %s %s " +
				")" ;

		String query = String.format(template, offerID, imgSource, productID, productName, price, compare, loyaltyStatus);
		
		return query;
	}

	public String getQueryID() {
		return queryID;
	}
	public void setQueryID(String queryID) {
		this.queryID = queryID;
	}
	public String getProcessorID() {
		return processorID;
	}
	public void setProcessorID(String processorID) {
		this.processorID = processorID;
	}
	public void setQuery(String query) {
		this.query = query;
	}

	public String getOfferID() {
		return offerID;
	}

	public void setOfferID(String offerID) {
		this.offerID = offerID;
	}

	public String getImgSource() {
		return imgSource;
	}

	public void setImgSource(String imgSource) {
		this.imgSource = imgSource;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
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

	public String getCompare() {
		return compare;
	}

	public void setCompare(String compare) {
		this.compare = compare;
	}

	public int getLoyaltyStatus() {
		return loyaltyStatus;
	}

	public void setLoyaltyStatus(int loyaltyStatus) {
		this.loyaltyStatus = loyaltyStatus;
	}

	@Override
	public String toString() {
		return "OfferQuery [queryID=" + queryID + ", processorID="
				+ processorID + ", query=" + query + ", offerID=" + offerID
				+ ", imgSource=" + imgSource + ", productID=" + productID
				+ ", productName=" + productName + ", price=" + price
				+ ", loyaltyStatus=" + loyaltyStatus + ", compare=" + compare
				+ "]";
	}

	
	
	
	
}
