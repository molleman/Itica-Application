package com.itica.android;

import android.location.Address;

public class Chipper implements Comparable {
	
	private String name;
	private String address;
	private String county;
	private String phone;
	private double lon;
	private double lat;
	private Address mapAddress;
	
	
	public Chipper(String name, String address, String county, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.county = county;
		this.phone = phone;
	}

	public Chipper() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public Address getMapAddress() {
		return mapAddress;
	}

	public void setMapAddress(Address mapAddress) {
		this.mapAddress = mapAddress;
	}

	public int compareTo(Object arg0) {
		Chipper c = (Chipper) arg0;
		if(this.getName().compareTo(c.getName()) <0) {
			return -1;
		
		}else if(this.getName().compareTo(c.getName()) >0){
			return 1;
		}else{
			if(this.getAddress().compareTo(c.getAddress()) <0){
				return -1;
			}else{
				return 1;
			}
		}
		
	}
	
	
	

}
