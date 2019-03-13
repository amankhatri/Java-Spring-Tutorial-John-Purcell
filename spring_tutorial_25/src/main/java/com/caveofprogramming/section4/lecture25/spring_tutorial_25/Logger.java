package com.caveofprogramming.section4.lecture25.spring_tutorial_25;

import org.springframework.beans.factory.annotation.Autowired;

public class Logger {

	/*
	 * 1) Some beans can be made optional, lets say we have a following bean definition in beans.xml: 
	 * 	<bean name="consoleWriter"
		class="com.caveofprogramming.section4.lecture25.spring_tutorial_25.ConsoleWriter">
		 </bean>
		 
		 and we have 
		 
		 @Autowired
	     private ConsoleWriter consoleWriter;
	     
	     we get following output: 
	     Logger: Logger [consoleWriter=ConsoleWriter [text=Hello to Console], fileWriter=FileWriter [text=Hello to File]]

       2) however if we comment out Autowired from top of ConsoleWriter like so: 
         // @Autowired
	     private ConsoleWriter consoleWriter;
	    
	    and run the code we will still get following output: 
	    Logger: Logger [consoleWriter=null, fileWriter=FileWriter [text=Hello to File]]
	    
	    even though following bean is defined in bean.xml
	    <bean name="consoleWriter"
	    class="com.caveofprogramming.section4.lecture25.spring_tutorial_25.ConsoleWriter">
		 </bean> 
	    
	   3) If we want to make bean optional, we can delete 
	    <bean name="consoleWriter"
	    class="com.caveofprogramming.section4.lecture25.spring_tutorial_25.ConsoleWriter">
		 </bean> 
		 and set
		 @Autowired(required=false)
	     private ConsoleWriter consoleWriter;
	     
	     Required only injects the bean if it is in Bean.xml
	     
	     Output is: 
	     	    Logger: Logger [consoleWriter=null, fileWriter=FileWriter [text=Hello to File]]
	     	    
	     NOTE: Although @Autowire is little intelligent, because it has been able to resolve ambiguity, but
	     REMEMBER, it only does autowiring by type
	
	 * */
	@Autowired(required=false)
	private ConsoleWriter consoleWriter;
	@Autowired
	private FileWriter fileWriter;

	public void writeFile(String text) {
		fileWriter.write(text);
	}
	
	
	
	public void writeConsole(String text) {
		if(consoleWriter!=null) {
			consoleWriter.write(text);
		}
	}

	
	@Override
	public String toString() {
		return "Logger [consoleWriter=" + consoleWriter + ", fileWriter=" + fileWriter + "]";
	}
	
	
	
}
