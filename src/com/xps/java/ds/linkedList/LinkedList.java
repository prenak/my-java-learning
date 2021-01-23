package com.xps.java.ds.linkedList;

public class LinkedList<T> {
	
	Node head;
	int size = 0;
	
	public void insert(T data) {
		Node newNode = new Node(data);
		if (this.head != null) {
			newNode.setNext(this.head);
		}
		this.head = newNode;
		this.size++; 
	}
	
	public void delete() {
		this.head = null;
		this.size = 0;
	}
	
	public void insertAfter(Node node, T data) throws Exception {
		if (node == null) {
			throw new Exception("Input node cannot be null");
		}
		Node newNode = new Node(data);
		newNode.setNext(node.next);
		node.setNext(newNode);
		this.size++;
	}
	
	public void append(T data) {
		Node newNode = new Node(data);
		if (this.head == null) {
			this.head = newNode;
			this.size++;
			return;
		}
		
		Node last = head;
		while (last.getNext() != null) {
			last = last.getNext();
		}
		last.setNext(newNode);
		this.size++;
	}
	
	public class Node {
		private T data;
		private Node next;
		
		public Node(T data) {
			super();
			this.data = data;
		}

		public T getData() {
			return data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [" + data + " -> " + (next!=null?next.data:null) + "]";
		}
		
	}
	
	public void reverse() {
		if (this.head == null)
			return;
		
		Node prev = null;
		Node next = null;
		Node curr = this.head;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		this.head = prev;
	}
	
	public void rotateClockwiseByTimes(int n) {
		n = n % size;
		if (n == 0)
			return;
		
		n = size - n;
		
		Node templast = head;
		Node tempHead = head.next;
		for (int i=1; i<n; i++) {
			templast = templast.next;
			tempHead = templast.next;
		}
		templast.next = null;
		
		Node last = tempHead;
		while (last.next != null) {
			last = last.next;
		}
		last.next = this.head;
		this.head = tempHead;
	}
	
	public void reverseInGroupsOf(int n) {
		this.head = reverseInGroups(this.head, n);
	}

	private Node reverseInGroups(Node head, int n) {
		Node curr = head;
		Node prev = null, next = null;
		
		int count = 0;
		
		while (count < n && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		if (next != null) {
			head.next = reverseInGroups(next, n);
		}
		
		return prev;
	}

	@Override
	public String toString() {
		if (this.head == null) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		Node last = head;
		do {
			sb.append(last.getData()).append(", ");
			last = last.getNext();
		} while (last != null);
		return sb.toString();
	}
}
