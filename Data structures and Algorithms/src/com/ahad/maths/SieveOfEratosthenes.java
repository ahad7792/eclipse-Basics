package com.ahad.maths;
import java.util.Scanner;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Enter your number: ");
		n = sc.nextInt();
		sc.close();
		boolean[] b = new boolean[n];
		
		for(int a = 0; a < n; a++) {
			b[a] = true;
		}
		
		for(int i = 2; i <= n; i++) {
			
			if(b[i - 1]) {
				System.out.println(i);
			}
			
			for(int j = i*i; j < n; j += i) {
				b[j - 1] = false;
			}
			
		}

	}

}
