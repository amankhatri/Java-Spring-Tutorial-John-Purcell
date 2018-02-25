package com.caveofprogramming.section2.Lecture9.spring_tutorial_9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.caveofprogramming.section2.Lecture9.spring_tutorial_9.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/*
    	 * Goal : To demonstrate Dependency Injection
    	 * */
    	
    	ApplicationContext appContext;
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section2/Lecture9/spring_tutorial_9/beanXml/beans.xml");
		Person appContextPerson = (Person) appContext.getBean("person");
		appContextPerson.speak();
		System.out.println(appContextPerson);	
		/*
		 * When address bean is not an independent bean it can be initialized using
		 * <bean id="addressBean"
		 * class="com.caveofprogramming.section2.Lecture9.spring_tutorial_9.Address">
		 * <constructor-arg value="Street Name" type="String" index="0"
		 * name="street"></constructor-arg> <constructor-arg value="35206" type="int"
		 * index="1" name="zip"></constructor-arg> </bean>
		 * 
		 */
		Address appContextAddress = (Address) appContext.getBean("addressBean");
		appContextAddress.toString();
		System.out.println(appContextAddress.toString());
		/*
		 * However, when Person Bean dependends on Address bean, we have to give a
		 * reference to address bean for initialization while initializing person bean.
		 * This is called dependency injection, we are injecting the dependency into
		 * person using spring in bean container like this:
		 * 
		 * <bean id="person"
		 * class="com.caveofprogramming.section2.Lecture9.spring_tutorial_9.Person">
		 * <constructor-arg value="777" type="int" index="0"
		 * name="id"></constructor-arg> <constructor-arg value="Mary" type="String"
		 * index="1" name="name"></constructor-arg> <property name="taxId"
		 * value="123"></property> <property name="address"
		 * ref="addressBean"></property> </bean>
		 * 
		 */
		System.out.println(appContextPerson.toString());
		((ClassPathXmlApplicationContext)appContext).close();
    }
}
