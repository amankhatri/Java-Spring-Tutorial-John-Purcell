package com.caveofprogramming.section5.lecture33.spring_tutorial_33;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Using SPEL with Annotation
 * 
 * 
 * 1) Goal is to set value of RobotID and Speech using annotations.
 * 2) Look into Robot.java
 */
public class App 
{
    public static void main( String[] args )
    {
      	ApplicationContext appContext;     
    		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section5/lecture33/spring_tutorial_33/beanXML/beans.xml");   	
    		Robot robot = (Robot)appContext.getBean("robot");
    		
    		System.out.println("Robot Speech: "+ robot.getSpeech());
    		System.out.println("Robot ID: " + robot.getId());
    		
    		((ClassPathXmlApplicationContext)appContext).close();
    }
}
