package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {

    // O(2^n) as we chose to go till the depth of choice until we exhaust all the
    // possible numbers and come back. (a small twist of not choosing the
    // consecutive same numbers)
    // Similar to DFS
    public List<List<Integer>> subsetsWithDup(int[] nums) {
	List<List<Integer>> result = new ArrayList<>();
	if (nums == null || nums.length == 0) {
	    return result;
	}
	Arrays.sort(nums);
	helper(result, new ArrayList<Integer>(), nums, 0);
	return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
	result.add(new ArrayList<Integer>(tempList));
	for (int i = start; i < nums.length; i++) {
	    if (i > start && nums[i] == nums[i - 1]) {
		continue;
	    }
	    tempList.add(nums[i]);
	    helper(result, tempList, nums, i + 1);
	    tempList.remove(tempList.size() - 1);
	}
    }
}
