package leetcode;

public class ContainerWater {

    public static void main(String[] args) {
	int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7, 10 };
	System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
	int l = 0;
	int r = height.length - 1;
	int water = 0;
	while (l < r) {
	    int newWater = calculateWater(height, l, r);
	    if (newWater > water) {
		water = newWater;
	    }
	    if (height[l] > height[r]) {
		r--;
	    } else {
		l++;
	    }
	}
	return water;
    }

    private static int calculateWater(int[] height, int left, int right) {
	int topLevel = Math.min(height[left], height[right]);
	return topLevel * (right - left);
    }
}
