package leetcode;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
	int count = 0;
	int xorNum = x ^ y;
	for (int i = 0; i < 32; i++) {
	    count += (xorNum >> i) & 1;
	}
	return count;
    }
}
