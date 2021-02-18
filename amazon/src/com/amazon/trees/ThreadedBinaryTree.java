package com.amazon.trees;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadedBinaryTree {
	Node root;
	public static void main(String[] args) {
		ThreadedBinaryTree tree = new ThreadedBinaryTree();
		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
  
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
  
        tree.createThreaded(tree.root); 
        System.out.println("Inorder traversal of created threaded tree"); 
        tree.inOrder(tree.root); 
	}
	private void inOrder(Node node) {
		if(node == null)
			return;
		
		inOrder(node.left);
		System.out.println(node.data + " ");
		inOrder(node.right);
	}
	private void createThreaded(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		populateQueue(node, q);
		createThreadedUtil(node, q);
	}
	private void createThreadedUtil(Node node, Queue<Node> q) {
		if(node == null) {
			return;
		}
		
		if(node.left != null) {
			createThreadedUtil(node.left, q);
		}
		
		q.remove();
		
		if(node.right != null) {
			createThreadedUtil(node.right, q);
		}
		
		else {
			node.right = q.peek();
			node.isThreaded = true;
		}
	}
	private void populateQueue(Node node, Queue<Node> q) {
		if(node == null) {
			return;
		}
		if(node.left != null) {
			populateQueue(node.left, q);
		}
		q.add(node);
		if(node.right != null) {
			populateQueue(node.right, q);
		}
	}
}
