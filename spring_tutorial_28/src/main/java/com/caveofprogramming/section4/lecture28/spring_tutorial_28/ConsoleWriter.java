package com.caveofprogramming.section4.lecture28.spring_tutorial_28;

public class ConsoleWriter implements LogWriter{
	String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void write(String text) {
		setText(text);
	}
	@Override
	public String toString() {
		return "ConsoleWriter [text=" + text + "]";
	}

}
