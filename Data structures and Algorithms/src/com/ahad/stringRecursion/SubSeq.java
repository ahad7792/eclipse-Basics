package com.ahad.stringRecursion;

import java.util.ArrayList;

public class SubSeq {
	
	public static void main(String[] args) {
		String str = "abc";
		subseq("", str);
		System.out.println(subseqRet("", str));
	}
	
	public static void subseq(String sub, String str) {
		if(str.isEmpty()) {
			System.out.println(sub);
			return;
		}
		char ch = str.charAt(0);
		subseq(sub + ch, str.substring(1));
		subseq(sub, str.substring(1));
	}
	
	public static ArrayList<String> subseqRet(String sub, String str){
		if(str.isEmpty()) {
			ArrayList<String> ans = new ArrayList<>();
			ans.add(sub);
			return ans;
		}
		char ch = str.charAt(0);
		ArrayList<String> left = subseqRet(sub, str.substring(1));
		ArrayList<String> right = subseqRet(ch + sub, str.substring(1));
		
		left.addAll(right);
		return left;
	}

}
