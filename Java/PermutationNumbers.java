package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationNumbers {

    // Time complexity : O(n * n!) There are n! permutations and n time
    // for copying it to an arrayList in the first loop
    public List<List<Integer>> permute(int[] nums) {
	List<List<Integer>> result = new ArrayList<>();
	if (nums == null || nums.length == 0) {
	    return result;
	}
	permutateHandler(0, nums, result);
	return result;
    }

    private void permutateHandler(int index, int[] nums, List<List<Integer>> result) {

	if (index == nums.length - 1) {
	    List<Integer> arr = new ArrayList<Integer>();
	    for (int j = 0; j < nums.length; j++) {
		arr.add(nums[j]);
	    }
	    result.add(arr);
	    return;
	}

	for (int i = index; i < nums.length; i++) {
	    int temp = nums[i];
	    nums[i] = nums[index];
	    nums[index] = temp;

	    permutateHandler(index + 1, nums, result);

	    temp = nums[i];
	    nums[i] = nums[index];
	    nums[index] = temp;
	}
    }

}
