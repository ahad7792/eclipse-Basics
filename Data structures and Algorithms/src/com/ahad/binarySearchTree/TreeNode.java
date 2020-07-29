package com.ahad.binarySearchTree;

public class TreeNode {
	
	public int data;
	public TreeNode rightNode;
	public TreeNode leftNode;
	
	public void insert(int value) {
		if (value == data) {
			return;
		}
		if (value < data) {
			if (leftNode == null) {
				leftNode = new TreeNode(value);
			}
			else {
				leftNode.insert(value);
			}
		}
		else {
			if (rightNode == null) {
				rightNode = new TreeNode(value);
			}
			else {
				rightNode.insert(value);
			}
		}
	}
	
	public void traverseInOrder() {
		
		if (leftNode != null) {
			leftNode.traverseInOrder();
		}
		
		System.out.println(data);
		
		if (rightNode != null) {
			rightNode.traverseInOrder();
		}
	}
	
	public void traversePreOrder() {
		
		System.out.println(data);
		
		if (leftNode != null) {
			leftNode.traversePreOrder();
		}
		
		if (rightNode != null) {
			rightNode.traversePreOrder();
		}
	}
	
	
	public TreeNode get(int value) {
		if (data == value) {
			return this;
		}
		if (data > value) {
			if (leftNode != null) {
				return leftNode.get(value);
			}
		}
		else {
			if (rightNode != null) {
				return rightNode.get(value);
			}
		}
		return null;
	}
	
	public int min() {
		if (leftNode == null) {
			return data;
		}
		else {
			return leftNode.min();
		}
	}
	
	public int max() {
		if (rightNode == null) {
			return data;
		}
		else {
			return rightNode.max();
		}
	}
	
	public TreeNode(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public TreeNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}
	public TreeNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	
	

}
