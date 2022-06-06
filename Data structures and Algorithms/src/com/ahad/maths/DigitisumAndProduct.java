package com.ahad.maths;

public class DigitisumAndProduct {

	public static void main(String[] args) {
		
		int ans = sum(1342);
		int ans2 = product(1342);
		System.out.println(ans);
		System.out.println(ans2);

	}
	
	public static int sum(int n) {
		if (n == 0) {
			return 0;
		}
		
		return n%10 + sum(n/10);
	}
	
	public static int product(int n) {
		if (n%10 == n) {
			return n;
		}
		
		return n%10 * product(n/10);
	}

}
