package com.caveofprogramming.section2.Lecture13.spring_tutorial_13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.caveofprogramming.section2.Lecture13.spring_tutorial_13.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/*
    	 * Goal : P Namespace: Alternative way of setting properties on Beans
    	 * 
    	 * */
    	ApplicationContext appContext;
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section2/Lecture13/spring_tutorial_13/beanXml/beans.xml");
		Person appContextPerson = (Person) appContext.getBean("person");
		System.out.println("appContextPerson " + appContextPerson.toString());
    	
    	/*
		 * P Namespace: Alternative way of setting properties on Beans, at the moment
		 * the properties of bean are set using contructor arguments in bean.xml for
		 * example
		 * 
		 * <bean id="addressBean"
		 * class="com.caveofprogramming.section2.Lecture13.spring_tutorial_13.Address">
		 * <constructor-arg value="Factory Address Bean" type="String" index="0"
		 * name="street"></constructor-arg> <constructor-arg value="35206" type="int"
		 * index="1" name="zip"></constructor-arg> </bean>
		 * 
		 */
		Address appContextAddress = (Address) appContext.getBean("addressBean");
		System.out.println("appContextAddress1" + appContextAddress.toString());
		
		/*
		 * But I would like to set them using getters and setters
		 * 
		 * Add default constructor to Address Bean add getters and setters and edit
		 * bean.xml by importing xmlns:p="http://www.springframework.org/schema/p" and
		 * <bean id="addressBean2"
		 * class="com.caveofprogramming.section2.Lecture13.spring_tutorial_13.Address"
		 * p:street="Street Address using p" p:zip="1234"> </bean>
		 * 
		 */
		
		Address appContextAddress2 = (Address) appContext.getBean("addressBean2");
		System.out.println("appContextAddress2" + appContextAddress2.toString());


		
		((ClassPathXmlApplicationContext)appContext).close();
    }
}
