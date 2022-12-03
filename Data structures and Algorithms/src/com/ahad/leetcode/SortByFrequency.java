package com.ahad.leetcode;

import java.util.Arrays;

public class SortByFrequency {

	public String frequencySort(String s) {
		
		if(s.length()<3) return s;
		
		StringBuffer ansBuffer = new StringBuffer();
		
		int[][] frequency = new int[122][2]; //as it contains all types of characters
		
		for(int i = 0; i < 122; i++) frequency[i][0] = i; //marking the integer value of character
		
		for(int i = 0; i < s.length(); i++) {
			frequency[s.charAt(i) - '0'][1]++;
		}
		
		Arrays.sort(frequency, (a, b) -> b[1] - a[1]);
		
		int i = 0;
		while(i < 122) {
			while(frequency[i][1] != 0) {
				ansBuffer.append((char)(frequency[i][0] + '0'));
				frequency[i][1]--;
			}
			i++;
		}
		
		return ansBuffer.toString();

	}

}
