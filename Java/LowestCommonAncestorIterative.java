package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorIterative {
    class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
	HashMap<TreeNode, TreeNode> parents = new HashMap<TreeNode, TreeNode>();

	Set<TreeNode> ancestors = new HashSet<TreeNode>();

	stack.push(root);

	while (!parents.containsKey(p) || !parents.containsKey(q)) {
	    TreeNode current = stack.pop();

	    if (current.left != null) {
		parents.put(current.left, current);
		stack.push(current.left);
	    }
	    if (current.right != null) {
		parents.put(current.right, current);
		stack.push(current.right);
	    }

	}

	while (p != null) {
	    ancestors.add(p);
	    p = parents.get(p);
	}

	while (!ancestors.contains(q)) {
	    q = parents.get(q);
	}
	return q;
    }
}
