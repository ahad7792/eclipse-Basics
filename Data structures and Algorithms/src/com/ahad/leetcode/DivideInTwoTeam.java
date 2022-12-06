package com.ahad.leetcode;

import java.util.Arrays;

public class DivideInTwoTeam {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 5, 1, 3, 4 };
		System.out.println(dividePlayers(arr));
	}

	public static long dividePlayers(int[] arr) {
		Arrays.sort(arr);
		int n = arr.length;
		int pair[][] = new int[n / 2][2];
		int beg = 0, end = n - 1;
		int i = 0;

		while (beg < end) {
			pair[i][0] = arr[beg];
			pair[i][1] = arr[end];
			beg++;
			end--;
			i++;
		}

		long product = 0;
		for (i = 0; i < pair.length - 1; i++) {
			int sum1 = pair[i][0] + pair[i][1];
			int sum2 = pair[i + 1][0] + pair[i + 1][1];
			if (sum1 != sum2)
				return -1L;
			product += pair[i][0] * pair[i][1];
		}

		product += pair[n / 2 - 1][0] * pair[n / 2 - 1][1];
		return product;
	}

}
