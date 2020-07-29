package com.ahad;

public class SelectionSort {

	public static void main(String[] args) {
		
		int[] intArray = {10, 9, -30, 40, 25, 60, -17, 18, 27};
		
		for(int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0 ; lastUnsortedIndex--) {
			int largest = 0;
			
			for(int i = 1 ; i <= lastUnsortedIndex ; i++) {
				if(intArray[largest] < intArray[i] ) {
				
					largest = i;
					
				}
				
			}
			swap (intArray, largest, lastUnsortedIndex);
		}
		
		for(int i = 0 ; i < intArray.length ; i++) {
			System.out.println(intArray[i]);
		}

	}
	
	public static void swap(int[] array , int i, int j){
		
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		
		
	}

}
