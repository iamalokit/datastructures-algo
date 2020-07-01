package com.amazon.trees;

import java.util.LinkedList;
import java.util.Queue;

import com.amazon.trees.LevelOrderTraversal.Node;

public class LevelOrderTraversalQueue {
	Node root;
	public static void main(String[] args) {
		LevelOrderTraversal tree = new LevelOrderTraversal();
		tree.root = new Node(3);
		tree.root.left = new Node(4);
		tree.root.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.right.right = new Node(8);
		printLevelOrder(tree.root);
	}
	private static void printLevelOrder(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.println(tempNode.data);
			
			if(tempNode.left != null) {
				queue.add(tempNode.left);
			}
			
			if(tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}
	
}
