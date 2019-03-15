package com.caveofprogramming.section4.lecture28.spring_tutorial_28;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Goal: Annotation based init and destroy methods
 * Explains how we can use JSR 250 to specify init and destroy method. So we will learn
 * how to specify method to be run after initialization and before destruction of all beans.
 * 
 * 1) go to logger.java
 * 
 */
public class App 
{
	public static void main( String[] args )
    {
    	ApplicationContext appContext;     
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section4/lecture28/spring_tutorial_28/beanXML/beans.xml");   	
		Logger logger = (Logger)appContext.getBean("logger");
		logger.writeConsole("Hello to Console");
		logger.writeFile("Hello to File");
		System.out.println("Logger: "+ logger.toString());
		
		((ClassPathXmlApplicationContext)appContext).close();
    	
    }
}
