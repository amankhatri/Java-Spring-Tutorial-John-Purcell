package com.caveofprogramming.section2.Lecture13.spring_tutorial_13;

public class Person {

	private int id;
	private String name;
	private int taxId;
	private Address address;
	
	public Person() {
		
	}
	public static Person getInstance() {
		System.out.println("Creating Person using factory method in person class");
		return new Person(1234, "FactoryBean");
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
	
	/*this method can be named anything. When we use this keyword, it refers to 
	 * Person class and since it has a toString method, printing this would show print toString 
	 * method*/
	public void onCreate() {
		System.out.println("Person created: " + this );
	}
	
	public void onDestroy() {
		System.out.println("Person destroyed");
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
