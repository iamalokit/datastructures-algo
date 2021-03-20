package com.amazon.datastructures.linkedList;


public class RearrangeLinkedList {
	Node head;
	public static void main(String[] args) {
		RearrangeLinkedList linkedList = new RearrangeLinkedList();
		linkedList.head = new Node(10);
		linkedList.head.next = new Node(5);
		linkedList.head.next.next = new Node(4);
		linkedList.head.next.next.next = new Node(3);
		linkedList.head.next.next.next.next = new Node(2);
		Node rearranged = rearrangedLinkedList(linkedList.head);
		
	}
	
	private static Node rearrangedLinkedList(Node head) {
		Node rearranged = new Node(head.data);
		Node rearrangedTemp = rearranged;
		while(head.next != null) {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			rearranged.next = new Node(temp.data);
			
			rearranged = rearranged.next;
			if(head.next != null) {
				head = head.next;
				rearranged.next = new Node(head.data);
				rearranged = rearranged.next;
			}
		}
		return rearrangedTemp;
	}

	static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}
