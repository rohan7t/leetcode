package leetcode;

import java.util.PriorityQueue;

public class KLargestElementArray {
    public int findKthLargest(int[] nums, int k) {
	if (nums == null || nums.length == 0) {
	    return 0;
	}
	if (nums.length == 1 && k <= 1) {
	    return nums[0];
	}
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

	for (int num : nums) {
	    if (pq.size() >= k) {
		int minNum = pq.peek();
		if (num > minNum) {
		    pq.poll();
		    pq.add(num);
		}
	    } else {
		pq.add(num);
	    }
	}
	return pq.poll();
    }
}
