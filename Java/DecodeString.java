package leetcode;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
	if (s == null || s.isEmpty()) {
	    return s;
	}
	String result = "";
	Stack<String> strStack = new Stack<String>();
	Stack<Integer> countStack = new Stack<Integer>();
	int i = 0;
	while (i < s.length()) {
	    if (Character.isDigit(s.charAt(i))) {
		int count = 0;
		while (Character.isDigit(s.charAt(i))) {
		    count = 10 * count + (int) s.charAt(i) - '0';
		    i++;
		}
		countStack.push(count);
	    } else if (s.charAt(i) == '[') {
		strStack.push(result);
		result = "";
		i++;
	    } else if (s.charAt(i) == ']') {
		int repeat = countStack.pop();
		StringBuilder sb = new StringBuilder(strStack.pop());
		for (int j = 0; j < repeat; j++) {
		    sb.append(result);
		}
		result = sb.toString();
		i++;
	    } else {
		result += s.charAt(i);
		i++;
	    }
	}
	return result;
    }
}
