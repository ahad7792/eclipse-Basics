package com.ahad.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
	
	public static void main(String[] args) {
		String string = "a1b2";
		List<String> anStrings = letterCasePermutation(string);
		System.out.println(anStrings);
	}

	public static List<String> letterCasePermutation(String s) {
		List<String> ans = new ArrayList<>();
		helper("", s, ans);
		return ans;

	}

	private static void helper(String sub, String given, List<String> ans) {
		if(given.length() == 0) {
			ans.add(sub);
			return;
		}
		
		char curr = given.charAt(0);
		
		int currNum = (int) curr;
		
		if(currNum >=48 && currNum <= 57) {
			helper(sub + curr, given.substring(1), ans);
		} else {
			helper(sub + Character.toLowerCase(curr), given.substring(1), ans);
			helper(sub + Character.toUpperCase(curr), given.substring(1), ans);
		}
		
	}

}
