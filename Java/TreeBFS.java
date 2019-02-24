package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeBFS {

    public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	if (root == null) {
	    return result;
	}
	Queue<TreeNode> q = new LinkedList<TreeNode>();
	q.add(root);
	while (!q.isEmpty()) {
	    List<Integer> level = new ArrayList<Integer>();
	    int remaining = q.size();

	    for (int i = 0; i < remaining; i++) {
		TreeNode node = q.poll();

		if (node != null) {
		    level.add(node.val);
		    if (node.left != null) {
			q.add(node.left);
		    }

		    if (node.right != null) {
			q.add(node.right);
		    }
		}
	    }
	    result.add(level);
	}
	return result;

    }
}
