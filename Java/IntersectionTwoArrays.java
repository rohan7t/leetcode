package leetcode;

import java.util.Arrays;

public class IntersectionTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;

	for (int num : nums1) {
	    min = Math.min(min, num);
	    max = Math.max(max, num);
	}

	boolean[] exists = new boolean[max - min + 1];
	for (int num : nums1) {
	    exists[num - min] = true;
	}
	int[] res = new int[nums2.length];
	int index = 0;
	for (int num : nums2) {
	    if (num >= min && num <= max && exists[num - min]) {
		res[index] = num;
		exists[num - min] = false;
		index++;
	    }
	}
	return Arrays.copyOf(res, index);
    }
}
