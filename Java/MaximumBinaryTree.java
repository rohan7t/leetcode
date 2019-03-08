package leetcode;

public class MaximumBinaryTree {

    class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    class Max {
	int value;
	int index;

	Max(int val, int ind) {
	    value = val;
	    index = ind;
	}
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
	return constructSubTree(nums, 0, nums.length);
    }

    private TreeNode constructSubTree(int[] nums, int start, int end) {
	if (start > end) {
	    return null;
	}
	if (start == end) {
	    return new TreeNode(nums[start]);
	}
	Max max = getMax(nums, start, end);

	TreeNode root = new TreeNode(max.value);
	root.left = constructSubTree(nums, start, max.index - 1);
	root.right = constructSubTree(nums, max.index + 1, end);
	return root;
    }

    private Max getMax(int[] numsArray, int start, int end) {
	if (numsArray.length == 0) {
	    return null;
	}
	int max = numsArray[start];
	int index = start;
	for (int i = start; i < end; i++) {
	    if (numsArray[i] > max) {
		max = numsArray[i];
		index = i;
	    }
	}
	return new Max(max, index);
    }
}
