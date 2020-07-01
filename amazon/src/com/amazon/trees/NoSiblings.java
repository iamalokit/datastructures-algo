package com.amazon.trees;

public class NoSiblings {
	Node root;
	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
		}
	}
	public static void main(String[] args) {
		NoSiblings tree = new NoSiblings();
		tree.root = new Node(5);
		tree.root.left = new Node(4);
		tree.root.right = new Node(6);
		tree.root.right.right = new Node(7);
		tree.printNodesWithoutSiblings(tree.root);
	}
	
	private void printNodesWithoutSiblings(Node node) {
		// if there are more than one nodes for the same parent then the node has siblings
		if(node == null) {
			return;
		}
		
		if(node.left != null && node.right != null) {
			printNodesWithoutSiblings(node.left);
			printNodesWithoutSiblings(node.right);
		}
		
		else if(node.right != null) {
			System.out.println(node.right.data);
			printNodesWithoutSiblings(node.right);
		}
		
		else if(node.left != null) {
			System.out.println(node.left.data);
			printNodesWithoutSiblings(node.left);
		}
	}

}
