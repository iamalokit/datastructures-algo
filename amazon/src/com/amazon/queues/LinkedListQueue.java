package com.amazon.queues;

import java.util.LinkedList;

public class LinkedListQueue {
	Node front, rear;
	static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	public LinkedListQueue() {
		front = rear = null;
	}
	public static void main(String[] args) {
		LinkedListQueue queue = new LinkedListQueue();
		queue.enqueue(5);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.dequeue();
		
	}
	private void enqueue(int data) {
		Node node = new Node(data);
		if(rear == null) {
			rear = front = node;
			return;
		}
		rear.next = node;
		rear = node;
	}
	
	private void dequeue() {
		if(front == null)
			return;
		front = front.next;
		if(front == null)
			rear = null;
	}

}
