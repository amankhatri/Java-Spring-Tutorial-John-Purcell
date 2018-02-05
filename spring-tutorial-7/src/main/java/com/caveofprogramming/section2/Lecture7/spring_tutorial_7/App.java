package com.caveofprogramming.section2.Lecture7.spring_tutorial_7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		
		ApplicationContext appContext;
		
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section2/Lecture7/spring_tutorial_7/beanXml/beans.xml");
		/*
		 * To use a constructor with arguments, add the arguments to bean xml. While
		 * using bean.xml to instentiate person, we can do away with
		 * 
		 * <bean id="person"
		 * class="com.caveofprogramming.section2.Lecture7.spring_tutorial_7.Person">
		 * <constructor-arg value="777"></constructor-arg> <constructor-arg
		 * value="Mary"></constructor-arg> </bean>
		 * 
		 * however it is always nice to have the type and name of parameter being added
		 * to bean container which can be done by:
		 * 
		 * <bean id="person"
		 * class="com.caveofprogramming.section2.Lecture7.spring_tutorial_7.Person">
		 * <constructor-arg value="777" type="int" index="0"
		 * name="id"></constructor-arg> <constructor-arg value="Mary" type="String"
		 * index="1" name="name"></constructor-arg> </bean>
		 * 
		 * you can also initialize variables by using adding reference to another bean.
		 */
		Person appContextPerson = (Person) appContext.getBean("person");
		appContextPerson.speak();
		System.out.println(appContextPerson);
		((ClassPathXmlApplicationContext)appContext).close();
		
		
	}

}
