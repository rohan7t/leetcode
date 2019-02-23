package leetcode;

public class ValidPalindromeStr {

    public static void main(String[] args) {
	System.out.println(isPalindrome("race a car"));
	System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
	int l = 0;
	int r = s.length() - 1;
	while (l < r) {
	    char leftChar = s.charAt(l);
	    char rightChar = s.charAt(r);
	    if (Character.isSpaceChar(leftChar) || !Character.isLetterOrDigit(leftChar)) {
		l++;
		continue;
	    }
	    if (Character.isSpaceChar(rightChar) || !Character.isLetterOrDigit(rightChar)) {
		r--;
		continue;
	    }
	    if (Character.toLowerCase(leftChar) == Character.toLowerCase(rightChar)) {
		l++;
		r--;
	    } else {
		return false;
	    }
	}
	return true;
    }
}
