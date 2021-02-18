package com.amazon.datastructures.linkedList;

public class RearrangeLinkedList {
	Node head;
	public static void main(String[] args) {
		RearrangeLinkedList linkedList = new RearrangeLinkedList();
		linkedList.head = new Node(1);
		linkedList.head.next = new Node(2);
		linkedList.head.next.next = new Node(3);
		linkedList.head.next.next.next = new Node(4);
		linkedList.head.next.next.next.next = new Node(5);
		linkedList.printList(linkedList.head);
		
		linkedList.rearrange(linkedList.head);
	}
	
	private void rearrange(Node node) {
		Node slow = node, fast = slow.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		Node node1 = node;
		Node node2 = slow.next;
		
		slow.next = null;
		
		node2 = reverseList(node2);
		
		node = new Node(0);
		
		Node curr = node;
		while(node1 != null || node2 != null) {
			if(node1 != null) {
				curr.next = node1;
				curr = curr.next;
				node1 = node1.next;
			}
			
			if(node2 != null) {
				curr.next = node2;
				curr = curr.next;
				node2 = node2.next;
			}
		}
		
		node = node.next;
	}

	private Node reverseList(Node node) {
		Node prev = null, curr = node, next;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;			
			curr = next;
		}
		node = prev;
		return node;
	}

	public static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	void printList(Node node) {
		
		if(node == null) {
			return;
		}
		
		while(node != null) {
			System.out.println(node.data + "->");
			node = node.next;
		}
	}
}
