package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMinDepth {

    public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    class NodeDepth {
	int depth;
	TreeNode node;

	NodeDepth(TreeNode nd, int x) {
	    depth = x;
	    node = nd;
	}
    }

    public int minDepth(TreeNode root) {
	if (root == null) {
	    return 0;
	}
	Queue<NodeDepth> q = new LinkedList<NodeDepth>();
	q.add(new NodeDepth(root, 1));
	while (!q.isEmpty()) {
	    NodeDepth node = q.poll();
	    int depth = node.depth;

	    if (node.node.left == null && node.node.right == null) {
		return depth;
	    }

	    if (node.node.left != null) {
		q.add(new NodeDepth(node.node.left, 1 + depth));
	    }
	    if (node.node.right != null) {
		q.add(new NodeDepth(node.node.right, 1 + depth));
	    }
	}
	return 0;
    }
}
