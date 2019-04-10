package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParanthesis {
    public List<String> removeInvalidParentheses(String s) {
	ArrayList<String> result = new ArrayList<String>();
	helper(s, result, 0, 0, new char[] { '(', ')' });
	return result;
    }

    // Remove only ')' in the first recursion. Then invert the par and reverse
    // string for unbalanced '('
    private void helper(String str, ArrayList<String> result, int prevI, int prevJ, char[] par) {
	int stack = 0;
	for (int i = prevI; i < str.length(); i++) {
	    if (str.charAt(i) == par[0])
		stack++;
	    if (str.charAt(i) == par[1])
		stack--;
	    if (stack >= 0)
		continue;
	    for (int j = prevJ; j <= i; j++) {
		if (str.charAt(j) == par[1] && (j == prevJ || str.charAt(j - 1) != par[1])) {
		    helper(str.substring(0, j) + str.substring(j + 1, str.length()), result, i, j, par);
		}
	    }
	    return;
	}
	String reversed = new StringBuilder(str).reverse().toString();
	if (par[0] == '(') {
	    helper(reversed, result, 0, 0, new char[] { ')', '(' });
	} else {
	    result.add(reversed);
	}
    }
}
