package leetcode;

public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
	for (int i = 0; i < s.length() / 2; i++) {
	    int j = s.length() - 1 - i;
	    if (s.charAt(i) != s.charAt(j)) {
		return palindromeRangeCheck(s, i + 1, j) || palindromeRangeCheck(s, i, j - 1);
	    }
	}
	return true;
    }

    private boolean palindromeRangeCheck(String s, int i, int j) {
	for (int k = i; k <= i + (j - i) / 2; k++) {
	    if (s.charAt(k) != s.charAt(j - k + i)) {
		return false;
	    }
	}
	return true;
    }
}
