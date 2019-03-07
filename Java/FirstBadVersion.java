package leetcode;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
	int left = 0;
	int right = n;
	int mid = 0;
	while (left < right) {
	    mid = left + ((right - left) / 2);
	    if (isBadVersion(mid)) {
		right = mid;
	    } else {
		left = mid + 1;
	    }
	}
	return left;
    }

    private boolean isBadVersion(int mid) {
	// Leetcode-generated method stub
	return false;
    }
}
