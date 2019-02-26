package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
	if (s == null || s.isEmpty()) {
	    return 0;
	}
	if (s.length() == 1) {
	    return 1;
	}
	int length = 0;
	boolean centralOdd = false;
	HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
	for (char ch : s.toCharArray()) {
	    if (hm.containsKey(ch)) {
		hm.put(ch, (hm.get(ch) + 1));
	    } else {
		hm.put(ch, 1);
	    }
	}
	for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
	    int count = entry.getValue();
	    if (count % 2 == 0) {
		length += count;
	    } else {
		centralOdd = true;
		length += count - 1;
	    }
	}
	return (centralOdd) ? length + 1 : length;
    }

}
