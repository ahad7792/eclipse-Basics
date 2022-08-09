package com.ahad.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		
		int firstPointer = 0;
		int secondPointer = 0;
		int max = 0;
		
		Queue<Character> queue = new LinkedList<>();
		
		while(secondPointer < s.length()) {
			if(!queue.contains(s.charAt(secondPointer))) {
				queue.add(s.charAt(secondPointer));
				secondPointer++;
				max = Math.max(queue.size(), max);
			} else {
				queue.remove();
				firstPointer++;
			}
		}
		
		return max;

	}

}
