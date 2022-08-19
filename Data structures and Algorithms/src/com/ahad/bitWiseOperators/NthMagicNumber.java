package com.ahad.bitWiseOperators;

public class NthMagicNumber {

	public static void main(String[] args) {
		
		nthMagic(3);

	}

	static void nthMagic(int n) {
		int base = 5;
		int ans = 0;
		while (n > 0) {

			if ((n & 1) != 0) {
				ans = ans + base;
			}
			
			base = base * base;
			n = n>>1; //removing one bit digit at the end
		}
		
		System.out.println(ans);
	}

}
