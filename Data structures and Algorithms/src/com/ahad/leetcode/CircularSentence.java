package com.ahad.leetcode;

public class CircularSentence {
	
	public static void main(String[] args) {
		String sentence = "eetcode";
		System.out.println(isCircularSentence(sentence));
	}

	public static boolean isCircularSentence(String sentence) {
		
		char prevChar = '1';
		
		char lastChar = '0';
		
		char first = sentence.charAt(0);
		char last = sentence.charAt(sentence.length() - 1);
		
		for(int i = 0; i < sentence.length(); i++) {
			
			if(prevChar == ' ') {
				if((lastChar == sentence.charAt(i))) {
					lastChar = prevChar;
					prevChar = sentence.charAt(i);
					continue;
				} else {
					return false;
				}
			}
			lastChar = prevChar;
			prevChar = sentence.charAt(i);
		}
		
		if(sentence.charAt(sentence.length() - 1) != sentence.charAt(0)) return false;
		
		return true;

	}

}
