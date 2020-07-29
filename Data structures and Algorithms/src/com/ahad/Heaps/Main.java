package com.ahad.Heaps;

public class Main {

	public static void main(String[] args) {
		
		MaxHeap heap = new MaxHeap(10);
		
		heap.insert(30);
		heap.insert(33);
		heap.insert(45);
		heap.insert(36);
		heap.insert(42);
		heap.insert(90);
		heap.insert(39);
		heap.insert(99);
		
//		heap.sort();
		
		heap.printHeap();
		
		heap.sort();
		heap.printHeap();
		
//		System.out.println(heap.peek());
//		
//		heap.delete(2);
//		heap.printHeap();
		

	}

}
