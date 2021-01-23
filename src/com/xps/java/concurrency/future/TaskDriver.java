package com.xps.java.concurrency.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class TaskDriver {
	public static void main(String[] args) {
		List<Future<TaskResult>> taskResults = new ArrayList<Future<TaskResult>>();
		ExecutorService es = Executors.newFixedThreadPool(5);
		IntStream.range(1, 20).forEach(i -> {
			taskResults.add(es.submit(new Task(String.valueOf(i))));
		});
		
		System.out.println("TastResults: "+taskResults.size());
		try {Thread.sleep(10);}catch(Exception e) {e.printStackTrace();}
		
		for (Future<TaskResult> f : taskResults) {
			if (f.isDone() && !f.isCancelled()) {
				try{
					System.out.println(f.get().getResult());
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			} else {
				System.out.println("Cancelling");
				f.cancel(false);
			}
		}
		
	}
}
