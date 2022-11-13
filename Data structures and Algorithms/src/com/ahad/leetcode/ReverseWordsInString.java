package com.ahad.leetcode;

import java.util.Stack;

public class ReverseWordsInString {

	public static void main(String[] args) {
		String string = "  hello world  ";
		System.out.println(reverseWords(string));
	}

	public static String reverseWords(String s) {

		Stack<String> stack = new Stack<>();

		for (String a : s.trim().split(" ")) {
			if (a != "")
				stack.push(a.trim());
		}

		StringBuilder sb = new StringBuilder();

		while (!stack.empty()) {
			sb.append(stack.pop() + " ");
		}

		return sb.toString().trim();

	}

}
