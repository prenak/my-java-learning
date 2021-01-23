package com.xps.java.core.assertion;

public class Assertion {
	// To run pass -ea as JVM arg
	public static void main(String[] args) {
		
		Object conn = null;
		// 1.
		assert conn != null;
		
		// 2.
		assert conn != null : "Connection is null";
	}

}
