package leetcode;

public class LongestPalindromicSubstring1 {
    public String longestPalindrome(String s) {
	if (s == null) {
	    return "";
	}
	if (s.length() <= 1) {
	    return s;
	}
	if (s.length() == 2) {
	    if (s.charAt(0) == s.charAt(1)) {
		return s;
	    } else {
		return String.valueOf(s.charAt(0));
	    }
	}
	int length = s.length();
	int max = 1;
	int start = 0;
	for (int i = 1; i < length; ++i) {

	    int low = i - 1;
	    int high = i;
	    while (low >= 0 && high < length && s.charAt(low) == s.charAt(high)) {
		if (high - low + 1 > max) {
		    start = low;
		    max = high - low + 1;
		}
		low--;
		high++;
	    }

	    low = i - 1;
	    high = i + 1;
	    while (low >= 0 && high < length && s.charAt(low) == s.charAt(high)) {
		if (high - low + 1 > max) {
		    start = low;
		    max = high - low + 1;
		}
		low--;
		high++;
	    }
	}
	return s.substring(start, start + max);
    }
}
