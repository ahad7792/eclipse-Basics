package com.ahad.maths;

public class Newtonsqrt {
	
	public static void main(String[] args) {
		double ans = sqrt(40);
		System.out.println(ans);
	}
	
	public static double sqrt(int n) {
		double x = n;
		double root;
		while(true) {
			root = 0.5 * (x + (n/x));
			
			if (Math.abs(root - x) < 0.5) {
				break;
			}
			x = root;
		}
		return root;
	}

}
