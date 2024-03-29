package com.ahad.leetcode;

public class MaximumPathSum {

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

	int ans;

	public int maxPathSum(TreeNode root) {

		ans = Integer.MIN_VALUE;

		solve(root);

		return ans;

	}

	private int solve(TreeNode root) {

		if (root == null)
			return 0;

		int l = solve(root.left);
		int r = solve(root.right);

		int takeSubTree = l + r + root.val;
		int takeOneSide = Math.max(l, r) + root.val;
		int takeOnlyRoot = root.val;

		ans = Math.max(Math.max(takeOneSide, takeOnlyRoot), Math.max(ans, takeSubTree));

		return Math.max(takeOnlyRoot, takeOneSide);

	}

}
