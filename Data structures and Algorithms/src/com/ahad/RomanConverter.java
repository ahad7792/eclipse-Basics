package com.ahad;

public class RomanConverter {

	public static void main(String[] args) {
		String numString = "XVII";
		char ch = '\0';
		System.out.println(convertNum(ch, numString));
	}

	static int sum = 0;

	public static int convertNum(char sub, String num) {

		if (num.length() == 0) {
			return 0;
		}
		
		sub = num.charAt(0);
		
		if (sub == 'I') {
			return 1 + convertNum(sub, num.substring(1));
		} else if (sub == 'V') {
			return 5 + convertNum(sub, num.substring(1));
		} else if (sub == 'X') {
			return 10 + convertNum(sub, num.substring(1));
		} else if (sub == 'L') {
			return 40 + convertNum(sub, num.substring(1));
		}

		return sum;

	}

}
