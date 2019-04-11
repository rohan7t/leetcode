package leetcode;

import java.util.HashMap;

public class ContinousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
	int sum = 0;
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	map.put(0, -1);
	for (int i = 0; i < nums.length; i++) {
	    sum += nums[i];
	    if (k != 0) {
		sum = sum % k;
	    }
	    if (map.containsKey(sum)) {
		if (i - map.get(sum) >= 2) {
		    return true;
		}
	    } else {
		map.put(sum, i);
	    }
	}
	return false;
    }
}
