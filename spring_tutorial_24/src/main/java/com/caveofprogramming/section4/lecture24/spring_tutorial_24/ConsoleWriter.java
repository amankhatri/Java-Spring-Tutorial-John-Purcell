package com.caveofprogramming.section4.lecture24.spring_tutorial_24;

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
