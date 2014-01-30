package com.oracle.oep.event;

public class MarketingEvent {

	public String deviceID ;
	public String businessID ;
	public String businessName ;
	public int industryID ;
	public double latitude ;
	public double longitude ;
	public double distance ;
	
	public String getDeviceID() {
		return deviceID;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	public String getBusinessID() {
		return businessID;
	}
	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}
	public int getIndustryID() {
		return industryID;
	}
	public void setIndustryID(int industryID) {
		this.industryID = industryID;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	@Override
	public String toString() {
		return "MarketingEvent [deviceID=" + deviceID + ", businessID="
				+ businessID + ", businessName=" + businessName
				+ ", industryID=" + industryID + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", distance=" + distance + "]";
	}
	
	
	
	
	
}
