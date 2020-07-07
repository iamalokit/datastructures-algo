package com.amazon.trees;

public class BoundaryTraversal {
	Node root;
	static class Node{
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	public static void main(String[] args) {
		BoundaryTraversal tree = new BoundaryTraversal(); 
        tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
        tree.root.right = new Node(22); 
        tree.root.right.right = new Node(25); 
        tree.printBoundary(tree.root); 
	}

	private void printBoundary(Node node) {
		if(node == null) {
			return;
		}
		System.out.println(node.data + " ");
		
		printBoundaryLeft(node.left);
		
		printLeaves(node.left);
		printLeaves(node.right);
		
		printBoundaryRight(node.right);
		
	}

	private void printBoundaryRight(Node node) {
		if(node == null) {
			return;
		}
		
		if(node.right != null) {
			printBoundaryRight(node.right);
			System.out.println(node.data + " ");
		}
		
		else if(node.right != null) {
			printBoundaryLeft(node.left);
			System.out.println(node.data + " ");			
		}
	}

	private void printLeaves(Node node) {
		if(node == null)
			return;
		
		printLeaves(node.left);
		if(node.left == null && node.right == null)
			System.out.println(node.data + " ");
		
		printLeaves(node.right);
	}

	private void printBoundaryLeft(Node node) {
		if(node == null) {
			return;
		}
		
		if(node.left != null) {
			System.out.println(node.data + " ");
			printBoundaryLeft(node.left);
		}
		
		else if(node.right != null) {
			System.out.println(node.data + " ");
			printBoundaryLeft(node.right);
		}
	}
}
