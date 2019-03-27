package com.caveofprogramming.section6.lecture37.spring_tutorial_37;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Implementing DAO Pattern & configuring database or connection pool
 * 1) Create object (Offer.java) to store data from offers table 
 * 2) create  object (OffersDao.java) to deal with data from offers table
 * 3) Include jdbc connector jar in pom file
 * 4) look into pom.xml
 * 5) add jar to configure connection pool
 * 6) look into pom.xml
 * 7) REMEMBER if we are developing a web application, a server would give us capability to delegate connection pooling 
 * to server.
 * 8) We will add datasource bean to bean.xml from apache connection pooling jar (commons-dbcp), we will also set 
 *  four properties of these beans a) drivername, b) url, c) username, d) password . We also want to make sure we add a 
 *  destroy method to close connection
 *  
 * 9) look into bean.xml
 * 10) Once we are done with setting up datasource, we want to make sure to have closed this connect when context closes
 * 
 */
public class App 
{
	 public static void main( String[] args )
	    {
	    	ApplicationContext appContext;     
			appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section6/lecture37/spring_tutorial_37/beanXML/beans.xml");   	
			Robot robot = (Robot)appContext.getBean("robot");
			
			System.out.println("Robot Speech: "+ robot.getSpeech());
			System.out.println("Robot ID: " + robot.getId());
			
			((ClassPathXmlApplicationContext)appContext).close();
	    }
}
