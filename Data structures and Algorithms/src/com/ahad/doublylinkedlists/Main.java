package com.ahad.doublylinkedlists;

public class Main {

	public static void main(String[] args) {
		
		Employee kazimZim = new Employee("Kazim", "Zim", 48);
		Employee anamTorun = new Employee("Anam", "Torun", 12);
		Employee hossainNoyon = new Employee("Hossain", "Noyon", 01);
		Employee pollob = new Employee("Nazmul", "Haque", 42);
		
		EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
		list.addToFront(kazimZim);
		list.addToFront(anamTorun);
		list.addToFront(hossainNoyon);
		
		list.printList();
		
		Employee nazmul = new Employee("Nazmul", "Haque", 42);
		list.addToEnd(nazmul);
		
		list.printList();
		list.removeFromEnd();
		list.addBefore(pollob, anamTorun);
		list.printList();
		

	}

}
