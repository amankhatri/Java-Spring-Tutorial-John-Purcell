package com.caveofprogramming.section3.lecture17.spring_tutorial_17;

public class Logger {

	private ConsoleWriter consoleWriter;
	private FileWriter fileWriter;
	
	
	public ConsoleWriter getConsoleWriter() {
		return consoleWriter;
	}
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	public FileWriter getFileWriter() {
		return fileWriter;
	}
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	public void writeFile(String text) {
		this.fileWriter.write(text);
	}
	public void writeConsole(String text) {
		this.consoleWriter.write(text);
	}
	
	
	@Override
	public String toString() {
		return "Logger [consoleWriter=" + consoleWriter + ", fileWriter=" + fileWriter + "]";
	}
	
	
	
}
