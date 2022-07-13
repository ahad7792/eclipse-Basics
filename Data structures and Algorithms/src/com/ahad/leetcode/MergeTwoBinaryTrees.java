package com.ahad.leetcode;

import java.util.Stack;

public class MergeTwoBinaryTrees {

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

	public TreeNode mergeTreesRecursion(TreeNode root1, TreeNode root2) {

		if (root1 == null)
			return root2;
		if (root2 == null)
			return root1;
		root1.val += root2.val;
		root1.left = mergeTreesRecursion(root1.left, root2.left);
		root1.right = mergeTreesRecursion(root1.right, root2.right);
		return root1;

	}
	
	public TreeNode mergeTreesIterativeDFS(TreeNode leftTree, TreeNode rightTree) {
		
		if(leftTree == null) {
			return rightTree;
		}
		if(rightTree == null) {
			return leftTree;
		}
		
		Stack<TreeNode[]> stack = new Stack<>();
		
		stack.push(new TreeNode[] {leftTree, rightTree});
		
		while(!stack.isEmpty()) {
			TreeNode[] curr = stack.pop();
			
			//0 means left tree
			//1 means right tree
			curr[0].val += curr[1].val;
			
			if(curr[0].left == null) { //if leftTree doesn't have any left node
				curr[0].left = curr[1].left; //placing left node from the leftTree
			} else if(curr[1].left != null) {
				stack.push(new TreeNode[] {curr[0].left, curr[1].left});
			}
			
			if(curr[0].right == null) { //if leftTree does't have any right node
				curr[0].right = curr[1].right; //placing right node from the rightTree
			} else if(curr[1].right != null) {
				stack.push(new TreeNode[] {curr[0].right, curr[1].right});
			}
		}
		
		return leftTree;
	}
	
}


