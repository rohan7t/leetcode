package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumber2 {
    public List<String> findStrobogrammatic(int n) {
	return helper(n, n);
    }

    private List<String> helper(int n, int length) {
	if (n == 0) {
	    return new ArrayList<String>(Arrays.asList(""));
	}
	if (n == 1) {
	    return new ArrayList<String>(Arrays.asList("8", "0", "1"));
	}
	List<String> result = new ArrayList<String>();
	List<String> lists = helper(n - 2, length);
	for (String list : lists) {
	    if (n != length) {
		result.add("0" + list + "0");
	    }
	    result.add("1" + list + "1");
	    result.add("6" + list + "9");
	    result.add("8" + list + "8");
	    result.add("9" + list + "6");
	}
	return result;
    }
}
