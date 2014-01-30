package com.oracle.oep.event;

import com.oracle.cep.cartridge.spatial.Geometry;

public class BusinessLocation {

	private int businessID ;
	private int industryID ;
	private String businessName ;
	private double longitude ;
	private double latitude ;
	private Geometry geom ;
	
	
	public int getBusinessID() {
		return businessID;
	}
	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}
	
	public int getIndustryID() {
		return industryID;
	}
	public void setIndustryID(int industryID) {
		this.industryID = industryID;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public Geometry getGeom() {
		return geom;
	}
	public void setGeom(Geometry geom) {
		this.geom = geom;
	}
	@Override
	public String toString() {
		return "BusinessLocation [businessID=" + businessID + ", industryID="
				+ industryID + ", businessName=" + businessName
				+ ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}
	
	
	
}
