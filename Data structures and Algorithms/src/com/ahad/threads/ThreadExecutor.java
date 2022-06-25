package com.ahad.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintJob implements Runnable{
	String name;
	public PrintJob(String name) {
		this.name = name;
	}
	
	public void run() {
		System.out.println(name + "...Job Started by Thread" + Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		}catch (InterruptedException e) {}
		System.out.println(name + "...Job Completed by Threads" + Thread.currentThread().getName());
	}
}

public class ThreadExecutor {
	
	public static void main(String[] args) {
		PrintJob[] jobs = {
				new PrintJob("Ahad"),
				new PrintJob("Masum"),
				new PrintJob("Fahim"),
				new PrintJob("Dip"),
				new PrintJob("Torun"),
				new PrintJob("Raj")
		};
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(PrintJob job : jobs) {
			service.submit(job);
		}
		service.shutdown();
	}

}
