package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
	List<Interval> result = new ArrayList<Interval>();
	if (intervals.size() == 0) {
	    return result;
	}
	if (intervals.size() == 1) {
	    result.add(intervals.get(0));
	    return result;
	}
	intervals.sort(new Comparator<Interval>() {

	    @Override
	    public int compare(Interval o1, Interval o2) {
		return Integer.compare(o1.start, o2.start);
	    }
	});
	Interval curr = intervals.get(0);
	for (Interval next : intervals) {
	    if (curr.end < next.start) {
		result.add(curr);
		curr = next;
	    } else {
		curr.end = Math.max(curr.end, next.end);
	    }
	}
	result.add(curr);
	return result;
    }
}
