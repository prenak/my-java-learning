package com.xps.java.concurrency.future;

import java.util.concurrent.Callable;

public class Task implements Callable<TaskResult>{
	
	String id;
	
	public Task(String id) {
		this.id = id;
	}
	
	@Override
	public TaskResult call() throws Exception {
		System.out.println("Executing task " + id);
		TaskResult tr = new TaskResult();
		try {Thread.sleep(5);}catch(Exception e) {e.printStackTrace();}
		tr.setResult("Task " + id + " completed");
		return tr;
	}

}
