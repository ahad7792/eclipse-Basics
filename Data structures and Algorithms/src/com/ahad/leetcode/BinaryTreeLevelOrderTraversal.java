package com.ahad.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	
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
	
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> currLevel = new ArrayList<>();
			while(size > 0) {
				TreeNode curr = queue.poll();
				currLevel.add(curr.val); //the nodes are adding with every time size reducing
				if(curr.left != null) queue.offer(curr.left);
				if(curr.right != null) queue.offer(curr.right);
				//end of every loop the queue will have the size of new level with new items
				size--;
			}
			result.add(currLevel); //while the level loop break the result list have all the level nodes
		}
		return result;
	}
	
	List<List<Integer>> resultList;
	public List<List<Integer>> levelOrderRecursion(TreeNode root){
		resultList = new ArrayList<>();
		if(root == null) {
			return resultList;
		}
		traverse(root, 0);
		return resultList;
	}
	
	private void traverse(TreeNode node, int level) {
		
		if(node == null) return;
		if(resultList.size() == level) { //at first size 0 and level 0
			//the arrayList will be created highest level time
			resultList.add(new ArrayList<>());
		}
		
		resultList.get(level).add(node.val); //adding the node value in resultList at level index
		traverse(node.left, level + 1);
		//when returning from the stack the right node is called with traverse with previous level
		traverse(node.right, level + 1);
		
	}

}
