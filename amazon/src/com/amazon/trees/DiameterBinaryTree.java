package com.amazon.trees;

public class DiameterBinaryTree {
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
		 DiameterBinaryTree tree = new DiameterBinaryTree();
		 tree.root = new Node(1);
		 tree.root.left = new Node(2);
		 tree.root.right = new Node(3);
		 tree.root.left.left = new Node(4);
		 tree.root.left.right = new Node(5);
		 System.out.println("Diameter of the binary tree is :" + tree.diameter());
	}
	private int diameter() {
		// diameter is one of the following
		// 1. diameter of left subtree 
		// 2. diameter of right subtree
		// 3. path from the root to leaves of left subtree and right subtree
		return diameter(root);
	}
	private int diameter(Node root) {
		if(root == null) {
			return 0;
		}
		
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		
		int lDiameter = diameter(root.left);
		int rDiameter = diameter(root.right);
		return Math.max(lHeight + rHeight + 1, Math.max(lDiameter, rDiameter));
	}
	
	private int height(Node node) {
		if(node == null) {
			return 0;
		}
		return 1+ Math.max(height(node.left), height(node.right));
	}

}
