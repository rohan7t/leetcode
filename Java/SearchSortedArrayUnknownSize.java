package leetcode;

public class SearchSortedArrayUnknownSize {

    // Defined class just for the sake of compiling. Actually the ArrayReader is a
    // sorted array of unknown size
    class ArrayReader {
	int randNum = 3;

	public int get(int k) {
	    return randNum;
	}
    }

    public int search(ArrayReader reader, int target) {
	int low = 0, high = Integer.MAX_VALUE;
	while (low <= high) {
	    int mid = low + (high - low) / 2;
	    int num = reader.get(mid);
	    if (num == Integer.MAX_VALUE || num > target) {
		high = mid - 1;
	    } else if (num < target) {
		low = mid + 1;
	    } else {
		return mid;
	    }
	}
	return -1;
    }
}
