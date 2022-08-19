package com.ahad.leetcode;

public class SingleNumber2 {
	
	public static void main(String[] args) {
		int[] nums = {-2,-2,1,1,4,1,4,4,-4,-2};
		System.out.println(singleNumber2(nums));
		System.out.println(singleNumber(nums));
	}

	public static int singleNumber(int[] nums) {
		
		int ans = 0;
		for(int i = 0; i < 32; i++) {
			int ones = 0;
			int zeros = 0;
			
			for (int j = 0; j < nums.length; j++) {
				if((1 << i & nums[j]) != 0) {
					ones++;
				}else {
					zeros++;
				}
			}
			
			if(ones % 3 != 0) {
				ans = ans | (1 << i);
			}
			
		}
		
		return ans;

	}
	
	public static int singleNumber2(int[] nums) {
        int ans = 0, k = 3;
        for(int i=0;i<32;i++){
            
            int count = 0;
            int mask = (1<<i);
            for(int n:nums){
                if((n&mask)!=0) count++;
            }
            if(count%k!=0){
                ans |= (1<<i);
            }
        }
        return ans;
    }

}
