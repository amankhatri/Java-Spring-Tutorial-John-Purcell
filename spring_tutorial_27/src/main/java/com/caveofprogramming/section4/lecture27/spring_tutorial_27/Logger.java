package com.caveofprogramming.section4.lecture27.spring_tutorial_27;
import javax.annotation.Resource; 

public class Logger {
	
	private ConsoleWriter consoleWriter;
	private LogWriter fileWriter;

	/*
	 * 2) instead of using autowire annotation, 
	 * we can use @Resource which is a part of JDK 1.6
	 * Resource annotation works by name than narrows it by type. 
	 * Very typical use of @Resource annotation is with name attribute 
	 * like so 
	 * we use the attribute name to remove any ambiguities.
	 * */

	@Resource
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	
	@Resource(name="squirrel")
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
