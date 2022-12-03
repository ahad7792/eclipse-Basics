package com.ahad.leetcode;

import java.util.Set;

public class StringHalvesAlike {
	
	public static void main(String[] args) {
		String s = "Textbook";
		System.out.println(halvesAreAlike(s));
	}

	public static boolean halvesAreAlike(String s) {
		
		var vowelSet = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
		int left = 0;
		int right = 0;
		
		for(int i = 0; i < s.length()/2; i++) {
			if(vowelSet.contains((s.charAt(i)))) {
				left++;
			}
		}
		
		for(int i = s.length()/2; i < s.length(); i++) {
			if(vowelSet.contains((s.charAt(i)))) {
				right++;
			}
		}
		
		return left == right;

	}

}
