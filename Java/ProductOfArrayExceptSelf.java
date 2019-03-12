package leetcode;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
	if (nums == null || nums.length == 0) {
	    return null;
	}
	if (nums.length == 1) {
	    return nums;
	}
	int length = nums.length;
	int totalProduct = 1;
	int zeroCount = 0;
	int zeroIndex = 0;
	for (int i = 0; i < length; i++) {
	    int number = nums[i];
	    if (number == 0) {
		zeroIndex = i;
		zeroCount++;
	    } else {
		totalProduct = totalProduct * number;
	    }
	}
	if (zeroCount > 1) {
	    return new int[length];
	}
	int[] result = new int[length];
	if (zeroCount == 1) {
	    result[zeroIndex] = totalProduct;
	    return result;
	}
	for (int i = 0; i < length; i++) {
	    int number = nums[i];
	    if (number == 0) {
		result[i] = totalProduct;
	    } else {
		result[i] = totalProduct / number;
	    }
	}
	return result;
    }
}
