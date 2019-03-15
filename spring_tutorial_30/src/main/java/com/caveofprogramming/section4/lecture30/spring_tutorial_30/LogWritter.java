package com.caveofprogramming.section4.lecture30.spring_tutorial_30;

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
