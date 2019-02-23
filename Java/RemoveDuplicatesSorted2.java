package leetcode;

public class RemoveDuplicatesSorted2 {

    public static void main(String[] args) {
	int[] input = { 1, 1, 1, 1, 2, 2, 3, 3 };
	System.out.println(removeDuplicates(input));
    }

    public static int removeDuplicates(int[] nums) {
	if (nums.length == 0) {
	    return 0;
	}
	if (nums.length == 1) {
	    return 1;
	}
	if (nums.length == 2) {
	    return 2;
	}
	int length = 1;
	int currentNumb = nums[0];
	boolean flag = false;
	for (int i = 1; i < nums.length; i++) {
	    if (nums[i] < currentNumb) {
		continue;
	    }
	    if (nums[i] == currentNumb) {
		if (!flag) {
		    flag = true;
		    nums[length] = nums[i];
		    length++;
		} else {
		    continue;
		}
	    } else {
		flag = false;
		nums[length] = nums[i];
		currentNumb = nums[i];
		length++;
	    }
	}
	if (flag) {
	    nums[length - 1] = currentNumb;
	}
	return length;
    }

}
