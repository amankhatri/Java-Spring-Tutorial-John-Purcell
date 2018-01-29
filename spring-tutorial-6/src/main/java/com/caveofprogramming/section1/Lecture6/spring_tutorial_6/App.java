package com.caveofprogramming.section1.Lecture6.spring_tutorial_6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appContext;
		/*if bean.xml file doesn't exist in root, we have to pass the complete relative path of
		 * beans.xml which would look something like: 
		 * appContext = new FileSystemXmlApplicationContext("src/main/java/com/caveofprogramming/section1/Lecture6/spring_tutorial_6/beanXml/beans.xml");
		 * .
		 * if we want bean.xml to be loaded from anyhwere in project we would have to use ClassPathXmlApplicationContext
		 * Classpath is anywhere 
		 * */
		
		appContext = new ClassPathXmlApplicationContext("com/caveofprogramming/section1/Lecture6/spring_tutorial_6/beanXml/beans.xml");
		Person appContextPerson = (Person) appContext.getBean("person");
		appContextPerson.speak();
		/*ApplicationContext container closes itself, however there are some containers
		 * like FileSystemXmlApplicationContext or ClassPathXmlApplicationContext that does not close itself and there fore
		 * requires closing */
		((ClassPathXmlApplicationContext)appContext).close();
		
		
	}

}
