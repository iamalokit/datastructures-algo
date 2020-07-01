package com.amazon.queues;

public class QueueArray {
	private int size;
	private int queue[];
	private int front;
	private int rear;
	public QueueArray(int size) {
		this.size = size;
		this.queue = new int[size];
		this.front = size-1;
		this.rear = size-1;
	}
	public static void main(String[] args) {
		QueueArray queue = new QueueArray(5);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.dequeue();
		queue.dequeue();
		System.out.println(queue.queue[queue.rear+1]);
		System.out.println(queue.queue[queue.front]);
	}
	
	private void dequeue() {
		if(!isEmpty()) {
			System.out.println("Dequeing");
			front = front - 1;
		}
		else
			System.out.println("Queue is empty");
		
	}
	private boolean isEmpty() {
		if(front == rear)
			return true;
		return false;
	}
	//property of queue is one that enters first leaves first
	private void enqueue(int data) {
		// check for edge cases
		if(!isFull()) {
			System.out.println("Enqueing " + data);
			queue[rear--] = data;
		}	
		else
			System.out.println("Cannot enqueue, will be overflowed");
	}
	private boolean isFull() {
		if(rear == -1)
			return true;
		return false;
	}
	


}
