package com.xps.java.concurrency.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class SimpleTask implements Runnable {

	private static volatile int  c = 0;
	
	private int id;
	private CountDownLatch countDownLatch;
	
	public SimpleTask(CountDownLatch countDownLatch) {
		super();
		this.id = ++c;
		this.countDownLatch = countDownLatch;
		System.out.println("Created thread " + id);
	}
	
	@Override
	public void run() {
		System.out.println("Thread "+id+" connecting to zk node...");
		try {Thread.sleep(id*2*1000);}catch(Exception e) {e.printStackTrace();}
		System.out.println("Thread "+id+" connected ####");
		countDownLatch.countDown();
	}

}
