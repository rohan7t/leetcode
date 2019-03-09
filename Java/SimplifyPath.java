package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {

    public String simplifyPath(String path) {
	if (path == null || path.length() == 0) {
	    return "/";
	}
	String[] paths = path.split("/");
	System.out.println(Arrays.toString(paths));
	Deque<String> stack = new LinkedList<String>();
	for (String element : paths) {
	    element.trim();
	    if (element.isEmpty() || element.equals(".")) {
		continue;
	    } else if (element.equals("..")) {
		if (!stack.isEmpty()) {
		    stack.pop();
		}
		continue;
	    } else {
		stack.push(element);
	    }
	}
	if (stack.isEmpty()) {
	    return "/";
	}
	StringBuilder sb = new StringBuilder("");
	while (!stack.isEmpty()) {
	    sb.append("/");
	    sb.append(stack.pollLast());
	}
	return sb.toString();
    }
}
