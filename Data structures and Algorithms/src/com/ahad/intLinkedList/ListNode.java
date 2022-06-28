package com.ahad.intLinkedList;

public class ListNode {
	
	
	int val;
	ListNode next;
	public ListNode(int i) {
		this.val = i;
	}
	public ListNode() {
		this.val = 0;
	}
	
	//Interview questions
	//Reverse a linked list ||
	
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if(left == right) {
			return null;
		}
		
		//skip the first left-1 nodes
		ListNode current = head;
		ListNode prev = null;
		for(int i = 0; i < left - 1 && current != null; i++) {
			prev = current;
			current = current.next;
		}
		
		ListNode last = prev;
		ListNode newEnd = current;
		
		//reverse between left and right
		ListNode next = current.next;
		for(int i = 0; current != null && i < right - left + 1; i++) {
			current.next = prev;
			prev = current;
			current = next;
			if(next != null) {
				next = next.next;
			}
		}
		
		if(last != null) {
			last.next = prev;
		} else {
			head = prev;
		}
		
		newEnd.next = current;
		return head;
	}
	
	ListNode getMid(ListNode head) { 
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public ListNode reverseList(ListNode head) {
        
        if(head == null){
            return head;
        }
        
        ListNode prev = null;
        ListNode present = head;
        ListNode next = head.next;
        
        while (present != null){
            present.next = prev;
            prev = present;
            present = next;
            if (next != null){
                next = next.next;
            }
        }
        return prev;
    }
	
	public boolean isPalindrome(ListNode head) {
		ListNode mid = getMid(head);
		ListNode headSecond = reverseList(mid); // gonna return the head of the reversed second half list
		ListNode reReverseHead = headSecond;
		
		//compare both the value
		while(headSecond != null) {
			if(head.val != headSecond.val) {
				break;
			}
			head = head.next;
			headSecond = headSecond.next;
		}
		reverseList(reReverseHead);
		
		if(headSecond == null) {
			return true;
		}
		return false;
	}
	
	public void reorderList(ListNode head) {
		if(head == null || head.next == null) {
        	return;
        }
        
        ListNode mid = getMid(head);
        ListNode hf = head;
		ListNode headSecond = reverseList(mid);
		
		while(headSecond != null && hf != null) {
			ListNode temp = hf.next;
			hf.next = headSecond;
            hf = temp;
            
            ListNode temp2 = headSecond.next;
            headSecond.next = temp;
            headSecond = temp2;
		}
        
        if (hf != null){
            hf.next = null;
        }
    }
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1 || head == null || head.next == null) {
			return head;
		}
		
		ListNode current = head;
		ListNode prev = null;
		
		int n=length(head)/k;
        boolean iterated = true;
		ListNode newHead = head;
        
		while(n != 0) {
			
			ListNode last = prev;
			ListNode newEnd = current;
		
			//reverse between left and right
			ListNode next = current.next;
			for(int i = 0; current != null && i < k; i++) {
				current.next = prev;
				prev = current;
				current = next;
				if(next != null) {
					next = next.next;
				}
			}
		
			if(last != null) {
				last.next = prev;
			} else {
				head = prev;
			}
		
			newEnd.next = current;
			if(iterated){
                newHead = prev;
            }
            iterated = false;
            
			prev = newEnd;
            
            
            n--;
		
		}
		return newHead;
	}
	
	public int length(ListNode node) // find the length of linkedlist to find out how many we have to reverse linked list
    {
        int l=0;
        while(node!=null)
        {
            l++;
            node=node.next;
        }
        return l;
    }
	
	public ListNode rotateRight(ListNode head, int k) {
		if(k <= 0|| head == null || head.next == null) {
			return head;
		}
		
		ListNode last = head;
		int length = 1;
		while(last.next != null) {
			last = last.next;
			length++;
		}
		
		last.next = head; // connected the last node to the first
		int rotations = k % length;
		int skip = length - rotations;
		
		ListNode newLast = head;
		for(int i = 0; i < skip - 1; i++) {
			newLast = newLast.next;
		}
		
		head = newLast.next;
		newLast.next = null;
		
		return head;
 	}
}














