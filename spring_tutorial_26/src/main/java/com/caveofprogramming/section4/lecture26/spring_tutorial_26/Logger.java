package com.caveofprogramming.section4.lecture26.spring_tutorial_26;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Logger {
	
	private ConsoleWriter consoleWriter;
	private LogWriter fileWriter;

	

	/*
	 * 2) add setConsoleWriter method and add two corresponding beans in beans.xml
	 * with different bean ids. 
	 * 3) Look into bean.xml file
	 * 4) REMEMBER, @Autowire will prefer the bean defined in bean container that has the
	 * same name as the property name  even if there is ambiguity.
	 * 
	 *  For example there are two beans defined in bean container 
	   <bean name="consoleWriter"
		class="com.caveofprogramming.section4.lecture26.spring_tutorial_26.ConsoleWriter"> </bean>

	<bean name="squirrel"
		class="com.caveofprogramming.section4.lecture26.spring_tutorial_26.ConsoleWriter"> </bean>
		
	 *
	 *	@Autowired
		public void setConsoleWriter(ConsoleWriter consoleWriter) {
			this.consoleWriter = consoleWriter;
		}
  		@Autowired
		public void setFileWriter(FileWriter fileWriter ) {
			this.fileWriter = fileWriter;
		}
		
		out put is: 
		Logger: Logger [consoleWriter=ConsoleWriter [text=Hello to Console], fileWriter=FileWriter [text=Hello to File]]


		
		5) however if you change the bean id from consoleWriter to consoleWriterq like so: 
		bean name="consoleWriterq"
		class="com.caveofprogramming.section4.lecture26.spring_tutorial_26.ConsoleWriter"> </bean>
		
		which gives you an out put of : 
		Exception in thread "main" org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'logger': Unsatisfied dependency expressed through method 'setConsoleWriter' parameter 0; nested exception is org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.caveofprogramming.section4.lecture26.spring_tutorial_26.ConsoleWriter' available: expected single matching bean but found 2: consoleWriterq,squirrel
        
        
        6) Go to beans.xml and add qualifier by going into beans view and right clicking it. 
        You can name or label it whatever you like. 
        <!-- 6)  step 6 -->
		<bean name="squirrel"
			class="com.caveofprogramming.section4.lecture26.spring_tutorial_26.ConsoleWriter">
     		<qualifier value="consoleQualifier"></qualifier>
		</bean>
		
		7) you can use qualifier annotation under autowired to tell @autowire to use
		consoleQualifier 
		
		@Autowired
		@Qualifier("consoleQualifier")
		public void setConsoleWriter(ConsoleWriter consoleWriter) {
			this.consoleWriter = consoleWriter;
		}
	

		8) You can also use qualifier on classes, to do so lets make FileWriter bean
		that is being injected an ambiguis bean.
		FileWriter & logwriter classes implement logwriter interface
		so lets change  FileWriter to logwriter like so: 
		Change From:
		private FileWriter fileWriter;

		@Autowired
		public void setFileWriter(FileWriter fileWriter ) {
			this.fileWriter = fileWriter;
		}
		
		Change To: 
		private LogWriter fileWriter;

		@Autowired
		public void setFileWriter(LogWriter fileWriter ) {
			this.fileWriter = fileWriter;
		}
		
		In bean.xml
		
		Change From: 
		<bean id="fileWriter"
		class="com.caveofprogramming.section4.lecture26.spring_tutorial_26.FileWriter"> </bean>
		
		
		
		Change To: 
		<bean id="mongose"
		class="com.caveofprogramming.section4.lecture26.spring_tutorial_26.FileWriter"> </bean>

		
		Now we have three beans in beans.xml that implement LogWriter interface, there fore
		autowire will be confused.
		
		
		And output is: 

		 No qualifying bean of type 
		 'com.caveofprogramming.section4.lecture26.spring_tutorial_26.LogWriter' 
		 available: expected single matching bean but found 3: consoleWriter,squirrel,mongose

		9) now to make something qualified to be autowired for Filewriter 
		go to FileWriter class and use @Qualifier annotation. 
		
		10) add qualifier on set method for setFileWriter
		
		
		If there are multiple classes that implements same parent class/interface,and you want
		to wire a specific class to specific peroperty, you can use qualifiers.  
	 * */

	@Autowired
	@Qualifier("consoleQualifier")
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	
  	@Autowired
  	@Qualifier("fileWriter")
	public void setFileWriter(LogWriter fileWriter ) {
		this.fileWriter = fileWriter;
	}
	public void writeConsole(String text) {
		if(consoleWriter!=null) {
			consoleWriter.write(text);
		}
	}
	public void writeFile(String text) {
		fileWriter.write(text);
	}
	
	
	@Override
	public String toString() {
		return "Logger [consoleWriter=" + consoleWriter + ", fileWriter=" + fileWriter + "]";
	}
	
	
	
}
