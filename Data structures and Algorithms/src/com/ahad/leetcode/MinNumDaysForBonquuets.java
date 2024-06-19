package com.ahad.leetcode;

public class MinNumDaysForBonquuets {

	public static void main(String[] args) {
		int[] arr = {1,10,3,10,2};
		System.out.println(minDays(arr, 3, 1));
	}

	public static int minDays(int[] bloomDay, int m, int k) {
        int left = 0;
        int right = 0;
        int ans = -1;
        for (int i = 0; i < bloomDay.length; i++) {
            right = Math.max(bloomDay[i], right);
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            int adjacentDays = 0;
            int bouquets = 0;
            for (int i = 0; i < bloomDay.length; i++) {
                if(bloomDay[i] <= mid) {
                    adjacentDays++;
                    if(adjacentDays == k) {
                        bouquets++;
                        adjacentDays = 0;
                    }
                } else {
                    adjacentDays = 0;
                }
            }

            if (bouquets >= m) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
