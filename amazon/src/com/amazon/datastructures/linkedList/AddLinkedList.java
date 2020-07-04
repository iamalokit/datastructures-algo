package com.amazon.datastructures.linkedList;

public class AddLinkedList {
	Node finalNumHead = null;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static void main(String[] args) {
		AddLinkedList addLinkedList = new AddLinkedList();
		Node num1Head = new Node(7);
		num1Head.next = new Node(5);
		num1Head.next.next = new Node(9);
		num1Head.next.next.next = new Node(4);
		num1Head.next.next.next.next = new Node(6);

		Node num2Head = new Node(8);
		num2Head.next = new Node(4);

		addLinkedList.addNumbers(num1Head, num2Head, 0);

		while (addLinkedList.finalNumHead != null) {
			System.out.println(addLinkedList.finalNumHead.data);
			addLinkedList.finalNumHead = addLinkedList.finalNumHead.next;

		}

	}

	private void addNumbers(Node num1Head, Node num2Head, int carry) {
		if (num1Head == null && num2Head == null) {
			return;
		}
		int sum = 0;
		// add the heads
		if(num1Head == null) {
			sum = num2Head.data + carry;
		}
		else if(num2Head == null) {
			sum = num1Head.data + carry;
		}else {
			sum = num1Head.data + num2Head.data + carry;
		}
		
		carry = 0;
		// when sum > 9 get the value for the carry
		if (sum > 9) {
			carry = (sum - (sum % 10)) / 10;
		}
		if (finalNumHead == null) {
			finalNumHead = new Node(sum % 10);
		} else {
			Node temp = finalNumHead;
			Node node = new Node(sum % 10);
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
		addNumbers(num1Head == null ? null : num1Head.next, num2Head == null ? null : num2Head.next, carry);
	}
}
