package com.caveofprogramming.section3.lecture19.spring_tutorial_19;

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
	 * Goal: Autowiring by name: 
	 * 
	 */
	
	/*
	 * There are several types of autowiring. Here we are using autowire by name.
	 * When you look at the set methods in the a class (Logger) where you know what
	 * that two different beans of are being autowired though an interface (That
	 * means they look the same because of interface but are not) we can inject them
	 * by name. Because if we do it by type spring will get confused. so we can't do
	 * this:
	 *
	 * <bean id="logger"
	 * class="com.caveofprogramming.section3.lecture19.spring_tutorial_19.Logger"
	 * autowire="byType"> </bean>
	 * 
	 * <bean id="consoleWriter" class=
	 * "com.caveofprogramming.section3.lecture19.spring_tutorial_19.ConsoleWriter">
	 * 
	 * </bean>
	 * 
	 * <bean id="fileWriter" class=
	 * "com.caveofprogramming.section3.lecture19.spring_tutorial_19.FileWriter">
	 * 
	 * </bean>
	 * 
	 * we do it manually for sure however we should do it by name to make it easier
	 * " logger class:
	 * 
	 * FileWriter and ConsoleWriter are of type LogWriter public void
	 * setFileWriter(FileWriter fileWriter) { this.fileWriter = fileWriter; } public
	 * void setConsoleWriter(ConsoleWriter consoleWriter) { this.consoleWriter =
	 * consoleWriter; }
	 * 
	 * 
	 * <bean autowire="byName" id="logger"
	 * class="com.caveofprogramming.section3.lecture19.spring_tutorial_19.Logger">
	 * </bean>
	 * 
	 * <bean name="consoleWriter" class=
	 * "com.caveofprogramming.section3.lecture19.spring_tutorial_19.ConsoleWriter">
	 * </bean>
	 * 
	 * <bean id="fileWriter" class=
	 * "com.caveofprogramming.section3.lecture19.spring_tutorial_19.FileWriter">
	 * </bean>
	 * 
	 */
    public static void main( String[] args )
    {
    	ApplicationContext appContext;     
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section3/lecture19/spring_tutorial_19/beanXML/beans.xml");   	
		Logger logger = (Logger)appContext.getBean("logger");
		logger.writeConsole("Hello to Console");
		logger.writeFile("Hello to File");
		System.out.println("Logger: "+ logger.toString());
		
		((ClassPathXmlApplicationContext)appContext).close();
    	
    }
}
