package com.ahad.maths;

public class LCMandGCD {
	
	public static void main(String[] args) {
		System.out.println(gcd(8, 12));
		System.out.println(lcm(8, 12));;
	}
	
	public static int gcd(int a, int b) {
		
		if(a == 0) {
			return b;
		}
		
		return gcd(b%a, a);
	}
	
	public static int lcm(int a,int b) {
		return a * b / gcd(a, b);
	}

}
