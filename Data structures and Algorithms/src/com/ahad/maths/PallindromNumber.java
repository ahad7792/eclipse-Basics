package com.ahad.maths;

public class PallindromNumber {
	
	public static void main(String[] args) {
		//System.out.println(reverse(12121));
		System.out.println(pallindrom(12121));
	}
	
	public static boolean pallindrom(int n) {
		return n == reverse(n);
	}

	public static int reverse(int n) {
		int digits = (int) (Math.log10(n)) + 1;
		int factor = (int) Math.pow(10, digits - 1);
		return helper(n, factor);
	}
	
	public static int helper(int n, int factor) {
		if(n%10 == n) {
			return n;
		}
		return (n%10) * factor + helper(n/10, factor/10);
	}
}
