package com.caveofprogramming.section3.lecture20.spring_tutorial_20;

public class Logger {

	private LogWriter consoleWriter;
	private LogWriter fileWriter;

	public Logger(ConsoleWriter consoleWriter, FileWriter fileWriter) {
		this.consoleWriter=consoleWriter;
		this.fileWriter=fileWriter;
	}
	public void setConsoleWriter(LogWriter writer) {
		this.consoleWriter = writer;
	}

	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	
	public void writeFile(String text) {
		fileWriter.write(text);
	}
	
	public void writeConsole(String text) {
		consoleWriter.write(text);
	}


	
	
	@Override
	public String toString() {
		return "Logger [consoleWriter=" + consoleWriter + ", fileWriter=" + fileWriter + "]";
	}
	
	
	
}
