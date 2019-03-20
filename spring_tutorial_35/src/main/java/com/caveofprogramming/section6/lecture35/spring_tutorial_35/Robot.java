package com.caveofprogramming.section6.lecture35.spring_tutorial_35;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Robot {

	private int id=0;
	private String speech = "hello";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setSpeech(String speech) {
		this.speech = speech;
	}
	
	public String getSpeech() {
		return speech;
	}
	
}
