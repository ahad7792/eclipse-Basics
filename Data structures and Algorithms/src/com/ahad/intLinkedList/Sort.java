package com.ahad.intLinkedList;

public class Sort {
	
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode mid = getMid(head);
		ListNode left = sortList(head);
		ListNode right = sortList(mid);
		
		return mergeTwoLists(left, right);
	}
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ansHead = new ListNode();
        ListNode ansTail = ansHead;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                ansTail.next = list1;
                list1 = list1.next;
                ansTail = ansTail.next;
            }else {
                ansTail.next = list2;
                list2 = list2.next;
                ansTail = ansTail.next;
            }
        }
        if(list1 != null){
            ansTail.next = list1;
            list1 = list1.next;
        }
        if(list2 != null){
            ansTail.next = list2;
            list2 = list2.next;
        }
        return ansHead.next; //because initially head is pointing to the null, that's why if just return head list starts with 0
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
	

}
