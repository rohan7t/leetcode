package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
	if (k == 0 || nums.length == 0) {
	    return false;
	}
	Set<Integer> set = new HashSet<Integer>(k);
	Queue<Integer> q = new LinkedList<Integer>();
	for (int num : nums) {
	    if (set.contains(num)) {
		return true;
	    } else {
		if (set.size() < k) {
		    set.add(num);
		    q.add(num);
		} else {
		    int removeNum = q.poll();
		    set.remove(removeNum);
		    set.add(num);
		    q.add(num);
		}
	    }
	}
	return false;
    }

}
