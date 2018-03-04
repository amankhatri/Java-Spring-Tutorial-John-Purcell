package com.caveofprogramming.section2.Lecture13.spring_tutorial_13;

public class PersonFactory {

	public Person createPersonFromPersonFactoryBean(int id , String name) {
		System.out.println("Using factory to create function through person factor class");
		return new Person(id, name);
	}
}
