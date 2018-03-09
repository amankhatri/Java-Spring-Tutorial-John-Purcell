package com.caveofprogramming.section3.lecture17.spring_tutorial_17;

public class ConsoleWriter {
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
