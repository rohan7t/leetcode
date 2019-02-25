package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeBFS2 {

    public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	Stack<ArrayList<Integer>> resultTemp = new Stack<ArrayList<Integer>>();
	if (root == null) {
	    return result;
	}
	if (root.left == null && root.right == null) {
	    List<Integer> rootLevel = new ArrayList<Integer>();
	    rootLevel.add(root.val);
	    result.add(rootLevel);
	    return result;
	}
	Queue<TreeNode> q = new LinkedList<TreeNode>();
	q.add(root);
	while (!q.isEmpty()) {
	    int size = q.size();
	    ArrayList<Integer> level = new ArrayList<Integer>();
	    for (int i = 0; i < size; i++) {
		TreeNode node = q.poll();
		level.add(node.val);
		if (node.left != null)
		    q.add(node.left);
		if (node.right != null)
		    q.add(node.right);
	    }
	    resultTemp.push(level);
	}
	while (!resultTemp.isEmpty()) {
	    result.add(resultTemp.pop());
	}
	return result;
    }

}
