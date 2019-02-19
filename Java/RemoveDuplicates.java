package leetcode;

import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };
		removeDuplicates(nums);
	}

	public static int removeDuplicates(int[] nums) {
		int length = 1;
		int currentNumb = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == currentNumb) {
				continue;
			} else {
				nums[length] = nums[i];
				currentNumb = nums[i];
				length++;
			}
		}
		System.out.println(Arrays.toString(nums));
		return length;
	}

}
