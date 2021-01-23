package com.xps.java.concurrency.executor;

import java.util.LinkedList;

public class CustomExecutorService {
	
	private final Thread[] threadPool;
	private LinkedList<Runnable> taskQueue = new LinkedList<Runnable>();
	
	public CustomExecutorService(int size) {
		this.threadPool = new Thread[size];
		for (int i=0; i<size; i++) {
			Thread wt = new Thread(new WorkerThread(i+1, taskQueue));
			threadPool[i] = wt;
			wt.start();
		}
	}
	
	public void submit(Runnable r) {
		synchronized (taskQueue) {
			taskQueue.addLast(r);
			System.out.println("Task queue size: " + taskQueue.size());
			taskQueue.notifyAll();
		}
	}
}



class WorkerThread implements Runnable {
	
	private int id;
	private LinkedList<Runnable> taskQueue;
	
	public WorkerThread(int id, LinkedList<Runnable> taskQueue) {
		super();
		this.id = id;
		this.taskQueue = taskQueue;
	}

	@Override
	public void run() {
		while(true) {
			Runnable task;
			synchronized (taskQueue) {
				while (taskQueue.isEmpty()) {
					try{taskQueue.wait();}catch(Exception ex) {System.out.println(ex);}
				}
				task = taskQueue.poll();
			}
			try{Thread.sleep(2000);}catch(Exception ex) {System.out.println(ex);}
			System.out.println("Worker " + id + " exec task " + task.toString());
			new Thread(task).start();
		}
	}
}
