package com.caveofprogramming.section4.lecture29.spring_tutorial_29;

import org.springframework.beans.factory.annotation.Qualifier;

/*
 * Step 9
 * */
@Qualifier("fileWriter")
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
