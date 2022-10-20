package com.ahad.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		String s = "LVIIIV";
		System.out.println(romanToInt(s));
		System.out.println(romanToIntRe(s));
	}

	public static int romanToInt(String s) {

		int answer = 0, num = 0, prev = 0;

		for (int j = s.length() - 1; j >= 0; j--) {
			switch (s.charAt(j)) {
			case 'I':
				num = 1;
				break;
			case 'V':
				num = 5;
				break;
			case 'X':
				num = 10;
				break;
			case 'L':
				num = 50;
				break;
			case 'C':
				num = 100;
				break;
			case 'D':
				num = 500;
				break;
			case 'M':
				num = 1000;
				break;
			}
			if (num < prev) {
				answer -= num;
			} else {
				answer += num;
			}
			prev = num;
		}
		return answer;
	}

	static Map<Character, Integer> romanToIntMap = new HashMap<>();

	static {
		romanToIntMap.put('I', 1);
		romanToIntMap.put('V', 5);
		romanToIntMap.put('X', 10);
		romanToIntMap.put('L', 50);
		romanToIntMap.put('C', 100);
		romanToIntMap.put('D', 500);
		romanToIntMap.put('M', 1000);
	}

	public static int romanToIntRe(String s) {// use recursion
		// base case:
		if (s.length() == 1) {
			return romanToIntMap.get(s.charAt(0));
		}
		// recursion
		int l = romanToIntMap.get(s.charAt(0));
		int r = romanToIntMap.get(s.charAt(1));
		if (l < r) {
			return romanToIntRe(s.substring(1)) - l;
		} else {
			return romanToIntRe(s.substring(1)) + l;
		}
	}

}
