package com.ahad.leetcode;

public class PalindromicSubstrings {
	
	public static void main(String[] args) {
		String s = "racecar";
		System.out.println(countSubstrings2(s));
	}

	public static int countSubstrings(String s) {
		
		if(s.length() == 0) return 0;
		if(s.length() == 1) return 1;
		
		int n = s.length();
		int ans = 0;
		
		//solving with dynamic programming
		//complexity would be O(n^2)
		
		boolean[][] dp = new boolean[n][n];
		
		//lets fill up the diagonal of the matrix with true
		//they contain only one character
		
		for(int i = 0; i < n; i++) {
			dp[i][i] = true;
			ans++;
		}
		
		//now fill up next upper diagonal
		//for substrings of size 2
		
		for(int i = 0; i < n - 1; i++) {
			dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
			if(dp[i][i + 1]) {
				ans++;
			}
		}
		
		//now fill up for later diagonals
		//for substrings size more than 2
		
//		for(int i = 0; i < n - 2; i++) {
//			for(int j = 2; j < n; j++) {
//				dp[i][j] = (s.charAt(i) == s.charAt(j)) && (dp[i + 1][j - 1]);
//				if(dp[i][j]) {
//					ans++;
//				}
//			}
//		}
		
		//can't use the previous loop because we are working with diagonals
		
		for(int len = 3; len <= n; len++) {
			for(int i = 0, j = i+len-1; j < n; i++, j++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1]);
				if(dp[i][j]) {
					ans++;
				}
			}
		}
		
		return ans;

	}
	
	public static int countSubstrings2(String s) {
		
		if(s.length() == 0) return 0;
		if(s.length() == 1) return 1;
		
		int n = s.length();
		int ans = 0;
		
		for(int i = 0; i < n; i++) {
			ans += isPalindrome(i, i, s);
			ans += isPalindrome(i, i + 1, s);
		}
		
		return ans;
		
	}

	private static int isPalindrome(int st, int en, String s) {
		int count = 0;
		
		while(st >= 0 && en < s.length() && s.charAt(st) == s.charAt(en)) {
			count++;
			st--;
			en++;
		}
		
		return count;
	}

}
