package com.ahad.arrayRecursion;

import java.util.ArrayList;

public class Search {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 5, 7, 9, 9, 10 };
		System.out.println(search(arr, 9, 0));
		ArrayList<Integer> ans = new ArrayList<>();
		System.out.println(searchMultiple(arr, 9, 0, ans));
		System.out.println(searchMultipleIndex(arr, 9, 0));
	}

	public static int search(int[] arr, int target, int index) {
		if (index == arr.length) {
			return -1;
		}
		if (arr[index] == target) {
			return index;
		} else {
			return search(arr, target, index + 1);
		}
	}

	public static ArrayList<Integer> searchMultiple(int[] arr, int target, int index, ArrayList<Integer> ans) {
		if (index == arr.length) {
			return ans;
		}
		if (arr[index] == target) {
			ans.add(index);
		}
		return searchMultiple(arr, target, index + 1, ans);

	}

	
	  public static ArrayList<Integer> searchMultipleIndex(int[] arr, int target, int index){
	  
		  ArrayList<Integer> ans = new ArrayList<>();
		  if (index == arr.length) {
			  return ans; 
		  }
		  if(arr[index] == target) {
			  ans.add(index);
		  }
		  ArrayList<Integer> ansFromBelowCalls = searchMultipleIndex(arr, target, index + 1);
		  ans.addAll(ansFromBelowCalls);
		  return ans;
	  }
	 

}
