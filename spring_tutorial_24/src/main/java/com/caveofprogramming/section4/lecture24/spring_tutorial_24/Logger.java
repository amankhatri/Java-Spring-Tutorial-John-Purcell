package com.caveofprogramming.section4.lecture24.spring_tutorial_24;

import org.springframework.beans.factory.annotation.Autowired;

public class Logger {

	@Autowired
	private ConsoleWriter consoleWriter;
	@Autowired
	private FileWriter fileWriter;

	/* 4)
	 * @Autowired is a java standard class. As long as the beans in bean.xml are not confusing spring will take care if it
	 * 
	 * This method of autowiring is not perfect, it only autowired by type.
	 * 
	 * 	private ConsoleWriter consoleWriter;
		private FileWriter fileWriter;
	   @Autowired
		public void setConsoleWriter(ConsoleWriter writer) {
			this.consoleWriter = writer;
		}
		@Autowired
		public void setFileWriter(FileWriter fileWriter) {
			this.fileWriter = fileWriter;
		}
	 * 
	 * 
	 * Annotations @Annotation can go before classes, properties and attributes (instance variables)
	 * 
	 * 
	 * 5) you can also write autowired on top of properties like so
	 *  
	 *  
	    @Autowired
	    private ConsoleWriter consoleWriter;
	    @Autowired
	    private FileWriter fileWriter;
	   
	   public void setConsoleWriter(ConsoleWriter writer) {
			this.consoleWriter = writer;
		}
		public void setFileWriter(FileWriter fileWriter) {
			this.fileWriter = fileWriter;
		}
	 *  
	 *  
	 *  
	 *  6) You can autowire the constructor too like so: 
	 *  
	 *  
	    @Autowired
		public Logger (ConsoleWriter consoleWriter, FileWriter fileWriter) {
			this.consoleWriter = consoleWriter;
			this.fileWriter = fileWriter;
		}
		
		public void setConsoleWriter(ConsoleWriter writer) {
			this.consoleWriter = writer;
		}
		public void setFileWriter(FileWriter fileWriter) {
			this.fileWriter = fileWriter;
		}
	
	
	
	 *  7) you can also mix and match like so: 
	 *  
	    @Autowired
		public Logger (ConsoleWriter consoleWriter) {
			this.consoleWriter = consoleWriter;
		}
	
		public void setConsoleWriter(ConsoleWriter writer) {
			this.consoleWriter = writer;
		}
		@Autowired
		public void setFileWriter(FileWriter fileWriter) {
			this.fileWriter = fileWriter;
		}
		
		
		
		This autowiring is by type. 
		
		
	
	 * 8) Most importantly, you can Autowire the properties like so 
	 * 	@Autowired
	    private ConsoleWriter consoleWriter;
	    @Autowired
	    private FileWriter fileWriter
	    
	    and delete the contructor and the getters and setters for consoleWriter and fileWriter. YOu don't need getters and setters.
	 * 
	 * */
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
