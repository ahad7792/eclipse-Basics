package com.ahad.leetcode;

public class AddTwoNumbers {

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

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode dummyNode = new ListNode();
		ListNode x = l1, y = l2, curr = dummyNode;
		int carry = 0;
		
		while(x != null || y != null) {
			int p = 0, q = 0;
			if (x != null) p = x.val;
			if (y != null) q = y.val;
			int sum = p + q + carry;
			carry = sum/10;
			
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			
			if(x != null) x = x.next;
			if(y != null) y = y.next;
			
		}
		
		if(carry > 0) {
			curr.next = new ListNode(carry);
		}
		
		return dummyNode.next;

	}

}
