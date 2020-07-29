package com.ahad;

public class RecursiveInsertionSort {

	public static void main(String[] args) {
		
		int[] intArray = {10, -193, -99, 200, 39, 45, 858, 56, 3};
		
		insertionSort(intArray, intArray.length);
		
		for(int i = 0 ; i < intArray.length ; i++) {
			System.out.println(intArray[i]);
		}

	}
	
	public static void insertionSort(int[] input, int numItems) {
		
		if(numItems < 2) {
			return;
		}
			
		insertionSort(input, numItems - 1);
		
		    int newElement = input[numItems - 1];
			int i;
			
			for(i = numItems - 1 ; i > 0 && input[i-1] > newElement; i--) {
				
				input[i] = input[i-1];
			}
			
			input[i] = newElement;
			
			System.out.println("Results of call when numItems: " + numItems);
			for(i = 0; i < input.length; i++) {
				System.out.print(input[i] + ", ");
			}
			
			System.out.println("");
			System.out.println("-------------------");
			
		}			

}
