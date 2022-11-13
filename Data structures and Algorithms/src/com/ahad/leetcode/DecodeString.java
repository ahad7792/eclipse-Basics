package com.ahad.leetcode;

import java.util.Stack;

public class DecodeString {
	
	public static void main(String[] args) {
		String string = "3[a2[c]]";
		String anString = decodeStringRecursive(string);
		System.out.println(anString.toString());
	}

	public static String decodeString(String s) {
		Stack<Integer> numbers = new Stack<>();
		Stack<String> stringStack = new Stack<>();
		String result = "";
		int index = 0;
		
		while(index < s.length()) {
			if(Character.isDigit(s.charAt(index))) {
				int count = 0;
				while(Character.isDigit(s.charAt(index))) {
					count = 10 * count + (s.charAt(index) - '0');
					index++;
				}
				numbers.push(count);
			} else if(s.charAt(index) == '[') {
				stringStack.push(result);
				result = "";
				index++;
			} else if(s.charAt(index) == ']') {
				int lastNum = numbers.pop();
				StringBuilder temp = new StringBuilder(stringStack.pop());
				for (int i = 0; i < lastNum; i++) {
					temp.append(result);
				}
				result = temp.toString();
				index++;
			} else {
				result += s.charAt(index);
				index++;
			}
		}
		
		return result;
	}
	
	static int i = 0; 
	public static String decodeStringRecursive(String s) {
		StringBuffer result = new StringBuffer();
		while(i < s.length() && s.charAt(i) != ']') {
			if(Character.isDigit(s.charAt(i))) {
				int k = 0;
				while(i < s.length() && Character.isDigit(s.charAt(i))) {
					k = k * 10 + s.charAt(i) - '0';
					i++;
				}
				i++;
				String r = decodeStringRecursive(s);
				while(k > 0) {
					result.append(r);
					k--;
				}
				i++;
			} else {
				result.append(s.charAt(i));
				i++;
			}
		}
		return result.toString();
	}

}
