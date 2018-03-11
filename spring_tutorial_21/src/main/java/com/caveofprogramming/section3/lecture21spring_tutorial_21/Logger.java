package com.caveofprogramming.section3.lecture21spring_tutorial_21;

public class Logger {

	private ConsoleWriter consoleWriter;
	private FileWriter fileWriter;

	public void setConsoleWriter(ConsoleWriter writer) {
		this.consoleWriter = writer;
	}

	public void setFileWriter(FileWriter fileWriter) {
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
