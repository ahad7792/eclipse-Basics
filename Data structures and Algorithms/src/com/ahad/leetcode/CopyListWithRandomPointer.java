package com.ahad.leetcode;

import java.util.HashMap;

public class CopyListWithRandomPointer {

	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}

		public Node(int val2, Node next2, Node random2) {
			this.val = val2;
			this.next = next2;
			this.random = random2;
		}
	}

	public Node copyRandomList(Node head) {

		if (head == null)
			return null;

		HashMap<Node, Node> map = new HashMap<>();

		Node currNode = head;

		while (currNode != null) {
			map.put(currNode, new Node(currNode.val)); // head will be in at first
			// putting the value of the map as a new Node with current node value
			currNode = currNode.next;
		}

		for (Node keyNode : map.keySet()) {
			Node newNode = map.get(keyNode);
			newNode.next = map.get(keyNode.next);
			newNode.random = map.get(keyNode.random);
		}

		return map.get(head); // returning the node that has key as the given head

	}

	public Node copyRandomList2(Node head) {

		if (head == null)
			return null;

		Node temp = head;
		
		while(temp != null) {
			Node next = temp.next;
			Node random = temp.random;
			temp.next = new Node(temp.val, next, random);
			temp = temp.next.next;
		}
		
		//update random pointers
		temp = head;
		Node newHeadNode = temp.next;
		while(temp != null) {
			Node next = temp.next;
			if(temp.random != null) next.random = temp.random.next;
			temp = temp.next.next;
		}
		
		//unwinding the list
		temp = head;
		while(temp != null) {
			Node copyNode = temp.next;
			temp.next = copyNode.next;
			if(copyNode.next !=null) copyNode.next = temp.next.next;
			temp = temp.next;
		}
		
		return newHeadNode;

	}

}
