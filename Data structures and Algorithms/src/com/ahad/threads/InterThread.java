package com.ahad.threads;

class Q{
	int num;
	boolean isSet = false;
	
	public synchronized void put(int num) {
		while(isSet) {
			try { wait(); } catch(Exception e) {}
		}
		this.num = num;
		System.out.println("Thread " + Thread.currentThread().getName() + " producing " + num + " unit");
		isSet = true;
		notify();
	}
	public synchronized void get() {
		while(!isSet) {
			try { wait(); } catch(Exception e) {}
		}
		isSet = false;
		System.out.println("Thread " + Thread.currentThread().getName() + " consuming " + num + " unit");
		notify();
//		return num;
	}
}

class Producer implements Runnable{
	Q q;
	
	public Producer(Q q) {
		this.q = q;
		Thread t = new Thread(this, "Producer");
		t.start();
	}
	
	public void run() {
		int i = 0;
		for(int j = 0; j < 30; j++) {
//		while(true) {
			q.put(i++);
//			i++;
//			System.out.println("Thread " + Thread.currentThread().getName() + " producing " + i + " unit");
			try {
				Thread.sleep(500);
			}catch (Exception e) {}
		}
	}
}

class Consumer implements Runnable{
	Q q;
	public Consumer(Q q) {
		this.q = q;
		Thread t = new Thread(this, "Consumer");
		t.start();
	}
	
	public void run() {
		for(int j = 0; j < 30; j++) {
//		while(true) {
			q.get();
//			System.out.println("Thread " + Thread.currentThread().getName() + " consuming " + i + " unit");
			try {
				Thread.sleep(5000);
			}catch (Exception e) {}
		}
	}
}

public class InterThread {
	
	public static void main(String[] args) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
	}
	
}
