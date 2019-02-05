package com.caveofprogramming.section2.Lecture10.spring_tutorial_10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.caveofprogramming.section2.Lecture10.spring_tutorial_10.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/*
    	 * Goal : Bean Scope-  Prototype and Singleton 
    	 * When a Spring bean is scoped as a singleton, the Spring IoC container 
    	 * creates exactly one instance of the object defined by that bean definition.
    	 * By default, the Spring IoC container creates and initializes all beans as a 
    	 * singleton. But we can define the scope of a bean as singleton using the 
    	 * scope="singleton" attribute of the <bean/>
    	 * */
    	
    	ApplicationContext appContext;
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section2/Lecture10/spring_tutorial_10/beanXml/beans.xml");
		Person appContextPerson = (Person) appContext.getBean("person");
		appContextPerson.speak();
		System.out.println("appContextPerson " + appContextPerson);	
		/*
		 * Person bean has been initiated with certain values through bean container
		 * when we use the bean to create another person we still get the same value of
		 * tax id - that is why default scope of bean container is singleton. It can
		 * explicitly we stated in beans.xml by:
		 * 
		 * <bean id="person"
		 * class="com.caveofprogramming.section2.Lecture10.spring_tutorial_10.Person"
		 * scope="singleton"> <constructor-arg value="777" type="int" index="0"
		 * name="id"></constructor-arg> <constructor-arg value="Mary" type="String"
		 * index="1" name="name"></constructor-arg> <property name="taxId"
		 * value="123"></property> <property name="address"
		 * ref="addressBean"></property> </bean>
		 */
		
		/*This means if i change the value of taxId appContextPerson and ask for another "person" bean from app context, 
		 * it would return same person with 321 value, because there will only be one object floating around (singleton nature)*/
		appContextPerson.setTaxId(321);
		System.out.println("appContextPerson " + appContextPerson);		
		Person appContextPerson2 = (Person) appContext.getBean("person");
		System.out.println("appContextPerson2 " +appContextPerson2.toString());
		
		
		Address appContextAddress = (Address) appContext.getBean("addressBean");
		appContextAddress.toString();
		System.out.println("appContextAddress1" + appContextAddress.toString());
		appContextAddress.setStreet("Street1");
		System.out.println("appContextAddress1" + appContextAddress.toString());
		/*
		 * When a spring bean is scoped as a prototype, the Spring IoC container 
		 * creates new bean instance every time when a request is made for that bean.
		 * 
		 * 
		 * This means if I change the value of street for appContextAddress bean it doesn't effect the value of appContextAddress bean
		 * when i ask for it again, and its only a prototype (Seperate objects)
		 */
		Address appContextAddress2 = (Address) appContext.getBean("addressBean");
		System.out.println("appContextAddress2" + appContextAddress2.toString());
		
		((ClassPathXmlApplicationContext)appContext).close();
    }
}
