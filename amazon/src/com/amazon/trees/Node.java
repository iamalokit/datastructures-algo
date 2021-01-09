package com.amazon.trees;

public class Node {
	int data; 
    Node left, right; 
    
    boolean isThreaded;
    public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
}
