package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {

    public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    class LevelSum {
	int sum;
	TreeNode node;

	LevelSum(TreeNode n, int s) {
	    node = n;
	    sum = s;
	}
    }

    public boolean hasPathSum(TreeNode root, int sum) {
	if (root == null) {
	    return false;
	}
	if (root.left == null && root.right == null) {
	    return (root.val == sum) ? true : false;
	}
	Queue<LevelSum> q = new LinkedList<LevelSum>();
	q.add(new LevelSum(root, sum));
	while (!q.isEmpty()) {
	    int size = q.size();
	    for (int i = 0; i < size; i++) {
		LevelSum curr = q.poll();
		if (curr.node.left == null && curr.node.right == null && curr.sum - curr.node.val == 0) {
		    return true;
		}
		if (curr.node.left != null)
		    q.add(new LevelSum(curr.node.left, curr.sum - curr.node.val));
		if (curr.node.right != null)
		    q.add(new LevelSum(curr.node.right, curr.sum - curr.node.val));
	    }
	}
	return false;
    }

}
