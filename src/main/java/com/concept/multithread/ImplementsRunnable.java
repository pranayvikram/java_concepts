package com.concept.multithread;


public class ImplementsRunnable implements Runnable {

	private Thread threadObject;
	private String threadName;

	protected Thread getThreadObject() {
		return this.threadObject;
	}
	
	protected ImplementsRunnable( String name) {
		threadName = name;
		System.out.println("Creating " +  threadName);
	}
	
	@Override
	public void run() {
		
		System.out.println("Running : " +  threadName);
		
		try {
			for(int i = 1; i < 5; i++) {
				
				System.out.println("Thread : " + threadName + ", loop count: " + i);
				
				// Let the threadObject sleep for one second
				Thread.sleep(1000);
			}
		}
		catch (InterruptedException e) {
			System.out.println("Thread " +  threadName + " interrupted.");
		}
		System.out.println("Thread " +  threadName + " exiting.");
	}

	public void startThread () {
		
		System.out.println("Starting... " +  threadName);

		if (threadObject == null) {
			threadObject = new Thread (this, threadName);
			threadObject.start();
		}
	}
}