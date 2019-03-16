package leetcode;

public class SingleNumber2 {
    public int singleNumber(int[] nums) {
	if (nums == null || nums.length == 0) {
	    return 0;
	}
	int ones = 0, twos = 0;
	for (int num : nums) {
	    ones = (ones ^ num) & ~twos;
	    twos = (twos ^ num) & ~ones;
	}
	return ones;
    }
}
