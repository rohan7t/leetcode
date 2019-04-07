package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class Skyline {
    public List<int[]> getSkyline(int[][] buildings) {
	List<int[]> result = new ArrayList<int[]>();
	// To store {building-start/end, building-height}
	List<int[]> heights = new ArrayList<int[]>();

	for (int[] building : buildings) {
	    // Mark height as negative for starting of a building
	    heights.add(new int[] { building[0], -building[2] });
	    // Store actual height for ending of a building
	    heights.add(new int[] { building[1], building[2] });
	}

	Collections.sort(heights, new Comparator<int[]>() {
	    // i. When the two points are not equal then sort them by coordinate values.
	    // ii. When two coordinate values are same, then check
	    // a. if both of them are start/left coordinates. If so, consider the largest
	    // height. (That's why left coordinate heights are marked negative).
	    // b. if both of them are end/right coordinates. If so, consider the shortest
	    // height.
	    // c. If one of them is end/right and other is start/left then consider the
	    // start/left height.
	    @Override
	    public int compare(int[] a, int[] b) {
		if (a[0] == b[0]) {
		    return a[1] - b[1];
		}
		return a[0] - b[0];
	    }
	});

	// To store key: height, value: count of this height
	// Sorted according to the height
	TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
	map.put(0, 1);
	int prev = 0;
	for (int[] height : heights) {
	    if (height[1] < 0) {
		map.put(-height[1], map.getOrDefault(-height[1], 0) + 1);
	    } else {
		int count = map.get(height[1]);
		if (count - 1 == 0) {
		    map.remove(height[1]);
		} else {
		    map.put(height[1], --count);
		}
	    }
	    int currMax = map.lastKey();
	    // If max (height) has changed, then add it to the result list with current X
	    // coordinate
	    if (prev != currMax) {
		result.add(new int[] { height[0], currMax });
		prev = currMax;
	    }
	}
	return result;
    }
}
