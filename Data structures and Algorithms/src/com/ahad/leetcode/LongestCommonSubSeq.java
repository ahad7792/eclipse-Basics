package com.ahad.leetcode;

public class LongestCommonSubSeq {

	Integer[][] dp;

	public int longestCommonSubsequence(String text1, String text2) {
		dp = new Integer[text1.length() + 1][text2.length() + 1];
		return lcs(text1, text2, text1.length(), text2.length());
	}

	private int lcs(String text1, String text2, int n, int m) {

		if (dp[n][m] != null) {
			return dp[n][m];
		}

		int result = 0;
		if (n == 0 || m == 0) {
			result = 0;
		} else if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
			result = 1 + lcs(text1, text2, n - 1, m - 1);
		} else {
			result = Math.max(lcs(text1, text2, n - 1, m), lcs(text1, text2, n, m - 1));
		}

		dp[n][m] = result;
		return dp[n][m];
	}

}
