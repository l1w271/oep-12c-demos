package com.oracle.oep.event;

public class DeviceEvent {

	public String deviceID ;
	public double latitude ;
	public double longitude ;
	
	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
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
		return "DeviceEvent [deviceID=" + deviceID + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
	
	
	
	
}
