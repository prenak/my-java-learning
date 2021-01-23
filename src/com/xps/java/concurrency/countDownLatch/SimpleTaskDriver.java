package com.xps.java.concurrency.countDownLatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleTaskDriver {
	public static void main(String[] args) {
		CountDownLatch cdl = new CountDownLatch(5);
		List<Thread> threads = Stream.generate(() -> new Thread(new SimpleTask(cdl))).limit(5).collect(Collectors.toList());
		
		threads.forEach(Thread::start);
		
		try {
			System.out.println("Awaiting on CDL");
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("MAIN: All threads connected");
	}
}
