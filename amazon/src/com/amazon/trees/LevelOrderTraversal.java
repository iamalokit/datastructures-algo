package com.amazon.trees;

public class LevelOrderTraversal {
	Node root;
	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	public static void main(String[] args) {
		// given a tree
		// create a tree
		LevelOrderTraversal tree = new LevelOrderTraversal();
		tree.root = new Node(3);
		tree.root.left = new Node(4);
		tree.root.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.right.right = new Node(8);
		
		// print level order traversal
		printLevelOrder(tree.root);
	}
	private static void printLevelOrder(Node root) {
		// we need to know the height of the tree
		int height = getHeight(root)-1;
		// start with the root then go on printing the level first the left and then the right
		print(root, height);
	}
	private static void print(Node node, int height) {
		if(node == null) {
			return;
		}
		System.out.println(node.data);
		print(node.left, height-1);
		print(node.right, height-1);
		
	}
	private static int getHeight(Node node) {
		// height can be tricky to calculate
		// left tree or right tree height could be greater
		// calculate height of left tree
		// calculate height of right tree
		// return the max of 2
		
		// has to be base condition
		if(node == null) {
			return 0;
		}
		
		int l = 1 + getHeight(node.left);
		int r = 1 + getHeight(node.right);
		return Math.max(l, r);
	}

}
