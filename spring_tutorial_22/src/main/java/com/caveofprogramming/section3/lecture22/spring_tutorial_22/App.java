package com.caveofprogramming.section3.lecture22.spring_tutorial_22;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	/**
	 * @param args
	 * 
	 * Goal: Removing Ambiguties
	 * 
	 */
	
	/*
	 * 1) Look at bean.xml
	 */
    public static void main( String[] args )
    {
    	ApplicationContext appContext;     
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section3/lecture22/spring_tutorial_22/beanXML/beans.xml");   	
		Logger logger = (Logger)appContext.getBean("logger");
		logger.writeConsole("Hello to Console");
		logger.writeFile("Hello to File");
		System.out.println("Logger: "+ logger.toString());
		
		((ClassPathXmlApplicationContext)appContext).close();
    	
    }
}
