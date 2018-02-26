package com.caveofprogramming.section2.Lecture10.spring_tutorial_10;

public class Person {

	private int id;
	private String name;
	private int taxId;
	private Address address;
	
	public Person() {
		
	}
	public Person(int id, String name) {
	
		this.id = id;
		this.name = name;
	}

	public void speak() {
		System.out.println("Hello I am a person");
	}

	public int getTaxId() {
		return taxId;
	}
	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", taxId=" + taxId + ", address=" + address + "]";
	}

	
}
