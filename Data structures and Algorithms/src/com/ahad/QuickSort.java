package com.ahad;

public class QuickSort {
	
	public static void quickSort(int[] arr, int low, int high) {
		
		int index = partition (arr, low, high);
		
	    
	    if (low < index -1) {
	    	quickSort(arr, low, index - 1);
	    }
	    if (high > index) {
	    	quickSort(arr, index, high);
	    }
	}

    public static int partition (int[] arr, int low, int high) {
    	
    	int mid = (low + high)/2;
		int i = low;
		int j = high;
	    int pivot = arr[mid];
		
	    
	    while(i <= j) {
	    
	    while (arr[i] < pivot) {
	    	i++;
	    }
	    while (arr[j] > pivot) {
	    	j--;
	    }
	    if(i <= j) {
	    	int temp = arr[i];
	    	arr[i] = arr[j];
	    	arr[j] = temp;
	    	
	    	i++;
	    	j--;
	    	
	    }
    	
    }
	    return i;
    }    


	public static void main(String[] args) {
		
		int[] intArray = {10, -193, -99, 200, 39, 45, 858, 56, 3};
		
		quickSort(intArray, 0 , intArray.length - 1);
		
		for(int i = 0 ; i < intArray.length ; i++) {
			System.out.println(intArray[i]);
		}


	}

}
