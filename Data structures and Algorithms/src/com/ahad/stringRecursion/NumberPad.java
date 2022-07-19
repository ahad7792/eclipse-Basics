package com.ahad.stringRecursion;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberPad {
	
	public static void main(String[] args) {
		String numbers = "78";
		System.out.println(pad("", numbers));
		
	}
	
	public static ArrayList<String> pad(String combination, String numbers) {
		if(numbers.isEmpty()) {
			ArrayList<String> combinations = new ArrayList<>();
			combinations.add(combination);
			return combinations;
		}
		
		ArrayList<String> combinations = new ArrayList<>();
		
		int digit = numbers.charAt(0) - '0';					
		int start = (digit*3) - 6;								
		int end = (digit*3) - 4;
		if(digit == 7) {
			end = end + 1;
		}
		if(digit == 8) {
			start= start + 1;
			end = end + 1;
		}
		if(digit == 9) {
			start = start + 1;
			end = end + 2;
		}
		for (int i = start; i <= end; i++) {				
			char ch = (char) ('a' + i);					
			combinations.addAll(pad(combination + ch, numbers.substring(1)));
		}
		
		return combinations;
	}

}
