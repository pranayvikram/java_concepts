package com.concept.multithread;

public class MultiThreadTest {

	public static void main(String args[]) {
		
		
		MultiThreadTest multiTest = new MultiThreadTest();
		
		//multiTest.testExtendsThread();

		//multiTest.testImplementsRunnable();
		multiTest.testImplementsRunnableWithJoin();
	}

	
	public void testExtendsThread() {
		ExtendsThread threadInstance1 = new ExtendsThread("Thread-1");
		threadInstance1.startThread();

		ExtendsThread threadInstance2 = new ExtendsThread("Thread-2");
		threadInstance2.startThread();
	}
	
	public void testImplementsRunnable() {
		ImplementsRunnable runnableInstance1 = new ImplementsRunnable("Thread-1");
		runnableInstance1.startThread();

		ImplementsRunnable runnableInstance2 = new ImplementsRunnable("Thread-2");
		runnableInstance2.startThread();
	}

	public void testImplementsRunnableWithJoin() {
		try {
			ImplementsRunnable runnableInstance1 = new ImplementsRunnable("Thread-1");
			runnableInstance1.startThread();
			Thread t1 = runnableInstance1.getThreadObject();
			t1.join();
			
			ImplementsRunnable runnableInstance2 = new ImplementsRunnable("Thread-2");
			runnableInstance2.startThread();
			Thread t2 = runnableInstance2.getThreadObject();
			
			System.out.println("T1: " + t1.isAlive());
			System.out.println("T2: " + t2.isAlive());
			
			t2.join();
			
			System.out.println("T1: " + t1.isAlive());
			System.out.println("T2: " + t2.isAlive());
			
		} catch (Exception ex) {
			System.out.println("ERROR!!" + ex);
		}
	}
}


/*
 *  
 	******************************************************************************************************	
 	Invoked on a particular Thread object
	******************************************************************************************************
	
	1. public void start()
 	Starts the thread in a separate path of execution, then invokes the run() method on this Thread object.
	
	2. public void run()
	If this Thread object was instantiated using a separate Runnable targetVertex, the run() method is invoked on that Runnable object.
	
	3. public final void setName(String name)
	Changes the name of the Thread object. There is also a getName() method for retrieving the name.
	
	4. public final void setPriority(int priority)
	Sets the priority of this Thread object. The possible values are between 1 and 10.
	
	5. public final void setDaemon(boolean on)
	A parameter of true denotes this Thread as a daemon thread.
	
	6. public final void join(long mili sec)
	The current thread invokes this method on a second thread, causing the current thread to block until the second thread terminates or the specified number of milliseconds passes.
	
	7. public void interrupt()
	Interrupts this thread, causing it to continue execution if it was blocked for any reason.
	
	8. public final boolean isAlive()
	Returns true if the thread is alive, which is any time after the thread has been started but before it runs to completion.
	
	
	
	*****************************************************************************************************
	Invoking one of the static methods performs the operation on the currently running thread.
	*****************************************************************************************************
	
	1. public static void yield()
	Causes the currently running thread to yield to any other threads of the same priority that are waiting to be scheduled.
	
	2. public static void sleep(long millisec)
	Causes the currently running thread to block for at least the specified number of milliseconds.
	
	3. public static boolean holdsLock(Object x)
	Returns true if the current thread holds the lock on the given Object.
	
	4. public static Thread currentThread()
	Returns a reference to the currently running thread, which is the thread that invokes this method.
	
	5. public static void dumpStack()
	
	Prints the stack trace for the currently running thread, which is useful when debugging a multithreaded application.

	 * 
	 * 
	 */
	