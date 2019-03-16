package leetcode;

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
	if (nums == null || nums.length == 0) {
	    return 0;
	}
	int slow = nums[0];
	int fast = nums[0];
	do {
	    slow = nums[slow];
	    fast = nums[nums[fast]];
	} while (slow != fast);
	int start = nums[0];
	int end = slow;
	while (start != end) {
	    start = nums[start];
	    end = nums[end];
	}
	return start;
    }
}
