package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

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
    }

    public boolean canAttendMeetings(Interval[] intervals) {
	if (intervals == null || intervals.length == 0) {
	    return true;
	}
	int length = intervals.length;
	if (length == 1) {
	    return true;
	}
	Arrays.sort(intervals, new Comparator<Interval>() {
	    @Override
	    public int compare(Interval i1, Interval i2) {
		return Integer.compare(i1.start, i2.start);
	    }
	});
	for (int i = 0; i < length - 1; i++) {
	    if (intervals[i].end > intervals[i + 1].start) {
		return false;
	    }
	}
	return true;
    }
}
