package com.ahad.singlylinkedlists;

public class Main {

	public static void main(String[] args) {
		
		Employee kazimZim = new Employee("Kazim", "Zim", 48);
		Employee anamTorun = new Employee("Anam", "Torun", 12);
		Employee hossainNoyon = new Employee("Hossain", "Noyon", 01);
		
		EmployeeLinkedList list = new EmployeeLinkedList();
		list.addToFront(kazimZim);
		list.addToFront(anamTorun);
		list.addToFront(hossainNoyon);
		
		list.printList();
		System.out.println(list.getSize());
		
		list.removeFromFront();
		list.printList();
		
		

	}

}
