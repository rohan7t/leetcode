package leetcode;

public class TrappingRainWater {
    public int trap(int[] height) {
	int result = 0;
	if (height == null || height.length == 0) {
	    return result;
	}
	int length = height.length;
	int[] maxLeft = new int[length];
	maxLeft[0] = height[0];
	int[] maxRight = new int[length];
	maxRight[length - 1] = height[length - 1];
	for (int i = 1; i < length; i++) {
	    maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
	}

	for (int i = length - 2; i >= 0; i--) {
	    maxRight[i] = Math.max(height[i], maxRight[i + 1]);
	}

	for (int i = 1; i < length - 1; i++) {
	    result += Math.min(maxLeft[i], maxRight[i]) - height[i];
	}
	return result;
    }
}
