package leetcode;

public class MedianTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	if (nums1 == null || nums2 == null) {
	    return 0;
	}
	if (nums1.length > nums2.length) {
	    return findMedianSortedArrays(nums2, nums1);
	}
	int result = 0;
	int x = nums1.length;
	int y = nums2.length;
	int low = 0;
	int high = x;
	while (low <= high) {
	    int xSplit = (low + high) / 2;
	    int ySplit = (x + y + 1) / 2 - xSplit;

	    int maxLeftX = (xSplit == 0) ? Integer.MIN_VALUE : nums1[xSplit - 1];
	    int minRightX = (xSplit == x) ? Integer.MAX_VALUE : nums1[xSplit];

	    int maxLeftY = (ySplit == 0) ? Integer.MIN_VALUE : nums2[ySplit - 1];
	    int minRightY = (ySplit == y) ? Integer.MAX_VALUE : nums2[ySplit];

	    if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
		if ((x + y) % 2 == 0) {
		    return ((double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2);
		} else {
		    return (double) Math.max(maxLeftX, maxLeftY);
		}
	    } else if (maxLeftX > minRightY) {
		high = xSplit - 1;
	    } else {
		low = xSplit + 1;
	    }
	}
	return result;
    }
}
