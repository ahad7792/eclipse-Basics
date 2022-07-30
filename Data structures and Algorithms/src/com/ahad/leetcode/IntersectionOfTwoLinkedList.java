package com.ahad.leetcode;

public class IntersectionOfTwoLinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		int lengthA = 0;
		int lengthB = 0;
		
		ListNode dummyA = headA;
		ListNode dummyB = headB;
		
		while(dummyA != null) {
			dummyA = dummyA.next;
			lengthA++;
		}
		
		while(dummyB != null) {
			dummyB = dummyB.next;
			lengthB++;
		}
		
		int diff = Math.abs(lengthA - lengthB);
		
		if(lengthA > lengthB) {
			while(diff > 0) {
				headA = headA.next;
				diff--;
			}
		}
		
		while(diff > 0) {
			headB = headB.next;
			diff--;
		}
		
		while(headA != headB) {
			headA = headA.next;
			headB = headB.next;
			
			if(headA == null || headB == null) {
				return null;
			}
			
		}
		
		return headA;

	}

}
