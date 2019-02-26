package leetcode;

public class Sqrt {
    public int mySqrt(int x) {
	if (x == 0 || x == 1) {
	    return x;
	}
	long left = 1, right = x, result = 0;
	while (left <= right) {
	    long mid = (left + right) / 2;
	    long temp = mid * mid;
	    if (temp == x) {
		return (int) (mid);
	    } else if (temp < x) {
		left = mid + 1;
		result = mid;
	    } else {
		right = mid - 1;
	    }
	}
	return (int) (result);
    }
}
