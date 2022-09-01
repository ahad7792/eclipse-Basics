package com.ahad.leetcode;

import java.util.List;
import java.util.ArrayList;

public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		
		List<String> ansList = new ArrayList<>();
		helper(n, n, "", ansList);
		return ansList;

	}

	private void helper(int open, int close, String sub, List<String> ansList) {
		
		if(open == 0 && close == 0) {
			ansList.add(sub);
			return;
		}
		
		if(open != 0) {
			helper(open - 1, close, sub + "(", ansList);
		}
		
		if(close > open) { //checking the condition while backtracking
			helper(open, close - 1, sub + ")", ansList);
		}
		
	}

}
