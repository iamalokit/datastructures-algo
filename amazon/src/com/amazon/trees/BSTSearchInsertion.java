package com.amazon.trees;

public class BSTSearchInsertion {
	static Node root;
	static class Node{
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
		}
	}
	public static void main(String[] args) {
		BSTSearchInsertion tree = new BSTSearchInsertion();
		tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80);
        tree.inorderTraversal(root);
	}
	
	private void insert(int data) {
		root = insertRec(root, data);
		
	}

	private Node insertRec(Node root, int data) {
		if(root == null) {
			root = new Node(data);
			return root;
		}
		else if(data > root.data) {
			root.right = insertRec(root.right, data);
		}else {
			root.left = insertRec(root.left, data);
		}
		return root;
	}
	
	private void inorderTraversal(Node node){
		if(node == null) {
			return;
		}
		inorderTraversal(node.left);
		System.out.println(node.data);
		inorderTraversal(node.right);
	}
}
