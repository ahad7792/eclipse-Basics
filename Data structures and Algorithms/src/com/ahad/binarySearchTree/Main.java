package com.ahad.binarySearchTree;

public class Main {

	public static void main(String[] args) {
		
		Tree intTree = new Tree();
		//intTree.insert(36);
		intTree.insert(18);
		intTree.insert(27);
		intTree.insert(15);
		intTree.insert(33);
		intTree.insert(3);
		intTree.insert(9);
		intTree.insert(36);
		
		intTree.traverseInOrder();
		
//		
//		System.out.println(intTree.get(15));
//		
//		System.out.println(intTree.max());
//		System.out.println(intTree.min());
//		
		System.out.println("---------------------------");
//		intTree.delete(15);
//		intTree.traverseInOrder();
		
		intTree.traversePreOrder();
	}

}
