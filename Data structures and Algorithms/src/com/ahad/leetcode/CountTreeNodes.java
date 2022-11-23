package com.ahad.leetcode;

public class CountTreeNodes {
	
	public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.right == null)
            return 1 + countNodes(root.left);
        if (root.left == null)
            return 1 + countNodes(root.right);
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
