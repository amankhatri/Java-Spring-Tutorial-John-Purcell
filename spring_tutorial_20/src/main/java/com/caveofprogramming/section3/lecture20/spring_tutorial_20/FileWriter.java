package com.caveofprogramming.section3.lecture20.spring_tutorial_20;

public class FileWriter implements LogWriter {
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
		return "FileWriter [text=" + text + "]";
	}
	
}
