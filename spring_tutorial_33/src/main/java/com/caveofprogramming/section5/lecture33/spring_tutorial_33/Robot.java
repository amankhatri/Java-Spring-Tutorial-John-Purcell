package com.caveofprogramming.section5.lecture33.spring_tutorial_33;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {

	private int id=0;
	private String speech = "hello";
	
	public int getId() {
		return id;
	}

	/*
	 * 3) You can use @Autowired and @Value to inject values using SPEL
	 * */
	@Autowired
	public void setId(@Value("1234")int id) {
		this.id = id;
	}
	
	@Autowired
	public void setSpeech(@Value("#{randomText.getText()}")String speech) {
		this.speech = speech;
	}
	
	public String getSpeech() {
		return speech;
	}
	
}
