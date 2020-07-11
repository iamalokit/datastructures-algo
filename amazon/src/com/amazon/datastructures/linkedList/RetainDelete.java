package com.amazon.datastructures.linkedList;

public class RetainDelete {
	Node head;
	static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	// 10->9->8->7->6->5->4->3->2->1
	public static void main(String[] args) {
		RetainDelete linkedList = new RetainDelete();
		linkedList.insert(10);
		linkedList.insert(9);
		linkedList.insert(8);
		linkedList.insert(7);
		linkedList.insert(6);
		linkedList.insert(5);
		linkedList.insert(4);
		linkedList.insert(3);
		linkedList.insert(2);
		linkedList.insert(1);
		int retain = 2, delete = 2;
		Node head = linkedList.retainDelete(retain, delete);
		
		while(head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	private Node retainDelete(int retain, int delete) {
		Node temp = head;
		int r = retain, d = delete;
		// handle base cases
		while(temp.next != null) {
			while(--retain > 0) {
				temp = temp.next;
			}
			
			Node delTemp = temp;
			
			while(delete-- >= 0 && delTemp != null) {
				delTemp = delTemp.next;
			}
			if(delTemp != null) {
				temp.next = delTemp;
				temp = delTemp;
			}else {
				temp.next = null;
			}
			retain = r;
			delete = d;
		}
		return head;
	}
	private void insert(int data) {
		if(head == null) {
			head = new Node(data);
		}else {
			Node node = new Node(data);
			node.next = head;
			head = node;
		}
		
	}
}
