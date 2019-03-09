package leetcode;

public class RotatedSortedArray {
    public int search(int[] nums, int target) {
	if (nums.length == 0) {
	    return -1;
	}

	int low = 0, high = nums.length - 1;
	while (low < high) {
	    int mid = (low + high) / 2;
	    if (nums[mid] > nums[high]) {
		low = mid + 1;
	    } else {
		high = mid;
	    }
	}
	int rot = low;

	int left = 0, right = nums.length - 1;
	if (nums[rot] == target) {
	    return rot;
	}
	if (target <= nums[right]) {
	    left = rot;
	} else {
	    right = rot - 1;
	}

	while (left <= right) {
	    int mid = (left + right) / 2;
	    if (nums[mid] == target) {
		return mid;
	    } else if (nums[mid] > target) {
		right = mid - 1;
	    } else {
		left = mid + 1;
	    }
	}
	return -1;
    }
}
