package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
	if (people == null || people.length == 0) {
	    return new int[0][0];
	}
	Arrays.sort(people, new Comparator<int[]>() {
	    @Override
	    public int compare(int[] a, int[] b) {
		if (b[0] == a[0]) {
		    return a[1] - b[1];
		} else {
		    return b[0] - a[0];
		}
	    }
	});
	int[][] result = new int[people.length][2];
	for (int i = 0; i < people.length; i++) {
	    int position = people[i][1];
	    for (int j = i; j > position; j--) {
		result[j] = result[j - 1];
	    }
	    result[position] = people[i];
	}
	return result;
    }
}
