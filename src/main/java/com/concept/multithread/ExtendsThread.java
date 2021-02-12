package com.concept.multithread;

public class ExtendsThread extends Thread {

	private Thread threadObject;
	private String threadName;

	protected ExtendsThread(String name) {
		threadName = name;
		System.out.println("Creating " +  threadName );
	}

	@Override
	public void run() {
		
		System.out.println("Running : " +  threadName );
		
		try {
			for(int count = 1; count < 5; count++) {
				
				System.out.println("Thread: " + threadName + ", loop count:" + count);
				
				// Let the threadObject sleep for a while.
				Thread.sleep(50);
			}
		}
		catch (InterruptedException e) {
			System.out.println("Thread : " +  threadName + " interrupted.");
		}
		
		System.out.println("Thread : " +  threadName + " exiting.");
	}

	public void startThread () {
		
		System.out.println("Starting " +  threadName );
		
		if (threadObject == null) {
			threadObject = new Thread (this, threadName);
			threadObject.start ();

			System.out.println("Is Alive:      " + threadObject.isAlive());
			System.out.println("Thread id:     " + threadObject.getId());
			System.out.println("Thread Name:   " + threadObject.getName());
			System.out.println("Priority:      " + threadObject.getPriority());
			System.out.println("Hash Code:     " + threadObject.hashCode());
			System.out.println("Is Daemon:     " + threadObject.isDaemon());
			System.out.println("Is Interrupted " + threadObject.isInterrupted());
			System.out.println("State:         " + threadObject.getState());
			System.out.println("Stack Trace:   " + threadObject.getStackTrace());
			System.out.println("Thread Group:  " + threadObject.getThreadGroup());
			System.out.println("ContextClassLoader: " + threadObject.getContextClassLoader());
		}
	}
}
