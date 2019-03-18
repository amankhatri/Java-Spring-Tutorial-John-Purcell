package com.caveofprogramming.section5.lecture32.spring_tutorial_32;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * SPEL: Spring Expression Language. 
 *
 *1) Look into bean.xml
 */
public class App 
{
    public static void main( String[] args )
    {
      	ApplicationContext appContext;     
    		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section5/lecture32/spring_tutorial_32/beanXML/beans.xml");   	
    		Robot robot = (Robot)appContext.getBean("robot3");
    		
    		System.out.println("Robot Speech: "+ robot.getSpeech());
    		System.out.println("Robot ID: " + robot.getId());
    		
    		((ClassPathXmlApplicationContext)appContext).close();
    }
}
