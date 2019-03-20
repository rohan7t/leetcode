package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    // O(n!) since we have to exhaust all the permutations for the given list of
    // numbers
    public List<List<Integer>> permute(int[] nums) {
	List<List<Integer>> result = new ArrayList<>();
	if (nums == null || nums.length == 0) {
	    return result;
	}
	helper(result, new ArrayList<Integer>(), nums);
	return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
	if (tempList.size() == nums.length) {
	    result.add(new ArrayList<Integer>(tempList));
	}
	for (int i = 0; i < nums.length; i++) {
	    if (tempList.contains(nums[i])) {
		continue;
	    }
	    tempList.add(nums[i]);
	    helper(result, tempList, nums);
	    tempList.remove(tempList.size() - 1);
	}
    }
}
