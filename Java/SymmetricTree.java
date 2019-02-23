package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    public boolean isSymmetric(TreeNode root) {
	if (root == null) {
	    return true;
	}
	if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
	    return false;
	}
	Queue<TreeNode> q = new LinkedList<TreeNode>();
	q.add(root.left);
	q.add(root.right);
	while (!q.isEmpty()) {
	    TreeNode leftNode = q.remove();
	    TreeNode rightNode = q.remove();

	    if (leftNode == null && rightNode == null) {
		continue;
	    }

	    if ((leftNode == null && rightNode != null) || (leftNode != null && rightNode == null)) {
		return false;
	    }

	    if (leftNode.val != rightNode.val) {
		return false;
	    }
	    q.add(leftNode.left);
	    q.add(rightNode.right);
	    q.add(leftNode.right);
	    q.add(rightNode.left);
	}
	return true;
    }

}
