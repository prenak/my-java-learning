package com.xps.java.core.hashcode;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	public static void main(String[] args) {
		System.out.println(new Car().equals(new Car()));
		
		System.out.println(new Car() == new Car());
		
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		clearList(list);
		System.out.println(list);
		
		int x = 23;
		changeValue(x);
		System.out.println("Orig value: "+x);
		
		Book b = new Book();
		b.setName("Murthy");
		changeBookName(b);
		System.out.println("Book name outside: " + b.getName());
	}

	private static void changeBookName(Book b) {
		b.setName("Hari");
		System.out.println("Book inside method: "+b.getName());
		b = null;
		System.out.println("Book inside method 2: "+b);
	}

	private static void changeValue(int x) {
		x =123;
		System.out.println("X inside method: " + x);
	}

	private static void clearList(List list) {
		list = new ArrayList();
		System.out.println("List inside method: " + list);
	}
	
	
}
