package leetcode;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
	for (int i = 0; i < n; i++) {
	    int curr = nums2[i];
	    int k;
	    for (k = m + i - 1; k >= 0 && nums1[k] > curr; k--) {
		nums1[k + 1] = nums1[k];
	    }
	    nums1[k + 1] = curr;
	}
    }
}
