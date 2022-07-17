package com.ahad.leetcode;

public class FlattenBinaryTree {
	
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
	
	public void flatten(TreeNode root) {
		
		if(root == null) return;
		
		TreeNode tempLeft = root.left;
		TreeNode tempRight = root.right;
		
		flatten(root.left);
		flatten(root.right);
		
		root.left = null;
		root.right = tempLeft;
		TreeNode currNode = root;
		while(currNode.right != null) {
			currNode = currNode.right;
		}
		currNode.right = tempRight;
		

	}
	
	public void flattenMorris(TreeNode root) {
		if(root == null) return;
		
		while(root != null) {
			if(root.left != null) {
				TreeNode left = root.left;
				TreeNode currNode = left;
				while(currNode.right != null) {
					currNode = currNode.right;
				}
				currNode.right = root.right; //main MorrisTraversal step
				root.left = null;
				root.right = left;
			}
			root = root.right;
		}
		
	}

}
