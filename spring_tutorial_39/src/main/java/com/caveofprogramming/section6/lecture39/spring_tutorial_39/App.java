package com.caveofprogramming.section6.lecture39.spring_tutorial_39;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

/**
 * Goal: 1) Database Exceptions and how spring handles it (DataAccessException, spring wraps it in runtime exception class)
 * Goal: 2) Named Parameter and Handy spring techinique for quering the database for single value (JdbcTemplate, NamedParameterJdbcTemplate, MapSqlParameterSource)
 * Goal: 3) Getting place holder values from bean (BeanPropertySqlParameterSource) look at offersDao bullet 8
 * Goal: 4) Batch Updates, equivalent of Prepared Statements in Spring (SqlParameterSource, namedparam, batchUpdate) - bullet 9, 10
 * Goal: 5) Transactions: When you have group of sql statements and you want them to all succeed or all fail (@Transactional annotation) - bullet 11 onwards
 * 
 *  1) We didn't have to do
 * any database exception handling because spring does it for it. JdbcTemplate
 * wraps up all the exception and make them run time exception. The exceptions
 * are wrapped in DataAccessException is spring class which a type of runtime
 * exception class. We don't have to handle it but we should handle it
 * 
 * 2) Go to OffersDao
 * 
 * 11) add transanction manager bean in bean container , look into bean.xml
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext appContext;
		appContext = new ClassPathXmlApplicationContext(
				"com/caveofprogramming/section6/lecture39/spring_tutorial_39/beanXML/beans.xml");
		OffersDao offersDao = (OffersDao) appContext.getBean("offersDao");
		
		try {
			Offer offer1 = new Offer("offer1", "offer1@tutorial.com", "1 BeanPropertySqlParameterSource example");
			Offer offer2 = new Offer("offer2", "offer2@tutorial.com", "2 BeanPropertySqlParameterSource example");
			offersDao.create(offer1);
			offersDao.create(offer2);
			
			/*10) utlizing create batch method to demo BatchUpdates*/
			Offer offer3 = new Offer("offer3", "offer3@tutorial.com", "3 namedParamJdbc.batchUpdatee example");
			Offer offer4 = new Offer("offer4", "offer4@tutorial.com", "4 namedParamJdbc.batchUpdate example");
			List<Offer> offerList = new ArrayList<Offer>();
			offerList.add(offer3);
			offerList.add(offer4);
			offersDao.createBatchUpdates(offerList);
			
			/*16) creating offerlist for demoing transactions and go to OffersDAO */
			Offer offer5 = new Offer(5,"offer5", "offer5@tutorial.com", "5 namedParamJdbc.batchUpdatee example");
			Offer offer6 = new Offer(6, "offer6", "offer6@tutorial.com", "6 namedParamJdbc.batchUpdate example");
			List<Offer> offerList2 = new ArrayList<Offer>();
			offerList.add(offer5);
			offerList.add(offer6);
			offersDao.createBatchUpdatesWithTransactions(offerList2);
			
			
			
			List<Offer> offers = offersDao.getOffers();
			for (Offer offer : offers) {
				System.out.println(offer.getName());
			}

		} catch (DataAccessException ex) {
				System.out.println("Exception: " + ex.getMessage());
				System.out.println("Exception Class: " + ex.getClass());
		}
		((ClassPathXmlApplicationContext) appContext).close();
	}
}
