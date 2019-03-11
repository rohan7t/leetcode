package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {
	List<Integer> result = new ArrayList<Integer>();
	if (nums == null || nums.length == 0) {
	    return result;
	}
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	for (int num : nums) {
	    if (map.containsKey(num)) {
		map.put(num, map.get(num) + 1);
	    } else {
		map.put(num, 1);
	    }
	}
	PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(
		new Comparator<Map.Entry<Integer, Integer>>() {

		    @Override
		    public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
			return e2.getValue().compareTo(e1.getValue());
		    }
		});

	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	    pq.offer(entry);
	}

	while (k > 0) {
	    result.add(pq.poll().getKey());
	    k--;
	}
	return result;
    }
}
