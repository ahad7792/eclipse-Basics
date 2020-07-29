package com.ahad.queues;

public class Main {

	public static void main(String[] args) {
		
		Employee kazimZim = new Employee("Kazim", "Zim", 48);
		Employee anamTorun = new Employee("Anam", "Torun", 12);
		Employee hossainNoyon = new Employee("Hossain", "Noyon", 01);
		Employee pollob = new Employee("Nazmul", "Haque", 42);
		
		ArrayQueue queue = new ArrayQueue(3);
		queue.add(kazimZim);
		queue.add(pollob);
		queue.remove();
		queue.add(anamTorun);
		queue.remove();
		queue.add(hossainNoyon);
		queue.printQueue();
		System.out.println(queue.size());

	}

}
