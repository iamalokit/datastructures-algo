package com.amazon.trees;

public class TreeLeafToDll {
	Node root;
	static Node head;
	static class Node{
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		TreeLeafToDll tree = new TreeLeafToDll();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.right.right = new Node(6);
		tree.root.right.right.left = new Node(9);
		tree.root.right.right.right = new Node(10);
		tree.root.left.right = new Node(5);
		tree.root.left.left = new Node(4);
		tree.root.left.left.left = new Node(7);
		tree.root.left.left.right = new Node(8);
		tree.leavesToDll(tree.root);
		while(head.right != null) {
			System.out.println(head.data);
			head = head.right;
		}
		System.out.println(head.data);
	}

	private void leavesToDll(Node node) {
		// traverse through the leaves now
		if(node == null) {
			return;
		}
		if(node.left == null && node.right == null) {
			Node leaf = new Node(node.data);
			if(head == null)
				head = leaf;
			else {
				leaf.right = head;
				head.left = leaf;
				head = leaf;
			}
		}
		leavesToDll(node.left);
		leavesToDll(node.right);
	}

}
