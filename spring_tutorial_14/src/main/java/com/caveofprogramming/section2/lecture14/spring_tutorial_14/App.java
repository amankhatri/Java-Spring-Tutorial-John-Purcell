package com.caveofprogramming.section2.lecture14.spring_tutorial_14;

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
	 * Goal: Setting List Properties
	 */
    public static void main( String[] args )
    {


    	ApplicationContext appContext;     
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section2/lecture14/spring_tutorial_14/beanXML/beans.xml");

    	/*
		 * To pass a list as a constructor argument we can add list by
		 * 
		 * <bean id="basket" class=
		 * "com.caveofprogramming.section2.lecture14.spring_tutorial_14.FruitBasket">
		 * <constructor-arg value="List1"></constructor-arg> 
		 * <constructor-arg> 
		 * 		<list>
		 * 			<value>Apple</value> 
		 * 			<value>Orange</value> 
		 * 			<value>Banana</value>
		 * 			<value>Kiwi</value> 
		 * 		</list> 
		 * </constructor-arg> 
		 * </bean>
		 * 
		 */
		FruitBasket basket = (FruitBasket)appContext.getBean("basket");
		System.out.println("BasketList: " +basket);
		
		/*
		 * In list we can have duplicate entries likes this:
		 * 
		 * <bean id="basket2" class=
		 * "com.caveofprogramming.section2.lecture14.spring_tutorial_14.FruitBasket">
		 * <constructor-arg value="List1"></constructor-arg>
		 *  <constructor-arg> 
		 *  	<list>
		 * 			<value>Apple</value> 
		 * 			<value>Orange</value> 
		 * 			<value>Banana</value>
		 * 			<value>Kiwi</value> 
		 * 			<value>Apple</value> 
		 * 		</list>
		 *  </constructor-arg>
		 *  </bean>
		 * */
		FruitBasket basket2 = (FruitBasket)appContext.getBean("basket2");
		System.out.println("BasketList with duplicate Items" +basket2);
		
		/** Instead of List we can also have set Type remember we can also have set type
		 * however unlike list we can not have duplicate iteams in set
		 * 
		 * <bean id="basket3" class=
		 * "com.caveofprogramming.section2.lecture14.spring_tutorial_14.FruitBasket">
		 * <constructor-arg value="List1"></constructor-arg>
		 *  <constructor-arg> 
		 *  	<set>
		 * 			<value>Apple</value> 
		 * 			<value>Orange</value> 
		 * 			<value>Banana</value>
		 * 			<value>Kiwi</value> 
		 * 			<value>Apple</value> 
		 * 		</set>
		 *  </constructor-arg>
		 *  </bean>
		 * 
		 * */
		
		FruitBasket basket3 = (FruitBasket)appContext.getBean("basket3");
		System.out.println("BasketList with duplicate Items" +basket3);
		
		
		((ClassPathXmlApplicationContext)appContext).close();
    	
    }
}
