package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
	if (x < 0) {
	    return false;
	} else if (x >= 0 && x < 10) {
	    return true;
	}
	List<Integer> digits = new ArrayList<Integer>();
	while (x > 0) {
	    int digit = x % 10;
	    x = x / 10;
	    digits.add(digit);
	}

	int low = 0, high = digits.size() - 1;
	while (low < high) {
	    if (digits.get(low) != digits.get(high)) {
		return false;
	    }
	    low++;
	    high--;
	}
	return true;
    }
}
