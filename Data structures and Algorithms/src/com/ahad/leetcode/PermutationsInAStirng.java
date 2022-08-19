package com.ahad.leetcode;

import java.util.regex.Matcher;

public class PermutationsInAStirng {
	
	public static void main(String[] args) {
		String s1 = "cd";
		String s2 = "abcde";
		System.out.println(checkInclusion(s1, s2));
	}

	public static boolean checkInclusion(String s1, String s2) {
		
		int[] s1_arr = new int[26];
		int[] s2_arr = new int[26];
		
		for(int i = 0; i < s1.length(); i++) {
			s1_arr[s1.charAt(i) - 'a']++;
		}
		
		for(int i = 0; i < s2.length(); i++) {
			if(i < s1.length()) {
				s2_arr[s2.charAt(i) - 'a']++;
			} else {
				s2_arr[s2.charAt(i) - 'a']++;
				s2_arr[s2.charAt(i - s1.length()) - 'a']--;
			}
			if (match(s1_arr, s2_arr)) {
				return true;
			}
		}
		
		return false;

	}

	private static boolean match(int[] s1_arr, int[] s2_arr) {
		for(int i = 0; i < 26; i++) {
			if(s1_arr[i] != s2_arr[i]) {
				return false;
			}
		}
		return true;
	}

}
