package com.concept.multithread.threadpool;


class WorkerThread implements Runnable {

	private String message;

	public WorkerThread(String msg) {
		this.message = msg;
	}

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName() + ": (Start) message = " + message);

		// Call process message method that sleeps the thread for 2 seconds  
		processTask();

		// Prints thread name
		System.out.println(Thread.currentThread().getName() + ": (End) message = killing thread!");
	}
	
	private void processTask() {
		
		try {
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + ": (Running) message = " + message);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}