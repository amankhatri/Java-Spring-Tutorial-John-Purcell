package com.caveofprogramming.section5.lecture32.spring_tutorial_32;

import java.util.Random;

public class RandomText {

	public static String[] texts = {"I will be back", "Get Out !","I want your clothes, boot, "
			+ "and motorcycle"};
	
	public String getText() {
		Random random = new Random();
		return texts[random.nextInt(texts.length)];
	}
}
