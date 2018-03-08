package com.caveofprogramming.section2.lecture15.spring_tutorial_15;

import java.util.List;

public class Jungle {
	String largest;
	List<Animal> animals;
	
	public String getLargest() {
		return largest;
	}
	public void setLargest(String largest) {
		this.largest = largest;
	}
	public List<Animal> getAnimals() {
		return animals;
	}
	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}
	@Override
	public String toString() {
		return "Jungle [largest=" + largest + ", animals=" + animals + "]";
	}


}
