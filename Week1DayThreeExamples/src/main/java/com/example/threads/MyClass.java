package com.example.threads;

public class MyClass {

	public static void main(String[] args) throws InterruptedException {

		Thread worker = new FirstThreadExample();
		Thread developer = new Thread(new MyRunnable());
		
		worker.start();
		developer.start();
		//start vs run
		// run method will not create a separate thread
		// start will spawn a new thread each time
		
	
		//developer.sleep(10000);
		
		for(int i=0; i<20; i++) {
			System.out.println(Thread.currentThread().getName());
		}
		
		//daemon threads - never stops running in the background
		//garbage collector
		
	}

}
