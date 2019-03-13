package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class NumbOfArrow {

    public int findMinArrowShots(int[][] points) {
	if (points == null || points.length == 0) {
	    return 0;
	}
	if (points.length == 1) {
	    return 1;
	}
	int result = 0;
	Arrays.sort(points, new Comparator<int[]>() {
	    @Override
	    public int compare(int[] point1, int[] point2) {
		return Integer.compare(point1[1], point2[1]);
	    }
	});
	int end = Integer.MIN_VALUE;
	for (int[] point : points) {
	    if (end < point[0]) {
		result++;
		end = point[1];
	    }
	}
	return result;
    }
}
