package com.caveofprogramming.section4.lecture30.spring_tutorial_30;
import javax.annotation.*;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component; 

/*
 * 3) Added at component annotation 
 * 4) You can also specify name or bean id for the beans using @Component 
 * look at FileWriter.java class and setFileWriter method in this class. 
 * */
@Component
public class Logger {
	
	private ConsoleWriter consoleWriter;
	private LogWriter fileWriter;

	@Inject
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	
	@Inject
	@Named(value="fileWriter")
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
