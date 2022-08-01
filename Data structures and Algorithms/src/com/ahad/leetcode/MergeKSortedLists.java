package com.ahad.leetcode;

public class MergeKSortedLists {

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

	public ListNode mergeKLists(ListNode[] lists) {
		
		if(lists == null || lists.length < 1) {
			return null;
		}
		
		int start = 0;
		int end = lists.length - 1;
		
		return helperDivider(lists, start, end);

	}

	private ListNode helperDivider(ListNode[] lists, int start, int end) {
		
		if(start == end) {
			return lists[start];
		}
		int mid = start + (end - start) / 2;
		ListNode left = helperDivider(lists, start, mid);
		ListNode right = helperDivider(lists, mid + 1, end);
		
		return mergeTwoSortedLists(left, right);
	}

	private ListNode mergeTwoSortedLists(ListNode left, ListNode right) {
		
		ListNode dummyListNode = new ListNode();
		ListNode temp = dummyListNode;
		
		while(left != null && right != null) {
			if(left.val < right.val) {
				temp.next = left;
				left = left.next;
				temp = temp.next;
			} else {
				temp.next = right;
				right = right.next;
				temp = temp.next;
			}
		}
		//just need to connect the remaining part of any list
		if(left != null) {
			temp.next = left;
			left = left.next;
		}
		if(right != null) {
			temp.next = right;
			right = right.next;
		}
		return dummyListNode.next;
	}
	

}
