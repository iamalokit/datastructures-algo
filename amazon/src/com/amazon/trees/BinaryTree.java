package com.amazon.trees;

import java.util.ArrayList;
import java.util.Collections;


// incomplete code 
public class BinaryTree {
	Node root;
	private static ArrayList<Integer> arrList;
	static class Node{
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
			left = right = null;
			arrList = new ArrayList<Integer>();
		}
	}
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(2);
		tree.root.right = new Node(7);
		tree.root.left.left = new Node(8);
		tree.root.left.right = new Node(4);
		convertIntoBST(tree.root);
	}
	private static void convertIntoBST(Node root) {
		// first do the inorder traversal and store the elements in the array
		inorderTraversal(root);
		// next sort the array 
		Collections.sort(arrList);
		
		addElementsInorder(arrList);
		// next add the elements in the tree as inorder traversal
		
	}
	private static void addElementsInorder(ArrayList<Integer> arrList) {
		Node root = null;
		for(int i = 1; i < arrList.size(); i+=2) {
			if(root == null) {
				root = new Node(arrList.get(i));
			}
			root.left = new Node(arrList.get(i-1));
			root.right = new Node(arrList.get(i+1));
		}
	}
	private static ArrayList<Integer> inorderTraversal(Node node) {
		if(node == null) {
			return arrList;
		}
		inorderTraversal(node.left);
		arrList.add(node.data);
		return inorderTraversal(node.right);
		
		
	}
}
