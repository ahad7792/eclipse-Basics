package com.ahad.leetcode;

public class CloseSting {
	
	public static void main(String[] args) {
		String w1 = "cabbba";
		String w2 = "abbccc";
		System.out.println(closeStrings(w1, w2));
	}

	public static boolean closeStrings(String word1, String word2) {
		
		if(word1.length() != word2.length()) return false;
		
		int[] w1 = new int[26];
		int[] w2 = new int[26];
		
		for(int i = 0; i < word1.length(); i++) {
			w1[word1.charAt(i) - 'a']++;
			w2[word2.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < 26; i++) {
			if(w1[i] != 0 && w2[i] != 0 && w1[i] != w2[i]) {
				for(int j = i + 1; j < 26; j++) {
					if(w1[j] == w2[i]) {
						int t = w1[j];
						w1[j] = w1[i];
						w1[i] = t;
					}
				}
			}
		}
		
		for(int i = 0; i < 26; i++) {
			if(w1[i] != w2[i]) return false;
		}
		
		return true;

	}

}
