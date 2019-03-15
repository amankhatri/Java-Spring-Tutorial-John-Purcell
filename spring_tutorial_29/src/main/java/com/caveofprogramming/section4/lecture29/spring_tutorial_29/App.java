package com.caveofprogramming.section4.lecture29.spring_tutorial_29;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * The Inject Annotation JSR 300. This is from 2009. 
 * Same as autowire. 
 * 
 * 1) Refer to logger.java
 *
 */
public class App 
{
	public static void main( String[] args )
    {
    	ApplicationContext appContext;     
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section4/lecture29/spring_tutorial_29/beanXML/beans.xml");   	
		Logger logger = (Logger)appContext.getBean("logger");
		logger.writeConsole("Hello to Console");
		logger.writeFile("Hello to File");
		System.out.println("Logger: "+ logger.toString());
		
		((ClassPathXmlApplicationContext)appContext).close();
    	
    }
}
