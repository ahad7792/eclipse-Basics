package com.ahad;

public class CountingSort {

	public static void main(String[] args) {
		
		int[] intArray = {2, 5, 7, 6, 3, 3, 3, 9, 8, 2, 4};

        countingSort(intArray , 1, 10);
		
		for(int i = 0 ; i < intArray.length ; i++) {
			System.out.println(intArray[i]);
		}

	}
	
	public static void countingSort(int[] input, int min , int max) {
		
		int[] countArray = new int[input.length];
		
		for(int i = 0 ; i < input.length; i++) {
			countArray[input[i] - min]++;
		}
		
		int j = 0;
		for(int i = min ; i <= max ; i++) {
			while (countArray[i - min] > 0) {
				input[j++] = i;
				countArray[i - min]--;
			}
		}
	}

}
