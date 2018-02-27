package com.caveofprogramming.section2.Lecture11.spring_tutorial_11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.caveofprogramming.section2.Lecture11.spring_tutorial_11.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/*
    	 * Goal : Life Cycle - Init and Destroy methods. 
    	 * Methods that are run after beans are created and before beans are destroyed 
    	 * which occurs after applicationcontext is closed.
    	 * 
    	 * */
    	
    	/*
    	 * Spring automatically destroys a bean with scope of singleton, which means spring
    	 * runs destroy method automatically if the scope bean is set to singleton. However, 
    	 * if the scope of bean is set to prototype, the destroy method will not be run automatically.
    	 * when a prototype bean is declared, and we retrive the bean from bean container, spring
    	 * washes its hand from the bean. Everything that needs to be done to that bean is in hands
    	 * of programmer. 
    	 * 
    	 * Example of prototype bean scope : Person
    	 * Example of Singleton bean scope : Address
    	 * */
    	/*
    	 * init: 
		 * <bean id="person"
		 * class="com.caveofprogramming.section2.Lecture11.spring_tutorial_11.Person"
		 * scope="prototype" init-method="onCreate"> <constructor-arg value="777"
		 * type="int" index="0" name="id"></constructor-arg> <constructor-arg
		 * value="Mary" type="String" index="1" name="name"></constructor-arg> <property
		 * name="taxId" value="123"></property> <property name="address"
		 * ref="addressBean"></property> </bean>
		 * 
		 */
    	
    	/*
    	 * Destroy:
		 * <bean id="person"
		 * class="com.caveofprogramming.section2.Lecture11.spring_tutorial_11.Person"
		 * scope="prototype" init-method="onCreate" destroy-method="onDestroy">
		 * <constructor-arg value="777" type="int" index="0"
		 * name="id"></constructor-arg> <constructor-arg value="Mary" type="String"
		 * index="1" name="name"></constructor-arg> <property name="taxId"
		 * value="123"></property> <property name="address"
		 * ref="addressBean"></property> </bean>
		 */
    	ApplicationContext appContext;
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section2/Lecture11/spring_tutorial_11/beanXml/beans.xml");
		Person appContextPerson = (Person) appContext.getBean("person");
		System.out.println("appContextPerson " + appContextPerson.toString());	
		
		/*
		 * <bean id="addressBean"
		 * class="com.caveofprogramming.section2.Lecture10.spring_tutorial_11.Address"
		 * scope="singleton" destroy-method="onDestroy" init-method="onCreate">
		 * <constructor-arg value="Street Name" type="String" index="0"
		 * name="street"></constructor-arg> <constructor-arg value="35206" type="int"
		 * index="1" name="zip"></constructor-arg> </bean>
		 */
		
		
		Address appContextAddress = (Address) appContext.getBean("addressBean");
		System.out.println("appContextAddress1" + appContextAddress.toString());
		/*
		 */

		
		((ClassPathXmlApplicationContext)appContext).close();
    }
}
