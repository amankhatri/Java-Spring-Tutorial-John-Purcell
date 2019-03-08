package com.caveofprogramming.section3.lecture22.spring_tutorial_22;

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
