package leetcode;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
	if (s == null || s.length() == 0) {
	    return 0;
	}
	int result = 0;
	int length = s.length();
	for (int center = 0; center <= 2 * length - 1; center++) {
	    int l = center / 2;
	    int r = l + center % 2;
	    while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
		result++;
		l--;
		r++;
	    }
	}
	return result;
    }
}
