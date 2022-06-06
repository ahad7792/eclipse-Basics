package com.ahad.arrayRecursion;

import java.util.ArrayList;

public class Search {
	
	public static void main(String[] args) {
		int[] arr = {2, 4, 5, 7, 9, 9, 10};
		System.out.println(search(arr, 9, 0));
		ArrayList<Integer> ans = new ArrayList<>();
		System.out.println(searchMultiple(arr, 9, 0, ans));
	}
	
	public static int search(int[] arr,int target, int index) {
		if(index == arr.length) {
			return -1;
		}
		if(arr[index] == target) {
			return index;
		}else {
			return search(arr, target, index + 1);
		}
	}
	
	public static ArrayList<Integer> searchMultiple(int[] arr, int target, int index, 
				  									ArrayList<Integer> ans){
		if(index == arr.length) {
			return null;
		}
		if(arr[index] == target) {
			ans.add(index);
		}
		searchMultiple(arr, target, index + 1, ans);
		return ans;
		
	}

}
