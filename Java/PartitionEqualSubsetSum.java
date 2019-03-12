package leetcode;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
	if (nums == null || nums.length < 2) {
	    return false;
	}
	int maxNumber = 0;
	int sum = 0;
	for (int num : nums) {
	    sum += num;
	    maxNumber = Math.max(num, maxNumber);
	}
	int half = sum / 2;
	if (sum % 2 != 0 || half < maxNumber) {
	    return false;
	}
	return canPartitionHandler(nums, nums.length - 1, half);
    }

    private boolean canPartitionHandler(int[] nums, int index, int target) {
	if (target == 0) {
	    return true;
	}
	if (target < 0 || index <= 0) {
	    return false;
	}
	return (canPartitionHandler(nums, index - 1, target - nums[index])
		|| canPartitionHandler(nums, index - 1, target));
    }
}
