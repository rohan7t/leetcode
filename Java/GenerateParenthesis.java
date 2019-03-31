package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
	List<String> result = new ArrayList<String>();
	if (n == 0) {
	    return result;
	}
	helper(result, 0, 0, n, "");
	return result;
    }

    private void helper(List<String> result, int open, int close, int max, String curr) {
	if (curr.length() == max * 2) {
	    result.add(curr);
	    return;
	}
	if (open < max) {
	    helper(result, open + 1, close, max, curr + "(");
	}
	if (close < open) {
	    helper(result, open, close + 1, max, curr + ")");
	}
    }
}
