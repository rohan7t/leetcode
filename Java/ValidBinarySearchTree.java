package leetcode;

public class ValidBinarySearchTree {

    class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    public boolean isValidBST(TreeNode root) {
	return BSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean BSTHelper(TreeNode node, long lowerLimit, long upperLimit) {
	if (node == null) {
	    return true;
	}
	if (node.val <= lowerLimit || node.val >= upperLimit) {
	    return false;
	}
	return BSTHelper(node.left, lowerLimit, node.val) && BSTHelper(node.right, node.val, upperLimit);
    }
}
