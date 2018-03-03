package com.caveofprogramming.section2.Lecture12.spring_tutorial_12;

public class PersonFactory {

	public Person createPersonFromPersonFactoryBean(int id , String name) {
		System.out.println("Using factory to create function through person factor class");
		return new Person(id, name);
	}
}
