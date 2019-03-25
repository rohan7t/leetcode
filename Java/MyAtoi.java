package leetcode;

public class MyAtoi {
    public int myAtoi(String str) {
	if (str == null) {
	    return 0;
	}
	str = str.trim();
	if (str.isEmpty()) {
	    return 0;
	}
	int i = 0;
	int sign = 1;
	if (str.charAt(0) == '+' || str.charAt(0) == '-') {
	    sign = (str.charAt(0) == '-') ? -1 : 1;
	    if (str.length() <= 1 || !Character.isDigit(str.charAt(1))) {
		return 0;
	    }
	    i++;
	}
	int result = 0;
	while (i < str.length()) {
	    if (Character.isDigit(str.charAt(i))) {
		int digit = str.charAt(i) - '0';
		if (result > (Integer.MAX_VALUE - digit) / 10) {
		    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		} else {
		    result = result * 10 + digit;
		}
	    } else {
		break;
	    }
	    i++;
	}
	return result * sign;
    }
}
