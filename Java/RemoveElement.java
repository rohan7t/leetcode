package leetcode;

import java.util.Arrays;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
	int length = nums.length;
	if (length == 0) {
	    return 0;
	}
	Arrays.sort(nums);
	int count = 0;
	int start = 0;
	boolean found = false;
	for (int i = 0; i < length; i++) {
	    if (nums[i] == val) {
		if (!found) {
		    found = true;
		    start = i;
		}
		count++;
	    } else if (found) {
		nums[start] = nums[i];
		start++;
	    }
	}
	return length - count;
    }

}
