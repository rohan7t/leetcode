package leetcode;

import java.util.Stack;

public class BSTIterator {
    public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
	stack = new Stack<TreeNode>();
	TreeNode curr = root;
	while (curr != null) {
	    stack.push(curr);
	    curr = curr.left;
	}
    }

    /** @return the next smallest number */
    public int next() {
	TreeNode top = stack.pop();
	TreeNode curr = top.right;
	while (curr != null) {
	    stack.push(curr);
	    curr = curr.left;
	}
	return top.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
	if (stack.size() > 0) {
	    return true;
	}
	return false;
    }
}
