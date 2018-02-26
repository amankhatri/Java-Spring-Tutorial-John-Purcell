package com.caveofprogramming.section2.Lecture10.spring_tutorial_10;

public class Address {
	private String street;
	private int zip;	
	public Address(String street, int zip) {
		super();
		this.street = street;
		this.zip = zip;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", zip=" + zip + "]";
	}
	

}
