package leetcode;

public class PlusOne {
    public int[] plusOne(int[] digits) {
	if (digits.length == 0) {
	    digits = new int[1];
	    digits[0] = 1;
	    return digits;
	}
	int length = digits.length - 1;
	if (digits[length] < 9) {
	    digits[length]++;
	    return digits;
	}
	int carry = 1;
	for (int i = length; i >= 0; i--) {
	    int sum = digits[i] + carry;

	    if (sum % 10 == 0) {
		digits[i] = 0;
		carry = 1;
	    } else {
		digits[i] = sum;
		carry = 0;
		break;
	    }
	}
	if (carry == 1) {
	    digits = new int[length + 2];
	    digits[0] = carry;
	}
	return digits;
    }
}
