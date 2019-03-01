package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class ContainsDuplicate3 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	if (nums.length == 0 || k == 0) {
	    return false;
	}
	TreeSet<Integer> set = new TreeSet<Integer>();
	Queue<Integer> q = new LinkedList<Integer>();
	for (int num : nums) {
	    Integer lowerNum = set.floor(num);
	    Integer higherNum = set.ceiling(num);
	    if (!set.isEmpty() && ((lowerNum != null && (Math.abs((double) num - lowerNum)) <= t)
		    || (higherNum != null && (Math.abs((double) num - higherNum)) <= t))) {
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
