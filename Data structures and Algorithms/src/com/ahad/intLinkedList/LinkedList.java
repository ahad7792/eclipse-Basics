package com.ahad.intLinkedList;

public class LinkedList {
	
	private static Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;
    }

    // insert using recursion
    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }
    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index-1, node.next);
        return node;
    }


    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.value;

        prev.next = prev.next.next;
        size--;
        return val;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // https://leetcode.com/problems/remove-duplicates-from-sorted-list
    public void duplicates() {
        Node node = head;

        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }
    
 // https://leetcode.com/problems/merge-two-sorted-lists/submissions/
    public static LinkedList merge(LinkedList first, LinkedList second) {
        Node f = first.head;
        Node s = second.head;

        LinkedList ans = new LinkedList();

        while (f != null && s != null) {
            if (f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }

        return ans;
    }

    public void bubbleSort() {
    	bubbleSort(size - 1, 0);
    }

	private void bubbleSort(int row, int col) {
		
		if(row == 0) {
			return;
		}
		
		if(col < row) {
			Node first = get(col);
			Node second = get(col + 1);
			if(first.value > second.value) {
				//swap
				if(first == head) {
					head = second;
					first.next = second.next;
					second.next = first;
				} else if(second == tail) {
					Node prev = get(col - 1);
					prev.next = second;
					tail = first;
					first.next = null;
					second.next = tail;
				} else {
					Node prev = get(col - 1);
					prev.next = second;
					first.next = second.next;
					second.next = first;
				}
			}
			bubbleSort(row, col + 1);
		}
		bubbleSort(row - 1, 0);
		
	}
	
	private void reverseRecursion(Node node) {
		if(node.next == null) {
			head = tail;
			return;
		}
		
		reverseRecursion(node.next);
		tail.next = node;
		tail = node;
		tail.next = null;
	}
	
	public Node threePointersReverseList(Node head) {
        
		Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
	
	
	
	public static void main(String[] args) {
		LinkedList first = new LinkedList();
		LinkedList second = new LinkedList();

        first.insertLast(1);
        first.insertLast(3);
        first.insertLast(5);

        second.insertLast(1);
        second.insertLast(2);
        second.insertLast(9);
        second.insertLast(14);

        LinkedList ans = LinkedList.merge(first, second);
        ans.display(head);

        LinkedList list = new LinkedList();
        for (int i = 7; i > 0; i--) {
            list.insertLast(i);
        }
        list.display(head);
        list.bubbleSort();
        list.display(head);
        
        Node node = list.get(0);
        list.reverseRecursion(node);
        list.display(head);
        
       
        
        list.display(list.threePointersReverseList(node));

    }
}
