package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    // O(2^n) as we chose to go till the depth of choice until we exhaust all the
    // possible numbers and come back.
    // Similar to DFS
    public List<List<Integer>> subsets(int[] nums) {
	List<List<Integer>> result = new ArrayList<>();
	if (nums == null || nums.length == 0) {
	    return result;
	}
	helper(result, new ArrayList<Integer>(), nums, 0);
	return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
	result.add(new ArrayList<Integer>(tempList));
	for (int i = start; i < nums.length; i++) {
	    tempList.add(nums[i]);
	    helper(result, tempList, nums, i + 1);
	    tempList.remove(tempList.size() - 1);
	}
    }
}
