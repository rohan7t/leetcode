package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(threeSum(nums));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		int length = nums.length;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < length - 1; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int l = i + 1;
			int r = length - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				if (sum == 0) {
					List<Integer> temp = Arrays.asList(nums[i], nums[l], nums[r]);
					result.add(temp);
					l++;
					r--;
					while (l < r && nums[l] == nums[l - 1]) {
						l++;
					}
					while (l < r && nums[r] == nums[r + 1]) {
						r--;
					}
				} else if (sum < 0) {
					l++;
				} else if (sum > 0) {
					r--;
				}
			}
		}
		return result;
	}
}
