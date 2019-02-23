package leetcode;

public class BinaryTreeDepth {

    public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    public int maxDepth(TreeNode root) {
	if (root == null) {
	    return 0;
	}
	int leftDepth = maxDepth(root.left);
	int rightDepth = maxDepth(root.right);
	return 1 + ((leftDepth > rightDepth) ? leftDepth : rightDepth);
    }
}
