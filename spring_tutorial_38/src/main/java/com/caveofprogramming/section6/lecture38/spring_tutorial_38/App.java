package com.caveofprogramming.section6.lecture38.spring_tutorial_38;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Goal: Configure Database connection, JDBC Template
 * 
 * 1) We need to pass following class org.apache.commons.dbcp.BasicDataSource from bean container (bean.xml) to 
 * OffersDao.java. This would let offersdao to connect and query the database.
 * 2) Look into OffersDao.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext;     
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section6/lecture38/spring_tutorial_38/beanXML/beans.xml");   	
		OffersDao offersDao = (OffersDao)appContext.getBean("offersDao");
		List<Offer> offers = offersDao.getOffers();
		for(Offer offer: offers) {
			System.out.println(offer.getName());
		}
 		((ClassPathXmlApplicationContext)appContext).close();
    }
}
