package com.ahad.bitWiseOperators;

public class Power {
	
	public static void main(String[] args) {
		power(2, 3);
	}
	
	static void power(int n, int power) {
		int ans = 1;
		int base = n;
		
		while(power > 0) {
			if((power & 1) != 0) {
				ans = ans * base;
			}
			
			base = base * base;
			power = power >> 1;
		}
		
		System.out.println(ans);
	}

}
