package leetcode;

public class LowestCommonAncestor {
    class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	helper(root, p, q);
	return result;
    }

    private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
	if (root == null) {
	    return false;
	}

	int left = helper(root.left, p, q) ? 1 : 0;

	int right = helper(root.right, p, q) ? 1 : 0;

	int mid = (root == p || root == q) ? 1 : 0;

	if ((mid + left + right) >= 2) {
	    result = root;
	}

	return (left + mid + right) > 0;
    }
}
