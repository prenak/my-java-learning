package com.xps.java.ds.linkedList;

public class Driver {

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		System.out.println(list.toString());
		
		list.append(0);
		System.out.println(list.toString());
		
		for (int i=1; i<5; i++) {
			list.insert(i);
			System.out.println(list.toString());
		}
		
		list.append(7);
		System.out.println(list.toString());
		
		try{
			list.insertAfter(list.head.getNext(), 9);
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(list.toString());
		
		list.reverse();
		System.out.println(list.toString());
		
		list.reverse();
		System.out.println(list.toString());
		
		list.rotateClockwiseByTimes(2);
		System.out.println(list.toString());
		
		list.rotateClockwiseByTimes(10);
		System.out.println(list.toString());
		
		list.rotateClockwiseByTimes(6);
		System.out.println(list.toString());
		
		list.rotateClockwiseByTimes(14);
		System.out.println(list.toString());
		
		list.reverseInGroupsOf(3);
		System.out.println(list.toString());
		
		list.delete();
		System.out.println(list.toString());		
	}

}
