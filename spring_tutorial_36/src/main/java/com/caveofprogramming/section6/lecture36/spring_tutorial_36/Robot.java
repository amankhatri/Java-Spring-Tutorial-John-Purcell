package com.caveofprogramming.section6.lecture36.spring_tutorial_36;

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
	 * 6) inject values using autowire and @value.
	 * */
	@Autowired
	public void setId(@Value("${user}")int id) {
		this.id = id;
	}
	@Autowired
	public void setSpeech(@Value("${password}")String speech) {
		this.speech = speech;
	}
	
	public String getSpeech() {
		return speech;
	}
	
}
