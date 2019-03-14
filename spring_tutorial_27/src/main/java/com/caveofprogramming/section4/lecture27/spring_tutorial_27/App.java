package com.caveofprogramming.section4.lecture27.spring_tutorial_27;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * The Resource Annotation: Another annotation that lets you do dependency injection.
 * JSR: Java specification Request, JSR 250 is one such specification. Resource annotation
 * is equivalent of Autowire  in JAVA.
 *
 * 1) Look into Logger.java
 **/
public class App 
{
	  public static void main( String[] args )
	    {
	    	ApplicationContext appContext;     
			appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section4/lecture27/spring_tutorial_27/beanXML/beans.xml");   	
			Logger logger = (Logger)appContext.getBean("logger");
			logger.writeConsole("Hello to Console");
			logger.writeFile("Hello to File");
			System.out.println("Logger: "+ logger.toString());
			
			((ClassPathXmlApplicationContext)appContext).close();
	    	
	    }
}
