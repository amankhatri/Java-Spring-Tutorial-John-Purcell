package com.caveofprogramming.section2.lecture15.spring_tutorial_15;

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
	 * Goal: Inner beans
	 */
    public static void main( String[] args )
    {


    	ApplicationContext appContext;     
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section2/lecture15/spring_tutorial_15/beanXML/beans.xml");

    	/*
		 * If a class (bean) has variables that are instance of another class (bean), they can be
		 * initialized using injection in following way:
		 * 
	<bean id="jungleBean"
	class="com.caveofprogramming.section2.lecture15.spring_tutorial_15.Jungle">

	<property name="largest" value="Elephant"></property>
	<property name="animals">
		<list>
			<ref bean="lion" />
			<ref bean="elephant" />
			<ref bean="snake" />
		</list>
	</property>
	</bean>

	<bean id="lion"
		class="com.caveofprogramming.section2.lecture15.spring_tutorial_15.Animal">
	<property name="name" value="Igor"></property>
	<property name="type" value="lion"></property>
	</bean>

	<bean id="elephant"
		class="com.caveofprogramming.section2.lecture15.spring_tutorial_15.Animal">
	<property name="name" value="Richard"></property>
	<property name="type" value="Elephant"></property>
	</bean>


	<bean id="snake"
		class="com.caveofprogramming.section2.lecture15.spring_tutorial_15.Animal">
	<property name="name" value="Bob"></property>
	<property name="type" value="Snake"></property>
	</bean>
		 * 
		 * 
		 * 
		 */
		Jungle jungle = (Jungle)appContext.getBean("jungleBean");
		System.out.println("BasketList: " +jungle);
		
		((ClassPathXmlApplicationContext)appContext).close();
    	
    }
}
