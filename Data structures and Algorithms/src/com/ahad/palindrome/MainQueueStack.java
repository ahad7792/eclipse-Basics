package com.ahad.palindrome;

import java.util.LinkedList;

public class MainQueueStack {

	public static void main(String[] args) {
		

		System.out.println(checkForPalindrome("I did, did I?"));
		
		System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
		
		System.out.println(checkForPalindrome("Hello"));


	}
	
	public static boolean checkForPalindrome(String string) {
		
		LinkedList<Character> stack = new LinkedList<Character>();
		LinkedList<Character> queue = new LinkedList<Character>();
		String lowerCase = string.toLowerCase();
		
		for(int i = 0; i < lowerCase.length(); i++) {
			char c = lowerCase.charAt(i);
			if (c >= 'a' && c <= 'z') {
				queue.addLast(c);
				stack.push(c);
			}
		}
		
		while (!stack.isEmpty()) {
			if(!stack.pop().equals(queue.removeFirst())) {
				return false;
			}
		}
		
		return true;
	}

}
