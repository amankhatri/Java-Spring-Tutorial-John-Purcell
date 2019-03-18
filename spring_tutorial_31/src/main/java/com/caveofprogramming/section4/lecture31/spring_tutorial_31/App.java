package com.caveofprogramming.section4.lecture31.spring_tutorial_31;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Setting property values via annotation
 *
 *1) Look into Robot.java
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext;     
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section4/lecture31/spring_tutorial_31/beanXML/beans.xml");   	
		Robot robot = (Robot)appContext.getBean("robot");
		
		System.out.println("Robot Speech: "+ robot.getSpeech());
		System.out.println("Robot ID: " + robot.getId());
		
		((ClassPathXmlApplicationContext)appContext).close();
    }
}
