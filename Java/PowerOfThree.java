package leetcode;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
	final int maxPower = 1162261467;
	return n > 0 && maxPower % n == 0;
    }
}
