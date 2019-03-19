package com.caveofprogramming.section5.lecture33.spring_tutorial_33;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomText {

	public static String[] texts = {"I will be back", "Get Out !","I want your clothes, boot, "
			+ "and motorcycle"};
	
	public String getText() {
		Random random = new Random();
		return texts[random.nextInt(texts.length)];
	}
}
