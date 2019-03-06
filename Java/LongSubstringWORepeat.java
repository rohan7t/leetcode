package leetcode;

public class LongSubstringWORepeat {

    public int lengthOfLongestSubstring(String s) {
	if (s == null || s.isEmpty()) {
	    return 0;
	}
	if (s.length() == 1) {
	    return 1;
	}
	int[] charVisited = new int[256];
	int maxLength = 1, currLength = 1;
	for (int i = 0; i < charVisited.length; i++) {
	    charVisited[i] = -1;
	}
	charVisited[s.charAt(0)] = 0;
	for (int i = 1; i < s.length(); i++) {
	    char ch = s.charAt(i);
	    int prevIndex = charVisited[ch];

	    if (prevIndex == -1 || i - currLength > prevIndex) {
		currLength++;
	    } else {
		if (currLength > maxLength) {
		    maxLength = currLength;
		}
		currLength = i - prevIndex;
	    }
	    charVisited[ch] = i;
	}
	return Math.max(maxLength, currLength);
    }
}
