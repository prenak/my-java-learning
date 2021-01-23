package com.xps.java.test;

public class Test {
	public static void main(String[] args) {
		try {
			badM();
			System.out.println("A");
		} catch (RuntimeException e) {
			System.out.println("B");
		} finally {
			System.out.println("C");
		}
		System.out.println("D");
	}
	
	private static void badM() {
		throw new RuntimeException();
	}

}
