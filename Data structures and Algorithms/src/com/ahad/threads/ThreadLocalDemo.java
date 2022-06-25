package com.ahad.threads;

class ParentThred extends Thread{
	public static InheritableThreadLocal tL = new InheritableThreadLocal() {
		public Object childValue(Object p) { // overriding child value method
			return "CC";
		}
	};
	
	public void run() {
		tL.set("PP");
		System.out.println("Parent Thread value--" + tL.get());
		ChildThread ct = new ChildThread();
		ct.start();
	}
}

class ChildThread extends Thread{
	public void run() {
		System.out.println("Child Thread value--" + ParentThred.tL.get());
	}
}

public class ThreadLocalDemo {
	
	public static void main(String[] args) {
		ParentThred pt = new ParentThred();
		pt.start();
	}

}
