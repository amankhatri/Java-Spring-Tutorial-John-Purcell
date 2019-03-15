package com.caveofprogramming.section4.lecture29.spring_tutorial_29;
import javax.annotation.*;
import javax.inject.Inject;
import javax.inject.Named; 

public class Logger {
	
	private ConsoleWriter consoleWriter;
	private LogWriter fileWriter;

	/*
	 * 2) You can use inject to autowire beans, Inject is not available in jdk library, 
	 * so add dependency to pom
	 * 
	 * <dependency>
  			<groupId>javax.inject</groupId>
  			<artifactId>javax.inject</artifactId>
  			<version>1.0.0.redhat-6</version>
	   </dependency>
	   
	   
	 * 3) Inject is very sensitive with ambiguities
	 * 
	 * 
	 * */
	@Inject
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	
	/*
	 * @Named is a qualifier in JSR 300
	 * */
	@Inject
	@Named(value="squirrel")
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
	
	/*
	 * 2) If we wanna run this init matter after beans are initialized, then use 
	 * @PostConstruct annotation 
	 * */
	
	@PostConstruct
	public void init() {
		System.out.println("Init, runs just after beans are initalized");
	}
	
	/*
	 * 3) If we wanna run this before beans are destroyed
	 * @PreDestroy annotation 
	 * */
	
	@PreDestroy
	public void destroy() {
		System.out.println("destroy, runs before all beans are destroyed");
	}
	
	/*
	 * Leave the scope of the beans default or single ton, if you change it to prototype it will not
	 * run destroy method . Spring doesn't handle the beans after creating prototype beans
	 * */
	
	@Override
	public String toString() {
		return "Logger [consoleWriter=" + consoleWriter + ", fileWriter=" + fileWriter + "]";
	}
	
	
	
}
