package com.concept.multithread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JavaThreadPoolExample {


	public static void main(String[] args) {

		// Creating a pool of 5 threads
		//ExecutorService executorService = Executors.newFixedThreadPool(5);
		ExecutorService executorService = Executors.newCachedThreadPool();
				
		for (int i = 0; i < 100; i++) {
			
			Runnable workerThread = new WorkerThread("Creating thread : " + (i + 1));
			
			// Calling execute method of ExecutorService
			executorService.execute(workerThread);
		}
		
		try {
			// Option - 1: Blocks until all tasks have completed execution after a shutdown request, 
			// or the timeout occurs, or the current thread is interrupted, whichever happens first.
			executorService.awaitTermination(10, TimeUnit.SECONDS);
			// Option - 2: It does not wait for previously submitted tasks to complete execution.
			//executor.shutdown();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		while (!executorService.isTerminated()) { 
			/* doing nothing while shutting down */  
			//System.out.println("Doing nothing while shutting down");
		}

		System.out.println("Finished all threads");
	}
}