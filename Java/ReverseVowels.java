package leetcode;

import java.util.HashSet;

public class ReverseVowels {
    private static final HashSet<Character> VOWELS;

    static {
	VOWELS = new HashSet<Character>();
	VOWELS.add('a');
	VOWELS.add('e');
	VOWELS.add('i');
	VOWELS.add('o');
	VOWELS.add('u');
	VOWELS.add('A');
	VOWELS.add('E');
	VOWELS.add('I');
	VOWELS.add('O');
	VOWELS.add('U');
    }

    public String reverseVowels(String s) {
	if (s == null || s.length() == 0) {
	    return s;
	}
	int l = 0, r = s.length() - 1;
	char[] sArray = s.toCharArray();
	while (l < r) {
	    if (!VOWELS.contains(sArray[l])) {
		l++;
	    } else if (!VOWELS.contains(sArray[r])) {
		r--;
	    } else if (VOWELS.contains(sArray[l]) && VOWELS.contains(sArray[r])) {
		char temp = sArray[l];
		sArray[l] = sArray[r];
		sArray[r] = temp;
		l++;
		r--;
	    }
	}
	return new String(sArray);
    }
}
