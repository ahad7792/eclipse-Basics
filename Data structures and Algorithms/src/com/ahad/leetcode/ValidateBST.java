package com.ahad.leetcode;

public class ValidateBST {

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

	public boolean isValidBST(TreeNode root) {

		return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);

	}

	private boolean validate(TreeNode root, Long minValue, Long maxValue) {
		if (root == null)
			return true;
		if (root.val <= minValue || root.val >= maxValue)
			return false;

		return validate(root.left, minValue, (long) root.val) && 
				validate(root.right, (long) root.val, maxValue);

	}

}
