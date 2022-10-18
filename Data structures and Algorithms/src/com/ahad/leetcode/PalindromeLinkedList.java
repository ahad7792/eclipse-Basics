package com.ahad.leetcode;

public class PalindromeLinkedList {

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

	ListNode getMid(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode reverseList(ListNode head) {

		if (head == null) {
			return head;
		}

		ListNode prev = null;
		ListNode present = head;
		ListNode next = head.next;

		while (present != null) {
			present.next = prev;
			prev = present;
			present = next;
			if (next != null) {
				next = next.next;
			}
		}
		return prev;
	}

	public boolean isPalindrome(ListNode head) {
		ListNode mid = getMid(head);
		ListNode headSecond = reverseList(mid); // gonna return the head of the reversed second half list
		ListNode reReverseHead = headSecond;

		// compare both the value
		while (headSecond != null) {
			if (head.val != headSecond.val) {
				return false;
			}
			head = head.next;
			headSecond = headSecond.next;
		}

		return true;
	}

}
