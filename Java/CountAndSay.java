package leetcode;

public class CountAndSay {
    public String countAndSay(int n) {
	if (n == 1) {
	    return "1";
	}
	String prevResult = countAndSay(n - 1);
	int count = 0;
	int i = 0;
	int length = prevResult.length();
	StringBuilder sb = new StringBuilder();
	while (i < length) {
	    count++;
	    char ch = prevResult.charAt(i);
	    if (i + 1 >= length || ch != prevResult.charAt(i + 1)) {
		sb.append(count);
		sb.append(ch);
		count = 0;
	    }
	    i++;
	}
	return sb.toString();
    }
}
