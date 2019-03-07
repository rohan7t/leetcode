package leetcode;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
	int left = 0;
	int right = nums.length - 1;
	while (left < right - 1) {
	    int mid = left + ((right - left) / 2);
	    if (nums[mid] == target) {
		return mid;
	    } else if (nums[mid] > target) {
		right = mid;
	    } else {
		left = mid;
	    }
	}

	if (target <= nums[left]) {
	    return left;
	} else if (target <= nums[right]) {
	    return right;
	}
	return right + 1;
    }
}
