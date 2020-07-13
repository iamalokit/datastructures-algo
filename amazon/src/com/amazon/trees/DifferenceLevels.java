package com.amazon.trees;

public class DifferenceLevels {
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
		// we need tree -- not necessarily we need root of tree
		DifferenceLevels tree = new DifferenceLevels();
		tree.root = new Node(5);
		tree.root.left = new Node(2);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(4);
		tree.root.left.right.left = new Node(3);
		tree.root.right.right = new Node(8);
		tree.root.right.right.right = new Node(9);
		tree.root.right.right.left = new Node(7);
		System.out.println("The difference between the odd levels and the even levels of the tree is :-" + findDifference(tree.root));
		
	}
	private static int findDifference(Node root) {
		if(root == null) {
			return 0;
		}
		return root.data - findDifference(root.left) - findDifference(root.right);
	}
}
