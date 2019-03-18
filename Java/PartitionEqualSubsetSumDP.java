package leetcode;

public class PartitionEqualSubsetSumDP {
    public boolean canPartition(int[] nums) {
	if (nums == null || nums.length == 0) {
	    return false;
	}
	int sum = 0;
	int maxNum = Integer.MIN_VALUE;
	for (int num : nums) {
	    sum += num;
	    if (num > maxNum) {
		maxNum = num;
	    }
	}

	if (sum % 2 == 1) {
	    // Since odd number cannot be divided equally
	    return false;
	}
	int target = sum / 2;
	if (maxNum > target) {
	    // array cannot be split since the max number is greater than the half of total
	    // sum
	    return false;
	}
	boolean[] dp = new boolean[target + 1];
	dp[0] = true;
	for (int num : nums) {
	    for (int i = target; i > 0; i--) {
		if (i >= num) {
		    dp[i] = dp[i] || dp[i - num];
		}
	    }
	}
	return dp[target];
    }
}
