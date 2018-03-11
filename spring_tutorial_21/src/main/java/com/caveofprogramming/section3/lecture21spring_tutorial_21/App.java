package com.caveofprogramming.section3.lecture21spring_tutorial_21;

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
	 * Goal: Autowiring by Default: 
	 * 
	 */
	
	/*
	 * You can set the auto wiring type to default for entire xml togeather. FYI you
	 * can have multple xmls for in an application. Here since we have only one xml
	 * file we can set the default-autowire for entire application to be byName;ss
	 * 
	 * <?xml version="1.0" encoding="UTF-8"?> <beans
	 * xmlns="http://www.springframework.org/schema/beans"
	 * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	 * xmlns:p="http://www.springframework.org/schema/p" xsi:
	 * schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd"
	 * default-autowire="byName">
	 * 
	 * <bean id="logger"
	 * class="com.caveofprogramming.section3.lecture21spring_tutorial_21.Logger">
	 * </bean>
	 * 
	 * <bean name="consoleWriter" class=
	 * "com.caveofprogramming.section3.lecture21spring_tutorial_21.ConsoleWriter">
	 * </bean>
	 * 
	 * <bean id="fileWriter" class=
	 * "com.caveofprogramming.section3.lecture21spring_tutorial_21.FileWriter">
	 * </bean>
	 * 
	 * Default_autowire by type:
	 * 
	 * <?xml version="1.0" encoding="UTF-8"?> <beans
	 * xmlns="http://www.springframework.org/schema/beans"
	 * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	 * xmlns:p="http://www.springframework.org/schema/p" xsi:
	 * schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd"
	 * default-autowire="byType">
	 * 
	 * <bean id="logger"
	 * class="com.caveofprogramming.section3.lecture21spring_tutorial_21.Logger">
	 * </bean>
	 * 
	 * <bean name="consoleWriter" class=
	 * "com.caveofprogramming.section3.lecture21spring_tutorial_21.ConsoleWriter">
	 * </bean>
	 * 
	 * <bean id="fileWriter" class=
	 * "com.caveofprogramming.section3.lecture21spring_tutorial_21.FileWriter">
	 * </bean> </beans>
	 * 
	 * 
	 * Lets say we have if we have an ambiguity in xml file for example 2 same bean
	 * ids we can add more attributes to the default-autowire for example: autowire
	 * candiates
	 * 
	 * <?xml version="1.0" encoding="UTF-8"?> <beans
	 * xmlns="http://www.springframework.org/schema/beans"
	 * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	 * xmlns:p="http://www.springframework.org/schema/p" xsi:
	 * schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd"
	 * default-autowire="byType"
	 * default-autowire-candidates="consoleWriter,fileWriter">
	 * 
	 * <bean id="logger"
	 * class="com.caveofprogramming.section3.lecture21spring_tutorial_21.Logger">
	 * </bean>
	 * 
	 * <bean name="consoleWriter" class=
	 * "com.caveofprogramming.section3.lecture21spring_tutorial_21.ConsoleWriter">
	 * </bean>
	 * 
	 * <bean id="fileWriter" class=
	 * "com.caveofprogramming.section3.lecture21spring_tutorial_21.FileWriter">
	 * </bean>
	 * 
	 * <bean id="logWriter" class=
	 * "com.caveofprogramming.section3.lecture21spring_tutorial_21.FileWriter">
	 * </bean> </beans>
	 * 
	 * we can also use wild card characters  in default-autowirecandiate like 
	 * 
	 * default-autowire-candidates="*Writer">
	 */
    public static void main( String[] args )
    {
    	ApplicationContext appContext;     
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section3/lecture21/spring_tutorial_21/beanXML/beans.xml");   	
		Logger logger = (Logger)appContext.getBean("logger");
		logger.writeConsole("Hello to Console");
		logger.writeFile("Hello to File");
		System.out.println("Logger: "+ logger.toString());
		
		((ClassPathXmlApplicationContext)appContext).close();
    	
    }
}
