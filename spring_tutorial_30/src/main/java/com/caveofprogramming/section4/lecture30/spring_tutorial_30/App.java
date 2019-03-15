package com.caveofprogramming.section4.lecture30.spring_tutorial_30;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Automatic Bean Discovery. That means we will take out all the beans from beans.xml and
 * use annotations instead.
 * 
 * 1) Remove all the beans from Beans.xml and add component-scan in the context to beans.xml 
 *  - In context tab right clean beans, and add component scan. Add fully qualified names of
 *  the packages that you want to use as beans in base-package text box. 
 *  However we have to tell component scan xml element which classes are invovled as well to
 *  do so follow step 2
 *  
 *  2) Add @Compenent annotation to all the classes that need to be a bean 
 *  for example: Look into Logger.java, ConsoleWriter and FileWriter. (Look at logger.java and
 *  fileWriter.java)
 *  
 *  5) @Compnent can also be supplied a name like so : @component("name")
 *  example FileWriter
 *  
 *
 *
 */
public class App 
{
	public static void main( String[] args )
    {
    	ApplicationContext appContext;     
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section4/lecture30/spring_tutorial_30/beanXML/beans.xml");   	
		Logger logger = (Logger)appContext.getBean("logger");
		logger.writeConsole("Hello to Console");
		logger.writeFile("Hello to File");
		System.out.println("Logger: "+ logger.toString());
		
		((ClassPathXmlApplicationContext)appContext).close();
    	
    }
}
