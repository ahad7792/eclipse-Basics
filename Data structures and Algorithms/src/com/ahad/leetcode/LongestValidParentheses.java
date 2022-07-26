package com.ahad.leetcode;

import java.util.Stack;

public class LongestValidParentheses {
	
	public int longestValidParentheses(String s) {
		
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		
		int max = 0;
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if(stack.isEmpty()) {
					stack.push(i);
				} else {
					int len = i - stack.peek(); 
					max = Math.max(max, len);
				}
			}
		}
		
		return max;

	}

}
