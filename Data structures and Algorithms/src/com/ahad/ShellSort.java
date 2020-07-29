package com.ahad;

public class ShellSort {

	public static void main(String[] args) {
		
		int[] intArray = {24, 45, 56, 4, -3, -4, 2, 5, 3, 78, 9};
		
		for (int gap = intArray.length/2 ; gap > 0 ; gap/=2 ) {
			
			for(int i = gap ; i < intArray.length ; i++) {
				
				int newElement = intArray[i];
				int j = i;
				
				while(j >= gap && intArray[j-gap] > newElement) {
					
					intArray[j] = intArray[j - gap];
					
					j -= gap;
					
				}
				
				intArray[j] = newElement;
			}
		}
		
		
		for(int i = 0 ; i < intArray.length ; i++) {
			System.out.println(intArray[i]);
		}


	}

}
