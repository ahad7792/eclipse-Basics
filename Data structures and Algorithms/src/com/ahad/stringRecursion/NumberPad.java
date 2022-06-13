package com.ahad.stringRecursion;

import java.util.Scanner;

public class NumberPad {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.close();
		System.out.println("digits = ");
		String numbers = scanner.next();
		pad("", numbers);
		
	}
	
	public static void pad(String combination, String numbers) {
		if(numbers.isEmpty()) {
			System.out.println(combination);
			return;
		}           											//this code need to be thought again
		int digit = numbers.charAt(0) - '0';					//digit become unexpected
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
		for (int i = start; i <= (end - start); i++) {				//loop not working for start > 1
			char ch = (char) ('a' + i);							//symbols changing for a + start
			pad(combination + ch, numbers.substring(1));
		}
	}

}
