package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
	if (nums.length == 0 || nums.length == 1) {
	    return false;
	}
	Set<Integer> set = new HashSet<Integer>();
	for (int num : nums) {
	    if (set.contains(num)) {
		return true;
	    } else {
		set.add(num);
	    }
	}
	return false;
    }
}
