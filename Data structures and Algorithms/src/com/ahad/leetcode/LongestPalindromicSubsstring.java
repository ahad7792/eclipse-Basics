package com.ahad.leetcode;

public class LongestPalindromicSubsstring {

	public static void main(String[] args) {
		String s = "cbbd";
		System.out.println(longestPalindrome(s));
	}

	public static String longestPalindrome(String s) {

		if (s.length() == 0)
			return null;
		if (s.length() == 1)
			return s;

		int n = s.length();
		String ans = null;

		int[][] dp = new int[n][n];

		int maxLength = 0;

		for (int diff = 0; diff < n; diff++) {
			for (int i = 0, j = i + diff; j < n; j++, i++) {

				if (i == j) {
					// that means I am at the first diagonal
					dp[i][j] = 1;
				} else if (diff == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = 2;
					} else {
						dp[i][j] = 0;
					}
				} else {
					if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] != 0) {
						dp[i][j] = dp[i + 1][j - 1] + 2;
					} 
				}

				if (dp[i][j] != 0) {
					if (j - i + 1 > maxLength) {
						maxLength = j - i + 1;
//						if(maxLength == 2) {
//							ans = s.substring(i, maxLength + 1);
//						} else 
							ans = s.substring(i, j + 1);
					}
				}

			}
		}

		return ans;

	}

}
