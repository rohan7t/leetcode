package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
	if (nums == null || nums.length == 0) {
	    return new ArrayList<String>();
	}
	List<String> result = new ArrayList<String>();
	for (int i = 0, j = 0; j < nums.length; j++) {
	    if (j + 1 < nums.length && nums[j + 1] - nums[j] == 1) {
		continue;
	    }
	    if (i == j) {
		result.add(String.valueOf(nums[i]));
	    } else {
		result.add(nums[i] + "->" + nums[j]);
	    }
	    i = j + 1;
	}
	return result;
    }
}
