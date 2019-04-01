package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeightedRandomPick {
    List<Integer> cumSum = new ArrayList<Integer>();
    int totalSum = 0;
    Random rand = new Random();

    public WeightedRandomPick(int[] w) {
	for (int weight : w) {
	    totalSum += weight;
	    cumSum.add(totalSum);
	}
    }

    public int pickIndex() {
	int randNum = rand.nextInt(totalSum);
	int low = 0;
	int high = cumSum.size() - 1;
	while (low != high) {
	    int mid = (low + high) / 2;
	    if (randNum >= cumSum.get(mid)) {
		low = mid + 1;
	    } else {
		high = mid;
	    }
	}
	return low;
    }
}
