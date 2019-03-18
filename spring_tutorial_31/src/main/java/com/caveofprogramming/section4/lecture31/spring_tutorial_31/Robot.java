package com.caveofprogramming.section4.lecture31.spring_tutorial_31;

import javax.inject.Inject;

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
	 * 2) lets say we want to supply value for id, we can type @value before 
	 * the property like so
	 * Remember we are supplying a string which will get translated to int, because
	 * that is how spring works.
	 * We also have to tell spring to autowire this value for ID by using @inject or 
	 * @autowire or @resource annotation
	 * 
	 */
	@Inject
	public void setId(@Value("1138")int id) {
		this.id = id;
	}
	public String getSpeech() {
		return speech;
	}
	public void setSpeech(String speech) {
		this.speech = speech;
	}
	
}
