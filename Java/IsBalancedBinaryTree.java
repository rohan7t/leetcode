package leetcode;

public class IsBalancedBinaryTree {

    public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    public boolean isBalanced(TreeNode root) {
	if (root == null) {
	    return true;
	}
	int leftDepth = depth(root.left);
	int rightDepth = depth(root.right);
	if (Math.abs(leftDepth - rightDepth) > 1) {
	    return false;
	}

	return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
	if (root == null) {
	    return 0;
	}
	int leftDepth = depth(root.left);
	int rightDepth = depth(root.right);

	return 1 + Math.max(leftDepth, rightDepth);
    }

}
