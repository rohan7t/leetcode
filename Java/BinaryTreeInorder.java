package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorder {
    class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    public List<Integer> inorderTraversal(TreeNode root) {
	Stack<TreeNode> stack = new Stack<TreeNode>();
	List<Integer> result = new ArrayList<Integer>();
	TreeNode current = root;
	while (current != null || !stack.isEmpty()) {

	    while (current != null) {
		// keep pushing nodes on the left side
		stack.push(current);
		current = current.left;
	    }

	    current = stack.pop();
	    result.add(current.val);
	    current = current.right;

	}
	return result;
    }
}
