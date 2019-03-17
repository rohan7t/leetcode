package leetcode;

import java.util.HashSet;

public class SplitArrayEqualSum {
    public boolean splitArray(int[] nums) {
	if (nums.length < 7) {
	    return false;
	}
	int length = nums.length;
	int[] sum = new int[length];
	sum[0] = nums[0];
	for (int i = 1; i < length; i++) {
	    sum[i] = sum[i - 1] + nums[i];
	}

	for (int j = 3; j < length - 3; j++) {
	    HashSet<Integer> set = new HashSet<Integer>();
	    for (int i = 1; i < j - 1; i++) {
		if (sum[i - 1] == (sum[j - 1] - sum[i])) {
		    set.add(sum[i - 1]);
		}
	    }

	    for (int k = j + 2; k < length - 1; k++) {
		int sumCheck = sum[k - 1] - sum[j];
		if (((sum[length - 1] - sum[k] == sumCheck)) && set.contains(sumCheck)) {
		    return true;
		}
	    }
	}
	return false;
    }
}
