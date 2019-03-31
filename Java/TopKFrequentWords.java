package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
	List<String> result = new ArrayList<String>();
	if (words == null || words.length == 0) {
	    return result;
	}
	HashMap<String, Integer> countMap = new HashMap<String, Integer>();
	for (String word : words) {
	    countMap.put(word, countMap.getOrDefault(word, 0) + 1);
	}

	PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
	    @Override
	    public int compare(String s1, String s2) {
		int s1Count = countMap.get(s1);
		int s2Count = countMap.get(s2);
		if (s1Count == s2Count) {
		    return s2.compareTo(s1);
		} else {
		    return s1Count - s2Count;
		}
	    }
	});
	for (String word : countMap.keySet()) {
	    pq.offer(word);
	    if (pq.size() > k) {
		pq.poll();
	    }
	}
	while (!pq.isEmpty()) {
	    result.add(pq.poll());
	}
	Collections.reverse(result);
	return result;
    }
}
