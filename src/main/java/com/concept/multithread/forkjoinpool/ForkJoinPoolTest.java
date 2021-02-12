package com.concept.multithread.forkjoinpool;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolTest {


	public static void main(String... args) {

		// Creating a ForkJoinPoolTest
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		
		// You can schedule a MyRecursiveAction for execution like this
		MyRecursiveAction myRecursiveAction = new MyRecursiveAction(124);
		forkJoinPool.invoke(myRecursiveAction);

		// You can schedule a RecursiveTask like this
		MyRecursiveTask myRecursiveTask = new MyRecursiveTask(128);
		long mergedResult = forkJoinPool.invoke(myRecursiveTask);
		System.out.println("mergedResult = " + mergedResult);
	}
}