package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
	if (tasks == null || tasks.length == 0) {
	    return 0;
	}
	int length = tasks.length;
	HashMap<Character, Integer> hmCount = new HashMap<Character, Integer>();
	for (int i = 0; i < length; i++) {
	    hmCount.put(tasks[i], hmCount.getOrDefault(tasks[i], 0) + 1);
	}

	PriorityQueue<Character> pq = new PriorityQueue<Character>(26, new Comparator<Character>() {
	    @Override
	    public int compare(Character ch1, Character ch2) {
		return hmCount.get(ch2) - hmCount.get(ch1);
	    }
	});
	for (char ch : hmCount.keySet()) {
	    pq.offer(ch);
	}
	int max = hmCount.get(pq.poll());
	int count = (max - 1) * n;
	while (!pq.isEmpty() && max == hmCount.get(pq.poll())) {
	    count++;
	}
	return Math.max(max + count, length);
    }
}
