package com.caveofprogramming.section2.Lecture8.spring_tutorial_8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Goal: Setting properties of spring beans
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	ApplicationContext appContext;
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section2/Lecture8/spring_tutorial_8/beanXml/beans.xml");
		Person appContextPerson = (Person) appContext.getBean("person");
		appContextPerson.speak();
		/*
		 * To set the value of person.taxId through bean.xml, we would add an element
		 * that would have the sameName as the variable name taxId
		 * 
		 * <bean id="person"
		 * class="com.caveofprogramming.section2.Lecture8.spring_tutorial_8.Person">
		 * <constructor-arg value="777" type="int" index="0" name="id"></constructor-arg>
		 * <constructor-arg value="Mary" type="String" index="1" name="name"></constructor-arg> 
		 * <property name="taxId" value="123"></property> 
		 * </bean>
		 * 
		 * Another way of declaring properties is: 
		 * 
		 * <bean id="person"
		 * class="com.caveofprogramming.section2.Lecture8.spring_tutorial_8.Person">
		 * <constructor-arg value="777" type="int" index="0" name="id"></constructor-arg> 
		 * <constructor-arg value="Mary" type="String" index="1" name="name"></constructor-arg>
		 *  <property name="taxId">
		 *  	<value>123</value>
		 *  </property> 
		 * </bean>
		 */
		System.out.println(appContextPerson);
		((ClassPathXmlApplicationContext)appContext).close();
    }
}
