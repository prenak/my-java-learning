package com.xps.java.core.serialization;

public class Address {
	
	private int 	houseNumber;
	private int 	roadNumber;
	private String 	city;
	private int 	pincode;
	
	
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public int getRoadNumber() {
		return roadNumber;
	}
	public void setRoadNumber(int roadNumber) {
		this.roadNumber = roadNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", roadNumber=" + roadNumber + ", city=" + city + ", pincode="
				+ pincode + "]";
	}
}
