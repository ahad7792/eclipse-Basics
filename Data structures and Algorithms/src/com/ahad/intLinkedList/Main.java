package com.ahad.intLinkedList;


public class Main {

	public static void main(String[] args) {

         LinkedList list = new LinkedList();
         
         list.insert(5);
         list.insert(3);
         list.insert(18);
         
         //list.show();
         
         list.insertAt(2, 6);
         
         list.deleteAt(0);
         
         list.show();
         

	}

}
