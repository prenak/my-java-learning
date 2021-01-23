package com.xps.java.concurrency.executor;

public class CustomExecutorServiceDriver {
	
	public static void main(String[] args) {
		CustomExecutorService ces = new CustomExecutorService(5);
		for (int i=0; i<20; i++) {
			System.out.println("Submitting task: " + (i+1));
			ces.submit(new Task(i+1));
		}
	}

}

class Task implements Runnable {
	private int id;

	public Task(int id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + "]";
	}

	@Override
	public void run() {
		System.out.println("Task " + id + " running...");
	}
}