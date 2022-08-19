package com.ahad.stringRecursion;

public class Permutations {
	
	public static void main(String[] args) {
		String str = "abc";
		System.out.println(permutationCount("", str));
		permutation("", str);
	}
	
	public static void permutation(String sub, String given) {
		if(given.isEmpty()) {
			System.out.println(sub);
			return;
		}
		char ch = given.charAt(0);
		for(int i = 0; i <= sub.length(); i++) {
			String f = sub.substring(0, i);
			String e = sub.substring(i, sub.length());
			String p = f + ch + e;
			permutation(p, given.substring(1));
		}
	}
	
	public static int permutationCount(String sub, String given) {
		if(given.isEmpty()) {
			return 1;
		}
		int count = 0;
		char ch = given.charAt(0);
		for(int i = 0; i <= sub.length(); i++) {
			String f = sub.substring(0, i);
			String e = sub.substring(i, sub.length());
			String p = f + ch + e;
			count = count + permutationCount(p, given.substring(1));
		}
		return count;
	}

}
