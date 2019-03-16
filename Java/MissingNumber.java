package leetcode;

public class MissingNumber {
    public int missingNumber(int[] nums) {
	if (nums == null || nums.length == 0) {
	    return 0;
	}
	int result = nums.length;
	for (int i = 0; i < nums.length; i++) {
	    result ^= i ^ nums[i];
	}
	return result;
    }
}
