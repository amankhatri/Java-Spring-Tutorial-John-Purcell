package com.caveofprogramming.section3.lecture17.spring_tutorial_17;

public class LogWritter {

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
}
