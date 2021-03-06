package com.caveofprogramming.section4.lecture30.spring_tutorial_30;

import org.springframework.stereotype.Component;

@Component("fileWriter")
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
