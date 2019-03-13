package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    class Interval {
	int start;
	int end;

	Interval() {
	    start = 0;
	    end = 0;
	}

	Interval(int s, int e) {
	    start = s;
	    end = e;
	}

	@Override
	public String toString() {
	    return "start: " + start + " end: " + end;
	}
    }

    public int minMeetingRooms(Interval[] intervals) {
	if (intervals == null || intervals.length == 0) {
	    return 0;
	}
	if (intervals.length == 1) {
	    return 1;
	}
	Arrays.sort(intervals, new Comparator<Interval>() {

	    @Override
	    public int compare(Interval i1, Interval i2) {
		return Integer.compare(i1.start, i2.start);
	    }

	});
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	for (Interval inter : intervals) {
	    if (pq.size() > 0) {
		if (inter.start < pq.peek()) {
		    pq.add(inter.end);
		} else {
		    pq.poll();
		    pq.add(inter.end);
		}
	    } else {
		pq.add(inter.end);
	    }
	}
	return pq.size();
    }
}
