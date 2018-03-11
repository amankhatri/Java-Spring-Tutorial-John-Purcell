package com.caveofprogramming.section3.lecture18.spring_tutorial_18;

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
	 * Goal: Autowiring by type: Autowriring tells spring to figure out by itself how beans are connected. 
	 * 
	 * private ConsoleWriter consoleWriter;
	 * private FileWriter fileWriter;
	 * are two beans that will be injected in logger bean using autowiring.
	 */
	
	/*
	 * There are several types of autowiring. Here we are using autowire by type.
	 * When you look at the set methods in a
	 * class where you know what type of beans are suppose to be injected and
	 * where they need to be injected you can "autowire by type"
	 * logger class:
	 * 
	 * public void setFileWriter(FileWriter fileWriter) {
	 * this.fileWriter = fileWriter; 
	 * } 
	 * public void setConsoleWriter(ConsoleWriter consoleWriter) { 
	 * this.consoleWriter = consoleWriter; 
	 * }
	 * 
	 */
    public static void main( String[] args )
    {
    	ApplicationContext appContext;     
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section3/lecture18/spring_tutorial_18/beanXML/beans.xml");   	
		Logger logger = (Logger)appContext.getBean("logger");
		logger.writeConsole("Hello to Console");
		logger.writeFile("Hello to File");
		System.out.println("Logger: "+ logger.toString());
		
		((ClassPathXmlApplicationContext)appContext).close();
    	
    }
}
