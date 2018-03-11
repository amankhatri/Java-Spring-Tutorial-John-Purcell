package com.caveofprogramming.section3.lecture20.spring_tutorial_20;

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
	 * Goal: Autowiring by constructor: 
	 * 
	 */
	
	/*
	 * There are several types of autowiring. Here we are using autowire by
	 * constuctor. <bean autowire="constructor" id="logger"
	 * class="com.caveofprogramming.section3.lecture20.spring_tutorial_20.Logger">
	 * </bean>
	 * 
	 * <bean name="consoleWriter" class=
	 * "com.caveofprogramming.section3.lecture20.spring_tutorial_20.ConsoleWriter">
	 * </bean>
	 * 
	 * <bean id="fileWriter" class=
	 * "com.caveofprogramming.section3.lecture20.spring_tutorial_20.FileWriter">
	 * </bean>
	 * 
	 * 
	 * 
	 */
    public static void main( String[] args )
    {
    	ApplicationContext appContext;     
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section3/lecture20/spring_tutorial_20/beanXML/beans.xml");   	
		Logger logger = (Logger)appContext.getBean("logger");
		logger.writeConsole("Hello to Console");
		logger.writeFile("Hello to File");
		System.out.println("Logger: "+ logger.toString());
		
		((ClassPathXmlApplicationContext)appContext).close();
    	
    }
}
