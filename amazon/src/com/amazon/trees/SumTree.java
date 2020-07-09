package com.amazon.trees;

import com.amazon.trees.SumTree.Node;

public class SumTree {
	Node root;
	static class Node{
		Node left, right;
		int data;
		public Node(int data) {		
			this.data = data;
			left = right = null;
		}
	}
	public static void main(String[] args) {
		SumTree tree = new SumTree();
		tree.root = new Node(10);
		tree.root.left = new Node(-2);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(8);
		tree.root.left.right = new Node(-4);
		tree.root.right.left = new Node(7);
		tree.root.right.right = new Node(5);
		tree.findSumTree(tree.root);
		printInOrder(tree.root);
	}
	private static void printInOrder(Node node) {
		if(node == null) {
			return;
		}
		printInOrder(node.left);
		System.out.println(node.data);
		printInOrder(node.right);
	}
	private int findSumTree(Node node) {
		if(node == null) {
			return 0;
		}
		int oldValue = node.data;
		
		node.data = findSumTree(node.left) + findSumTree(node.right);
		
		return node.data + oldValue;
	}
}
