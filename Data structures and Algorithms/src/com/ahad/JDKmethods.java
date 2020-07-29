package com.ahad;

import java.util.Arrays;

public class JDKmethods {

	public static void main(String[] args) {
		
		int[] intArray = {24, 45, 56, 4, -3, -4, 2, 5, 3, 78, 9};
		
		Arrays.parallelSort(intArray);

		for(int i = 0 ; i < intArray.length ; i++) {
			System.out.println(intArray[i]);
		}

	}

}
