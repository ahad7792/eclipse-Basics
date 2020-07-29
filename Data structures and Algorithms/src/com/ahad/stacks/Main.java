package com.ahad.stacks;

public class Main {

	public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(10);
        
        stack.push(new Employee("Hossain", "Noyon", 01));
        stack.push(new Employee("Asif", "Pavel", 32));
        stack.push(new Employee("Nazmul", "Haque", 42));
        
        stack.printStack();
        
        System.out.println(stack.peek());
        
        System.out.println("Popped: " + stack.pop());
        System.out.println(stack.peek());

	}

}
