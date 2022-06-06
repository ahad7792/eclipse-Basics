package com.ahad.maths;

import java.util.Scanner;

public class ReverseTheNumber {
	
	//my solution
	public static int reverseMy(int n, int factor) {
		if(n%10 == n) {
			return n;
		}
		return (n%10) * factor + reverseMy(n/10, factor/10);
	}
	
	//need to initialize sum earlier
	static int sum = 0;
	public static int reverse1(int n) {
		if(n == 0) {
			return sum;
		}
		int rem = n%10;
		sum = sum * 10 + rem;
		return reverse1(n/10);
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n = scanner.nextInt();
		System.out.println("Enter the number of digits in your number");
		int digits = scanner.nextInt();
		int factor = (int) Math.pow(10, digits - 1);
		System.out.println("Reversed number: " + reverseMy(n, factor));
		System.out.println(reverse1(n));
		
	}

}
