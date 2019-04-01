package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    private static final String MOD_3 = "Fizz";
    private static final String MOD_5 = "Buzz";

    public List<String> fizzBuzz(int n) {
	List<String> result = new ArrayList<String>(n);
	if (n == 0) {
	    return result;
	}
	for (int i = 1; i <= n; i++) {
	    StringBuilder sb = new StringBuilder();
	    if (i % 3 == 0) {
		sb.append(MOD_3);
	    }
	    if (i % 5 == 0) {
		sb.append(MOD_5);
	    }
	    if (sb.length() == 0) {
		result.add(String.valueOf(i));
	    } else {
		result.add(sb.toString());
	    }
	}
	return result;
    }
}
