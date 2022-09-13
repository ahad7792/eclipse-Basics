package com.ahad.leetcode;

public class HouseRobber3 {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static int rob(TreeNode root) {
		
		int[] rootEI = helper(root);
		return Math.max(rootEI[0], rootEI[1]);

	}

	private static int[] helper(TreeNode root) {
		if(root == null) {
			int[] EI = {0, 0};
			return EI;
		}
		
		int[] left = helper(root.left);
		int[] right = helper(root.right);
		
		int include = root.val + left[1] + right[1];
		int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		
		int[] ans = new int[2];
		ans[0] = include;
		ans[1] = exclude;
		return ans;
	}
}
