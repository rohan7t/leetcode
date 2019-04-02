package leetcode;

public class LongestAbsoluteFile {
    public int lengthLongestPath(String input) {
	String[] paths = input.split("\n");
	int[] stack = new int[paths.length + 1];
	int maxLength = 0;
	for (String path : paths) {
	    int level = path.lastIndexOf("\t") + 1;
	    int currLength = stack[level] + path.length() - level + 1;
	    stack[level + 1] = currLength;
	    if (path.contains(".")) {
		maxLength = Math.max(maxLength, currLength - 1);
	    }
	}
	return maxLength;
    }
}
