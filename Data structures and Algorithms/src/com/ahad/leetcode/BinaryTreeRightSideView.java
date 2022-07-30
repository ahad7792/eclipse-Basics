package com.ahad.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

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
	
	List<Integer> ansList = new ArrayList<>();
	
	public List<Integer> rightSideViewRecursive(TreeNode root) {

		helper(root, 0);
		
		return ansList;

	}

	private void helper(TreeNode root, int level) {
		
		if(root == null) {
			return;
		}
		
		if(ansList.size() == level) {
			ansList.add(root.val);
		}
		
		helper(root.right, level + 1);
		helper(root.left, level + 1);
	}

	public List<Integer> rightSideView(TreeNode root) {
		
		List<Integer> ansList = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		
		if(root == null) return ansList;
		
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = size - 1; i >= 0; i++) {
				TreeNode currNode = queue.remove();
				if(i == 0) ansList.add(currNode.val);
				if(currNode.left != null) queue.add(currNode.left);
				if(currNode.right != null) queue.add(currNode.right);
			}
		}
		
		return ansList;

	}

}
