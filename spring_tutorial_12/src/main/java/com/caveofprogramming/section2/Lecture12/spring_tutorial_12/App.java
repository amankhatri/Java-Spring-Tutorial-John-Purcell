package com.caveofprogramming.section2.Lecture12.spring_tutorial_12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.caveofprogramming.section2.Lecture12.spring_tutorial_12.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/*
    	 * Goal : Factory Beans and Methods.
    	 * Sometimes a bean needs to be created by Factory Method instead of constructor 
    	 * There are two kinds of beans in the Spring bean container: ordinary beans and factory beans. 
    	 * Spring uses the former directly, whereas latter can produce objects themselves, 
    	 * which are managed by the framework
    	 * 
    	 * Factory method is a method that returns a new instance of a class for which
    	 *  factory was made.
    	 *  
    	 *  In person Class we add a factory method called getInstance, static is method is important
    	 *  name of doesn't matter. Static method is important because we always want the same instance
    	 *  of an object from factory
    	 *   (public static Person getInstance())
    	 *  
    	 * 
    	 * */
    	
    	/*
		 * 
		 * 
		 * such error my occur If we run the code by adding a factory-method of
		 * getInstance and also pass arguments in bean container, it would give us
		 * following error:
		 * 
		 * * No matching factory method found: factory method 'getInstance(int,String)'.
		 * Check that a method with the specified name and arguments exists and that it
		 * is static.
		 * 
		 * This occurs because factory method, that is getInstance method, doesn't have
		 * a int,string input arguments.
		 * 
		 * 
		 * <bean id="person"
		 * class="com.caveofprogramming.section2.Lecture12.spring_tutorial_12.Person"
		 * scope="prototype" init-method="onCreate" destroy-method="onDestroy"
		 * factory-method="getInstance"> <constructor-arg value="777" type="int"
		 * index="0" name="id"></constructor-arg> <constructor-arg value="Mary"
		 * type="String" index="1" name="name"></constructor-arg> <property name="taxId"
		 * value="123"></property> <property name="address"
		 * ref="addressBean"></property> </bean>
		 * 
		 * so we would have to remove constuctor arguments.
		 * 
		 * <bean id="person"
		 * class="com.caveofprogramming.section2.Lecture12.spring_tutorial_12.Person"
		 * scope="prototype" init-method="onCreate" destroy-method="onDestroy"
		 * factory-method="getInstance"> <property name="taxId" value="123"></property>
		 * <property name="address" ref="addressBean"></property> </bean>
		 */
    	/*
		 */
    	ApplicationContext appContext;
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section2/Lecture12/spring_tutorial_12/beanXml/beans.xml");
		Person appContextPerson = (Person) appContext.getBean("person");
		System.out.println("appContextPerson " + appContextPerson.toString());	
		
		/*
		 * 
		 * 
		 * For factory bean to work with constructor argument, we would have to add the
		 * arguments to factory method and pass it to the constructor of the class for
		 * which new instance is being return
		 * 
		 * 
		 * <bean id="addressBean"
		 * class=3"com.caveofprogramming.section2.Lecture12.spring_tutorial_12.Address"
		 * scope="singleton" init-method="onCreate" destroy-method="onDestroy"
		 * factory-method="getInstance"> <constructor-arg value="Street Name"
		 * type="String" index="0" name="street"></constructor-arg> <constructor-arg
		 * value="35206" type="int" index="1" name="zip"></constructor-arg> </bean>
		 */
		
		
		Address appContextAddress = (Address) appContext.getBean("addressBean");
		System.out.println("appContextAddress1" + appContextAddress.toString());
		
		/*
		 * 
		 * Sometimes a factory class is created seperately for creating beans from
		 * factory.
		 * 
		 * <bean id="person2"
		 * class="com.caveofprogramming.section2.Lecture12.spring_tutorial_12.Person"
		 * scope="prototype" init-method="onCreate" destroy-method="onDestroy"
		 * factory-method="createPersonFromPersonFactoryBean"
		 * factory-bean="PersonFactory"> <constructor-arg value="35206" type="int"
		 * index="0" name="id"></constructor-arg> <constructor-arg value="Person2"
		 * type="String" index="1" name="name"></constructor-arg> <property name="taxId"
		 * value="2123"></property> <property name="address"
		 * ref="addressBean"></property> </bean>
		 * 
		 */
		
		Person appContextPerson2 = (Person) appContext.getBean("person2");
		System.out.println("appContextPerson " + appContextPerson2.toString());	

		
		((ClassPathXmlApplicationContext)appContext).close();
    }
}
