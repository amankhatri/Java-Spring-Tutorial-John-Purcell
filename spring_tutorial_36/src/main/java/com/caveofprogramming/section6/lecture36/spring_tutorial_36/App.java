package com.caveofprogramming.section6.lecture36.spring_tutorial_36;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Goal: using properties file 2
 * 1) Create a new package and add jdbc.properties file to it.
 * 2) add property place holder in bean.xml - go to bean.xml
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext;     
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section6/lecture36/spring_tutorial_36/beanXML/beans.xml");   	
		Robot robot = (Robot)appContext.getBean("robot");
		
		System.out.println("Robot Speech: "+ robot.getSpeech());
		System.out.println("Robot ID: " + robot.getId());
		
		((ClassPathXmlApplicationContext)appContext).close();
    }
}
