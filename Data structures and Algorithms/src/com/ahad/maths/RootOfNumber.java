package com.ahad.maths;

import java.util.Scanner;

public class RootOfNumber {
	//Taking O(logN) time
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		double ans = 0;
		
		int start = 0;
		int end = n;
		while(start <= end) {
				int mid = start + (end - start) / 2;
			if (mid*mid == n) {
				ans = mid;
				break;
			}else if (mid*mid > n) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		
		double incr = 0.1;
		for (int i = 0; i < 3; i++) {
			while (ans * ans <= n) {
				ans = ans + incr;
			}
			ans -= incr;
			incr = incr / 10;
		}
		System.out.println(ans);
	}

}
