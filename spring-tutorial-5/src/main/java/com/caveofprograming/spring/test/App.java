package com.caveofprograming.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Normal Way to instantiate class and call a method*/
		Person person = new Person();
		person.speak();
		
		/*Spring way
		 * 1) instantiated objects using xml files (needs to be at root of project)
		 * 2) After creating XML, we need java code that will contain 
		 * 	  spring bean container which will read xml and instantiated the bean or person object
		 * ApplicationContext is a bean container class. It is a class that can instantiated beans or objects, 
		 * we can fetch instantiated objects from this container any time we want.
		 * There are several types of Bean containers. That means we can choose what variety of ApplicationContext
		 * we use. */
		ApplicationContext appContext;
		
		/*
		 *There are several types of Bean containers. That means we can choose what variety of ApplicationContext
		 * we use. One variety of Bean container that could have been used instead of ApplicationContext is called
		 * Bean Factory, BeanFactory may be Parent class of ApplicationContext.
		 * */
		appContext = new FileSystemXmlApplicationContext("beans.xml");
		
		
	}

}
