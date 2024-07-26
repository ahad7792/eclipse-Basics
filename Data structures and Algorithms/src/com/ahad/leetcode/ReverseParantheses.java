package com.ahad.leetcode;

public class ReverseParantheses {
	
	static int i = 0;
	
	public static void main(String[] args) {
		String s = "(u(love)i)";
		System.out.println(reverseParentheses(s));
	}
	
	public static String reverseParentheses(String s) {

        StringBuilder sb = new StringBuilder();

        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                i++;
                String nextReverseString = reverseParentheses(s);
                sb.append(nextReverseString);
            } else if (c == ')') {
                i++;
                return sb.reverse().toString();
            } else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }

}
