package leetcode;

import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
	if (s == null) {
	    return false;
	}
	if (wordDict == null || wordDict.isEmpty()) {
	    return false;
	}
	int length = s.length();
	HashSet<String> set = new HashSet<String>(wordDict);

	boolean[] dp = new boolean[length + 1];
	dp[0] = true;
	for (int i = 1; i <= length; i++) {
	    for (int j = 0; j < i; j++) {
		String sub = s.substring(j, i);
		if (dp[j] && set.contains(sub)) {
		    dp[i] = true;
		}
	    }
	}
	return dp[length];
    }
}
