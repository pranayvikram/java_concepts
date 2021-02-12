package com.concept.multithread;

public class ThreadInterruptionTest extends Thread {

	
	public static void main(String args[]) {  
		
		ThreadInterruptionTest interrupt = new ThreadInterruptionTest(); 
		
		//interrupt.test1(interrupt);
		//interrupt.test2(interrupt);
		interrupt.test3(interrupt);
	}
	
	public void run() {  
		
		// First condition
		if(this.getName().equals("test1")) {
			
			try {
				Thread.sleep(1000);  
				System.out.println("test1");  
			}
			catch(InterruptedException e) {  
				throw new RuntimeException(" Thiss Thread is interrupted..." + e);  
			}
		}
		
		// Second condition
		if(this.getName().equals("test2")) {
			
			try {  
				Thread.sleep(1000);  
				System.out.println("test2");  
			}
			catch(InterruptedException e){  
				System.out.println("Exception handled: " + e);  
			}  
			System.out.println("thread is running...");
		}
		
		// Third condition
		if(this.getName().equals("test3")) {
			
			for(int i = 1; i <= 5; i++)  {
				System.out.println(i);
			}
		}
	}  
	
	public void test1(ThreadInterruptionTest interupt) {
		 
		interupt.setName("test1");
		System.out.println("First test result");
		interupt.start();
		try {
			interupt.interrupt();  
		}
		catch(Exception e) {
			System.out.println("Exception handled " + e);
		}  
	}
	
	public void test2(ThreadInterruptionTest interupt) {
		
		interupt.setName("test2");
		interupt.start();  
		interupt.interrupt();
	}
	
	public void test3(ThreadInterruptionTest interupt) {
		
		interupt.setName("test3");
		interupt.start();  
		interupt.interrupt();
	}
}
