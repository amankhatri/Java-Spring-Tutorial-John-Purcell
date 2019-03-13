package com.caveofprogramming.section4.lecture25.spring_tutorial_25;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Optional Beans: Required Attribute of autowired annotation
 * 1) Go into Logger.java
 */
public class App 
{
	 public static void main( String[] args )
	    {
	    	ApplicationContext appContext;     
			appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section4/lecture25/spring_tutorial_25/beanXML/beans.xml");   	
			Logger logger = (Logger)appContext.getBean("logger");
			logger.writeConsole("Hello to Console");
			logger.writeFile("Hello to File");
			System.out.println("Logger: "+ logger.toString());
			
			((ClassPathXmlApplicationContext)appContext).close();
	    	
	    }
}
