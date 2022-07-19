package com.ahad.leetcode;

public class RemoveNthNodeFromEnd {
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		//two pointer solution
		//first copy the head in a dummy head
		ListNode dummyHead = new ListNode();
		dummyHead.next = head;
		//in case we need to remove the head
		
		//now initialize two pointer to the head
		ListNode firstNode = dummyHead;
		ListNode secondNode = dummyHead;
		
		for(int i = 1; i <= n + 1; i++) {
			firstNode = firstNode.next;
			//sending the firstNode to the given nth from the head that was supposed to be from end
		}
		
		while(firstNode != null) {
			firstNode = firstNode.next; //sending the firstNode to the last skipping remaining n nodes
			secondNode = secondNode.next; //second node is now positioned at (size of list - n + 1)th node
		}
		
		secondNode.next = secondNode.next.next;
		
		return dummyHead.next;

	}

}
