package com.caveofprogramming.section6.lecture37.spring_tutorial_37;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {

	private String id="id";
	private String speech = "hello";
	
	public String getId() {
		return id;
	}
	/*
	 * 6) inject values using autowire and @value.
	 * */
	@Autowired
	public void setId(@Value("${jdbc.datasource.username}") String id) {
		this.id = id;
	}
	@Autowired
	public void setSpeech(@Value("${jdbc.datasource.password}")String speech) {
		this.speech = speech;
	}
	
	public String getSpeech() {
		return speech;
	}
	
}
