package com.oracle.cache.demo;

import java.io.IOException;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;

public class BusinessData implements PortableObject  {

	public int businessID ;
	public String businessName ;
	public int industryID ;
	public double latitude ;
	public double longitude ;
	
	public BusinessData() {
		super();
	}

	public void readExternal(PofReader in) throws IOException {
		businessID = in.readInt(0);
		businessName = in.readString(1);
		industryID = in.readInt(2);	
		latitude = in.readDouble(3);
		longitude = in.readDouble(4);	
	}

	public void writeExternal(PofWriter out) throws IOException {
		out.writeInt(0, businessID);
		out.writeString(1, businessName);
		out.writeInt(2, industryID);
		out.writeDouble(3, latitude);
		out.writeDouble(4, longitude);;
	}

	public int getBusinessID() {
		return businessID;
	}

	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
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

	@Override
	public String toString() {
		return "BusinessData [businessID=" + businessID + ", businessName="
				+ businessName + ", industryID=" + industryID + ", latitude="
				+ latitude + ", longitude=" + longitude + "]";
	}
	
	
	
}
