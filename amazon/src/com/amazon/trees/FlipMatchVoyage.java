package com.amazon.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Flip Binary Tree To Match Preorder Traversal
 * @author alokitjindal
 *
 */
public class FlipMatchVoyage {
	int vix = 0;
	List<Integer> ans = new ArrayList<Integer>();
	// given root node and the required pre order traversal
	public List<Integer> flipMatchVoyage(Node root, int[] V){
		dfs(root, V);
		return ans;
	}
	
	
	private void dfs(Node node, int[] v) {
		if(node == null || (ans.size() != 0 && ans.get(0) == -1))
			return;
		
		// comapring root node 
		if(node.data != v[vix++])
			ans = new ArrayList<Integer>(Arrays.asList(-1));
		
		else if(node.left != null && node.left.data != v[vix]) {
			ans.add(node.data);
			dfs(node.right, v);
			dfs(node.left, v);
		} else {
			dfs(node.left, v);
			dfs(node.right, v);
		}
	}
}
