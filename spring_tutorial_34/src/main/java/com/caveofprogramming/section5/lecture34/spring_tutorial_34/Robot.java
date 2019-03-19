package com.caveofprogramming.section5.lecture34.spring_tutorial_34;

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

	@Autowired
	public void setId(@Value("1234")int id) {
		this.id = id;
	}
	
	
	/*
	 * 2) You can create objects of bean or class in spel. If it anything other than java.lang package, you have to specify fully 
	 * qualified name of the java class like so: 
	 * */
	@Autowired
	public void setSpeech1(@Value("#{new java.util.Date().toString()}")String speech) {
		this.speech = speech;
	}
	
	
	/*
	 * 3) You can also use a property or a method of a static class by doing so:  
	 * 
	 * */
	@Autowired
	public void setSpeech2(@Value("#{T(Math).PI}")String speech) {
		this.speech = speech;
	}
	
	
	/*
	 * 4) You can also nest the properties of static class:  
	 * 
	 * */
	@Autowired
	public void setSpeech3(@Value("#{T(Math).sin(T(Math).PI)}")String speech) {
		this.speech = speech;
	}
	
	
	/*
	 * 5) You can also use and and or expresion, in spell all of these things are
	 * spelt out because < sign is also used in  xml, so there are some conflicting 
	 * things, but you can use le, gt for >  and eq for = ;
	 * 
	 * */
	
	
	public String getSpeech() {
		return speech;
	}
	
}
