package com.ahad.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class MyThread extends Thread{
	static ReentrantLock l = new ReentrantLock();
	
	public MyThread(String name) {
		super(name);
	}
	
	public void run() {
		do {
			try {
				if(l.tryLock(5000, TimeUnit.MILLISECONDS)) {
					System.out.println(Thread.currentThread().getName() + ".....got lock");
					
					Thread.sleep(30000);
					
					l.unlock();
					
					System.out.println(Thread.currentThread().getName() + ".....releases lock");
					break;
				}else {
					System.out.println(Thread.currentThread().getName() + ".....unable to get lock and will try again");
				}
			} catch (Exception e) {}
		}while(true);
	}
}

public class ReentrantLockDemo {
	
	public static void main(String[] args) {
		MyThread t1 = new MyThread("First Thread");
		MyThread t2 = new MyThread("Second Thread");
		t1.start();
		t2.start();
	}

}
