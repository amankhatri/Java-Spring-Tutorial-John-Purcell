package com.caveofprogramming.section5.lecture34.spring_tutorial_34;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Some Useful SPEL Operators
 * https://docs.spring.io/spring/docs/3.0.x/reference/expressions.html
 * 
 * 1) Go to robot.java
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext;     
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section5/lecture34/spring_tutorial_34/beanXML/beans.xml");   	
		Robot robot = (Robot)appContext.getBean("robot");
		
		System.out.println("Robot Speech: "+ robot.getSpeech());
		System.out.println("Robot ID: " + robot.getId());
		
		((ClassPathXmlApplicationContext)appContext).close();
    }
}
