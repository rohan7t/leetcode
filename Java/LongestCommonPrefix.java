package leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
	if (strs.length == 0) {
	    return "";
	}
	if (strs.length == 1) {
	    return strs[0];
	}
	int curr = 0;
	int noOfStrings = strs.length;
	StringBuilder sb = new StringBuilder();
	try {
	    while (true) {
		char ch = strs[0].charAt(curr);
		for (int i = 1; i < noOfStrings; i++) {
		    if (ch == strs[i].charAt(curr)) {
			continue;
		    } else {
			return sb.toString();
		    }
		}
		sb.append(ch);
		curr++;
	    }
	} catch (IndexOutOfBoundsException e) {
	    return sb.toString();
	}
    }
}
