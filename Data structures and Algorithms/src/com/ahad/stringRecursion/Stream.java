package com.ahad.stringRecursion;

public class Stream {
	
	public static void main(String[] args) {
		String str = "babappleappd";
		skip("", str);
		System.out.println(skipApple(str));
		System.out.println(skipAppIfNotApple(str));
	}
	
	public static void skip(String ans, String given) {
		if(given.isEmpty()) {
			System.out.println(ans);
			return;
		}
		char ch = given.charAt(0);
		if(ch == 'a') {
			skip(ans, given.substring(1));
		} else {
			ans = ans + ch;
			skip(ans, given.substring(1));
		}
	}
	
	public static String skipApple(String given) {
		if(given.isEmpty()) {
			return "";
		}
		char ch = given.charAt(0);
		if(given.startsWith("apple")) {
			return skipApple(given.substring(5));
		} else {
			return ch + skipApple(given.substring(1));
		}
	}
	
	public static String skipAppIfNotApple(String given) {
		if(given.isEmpty()) {
			return "";
		}
		char ch = given.charAt(0);
		if(given.startsWith("app") && !given.startsWith("apple")) {
			return skipAppIfNotApple(given.substring(3));
		} else {
			return ch + skipAppIfNotApple(given.substring(1));
		}
	}

}
