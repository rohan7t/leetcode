package leetcode;

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
	if (num == null) {
	    return false;
	}
	if (num.isEmpty()) {
	    return true;
	}
	if ((num.length() == 1)) {
	    if (num.equals("1") || num.equals("0") || num.equals("8")) {
		return true;
	    }
	}
	int length = num.length();
	char first = num.charAt(0);
	char last = num.charAt(length - 1);
	if (first == last && (first == '1' || first == '0' || first == '8')) {
	    return isStrobogrammatic(num.substring(1, length - 1));
	} else if ((first == '6' && last == '9') || (first == '9' && last == '6')) {
	    return isStrobogrammatic(num.substring(1, length - 1));
	}
	return false;
    }
}
