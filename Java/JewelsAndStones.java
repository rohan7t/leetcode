package leetcode;

import java.util.HashSet;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
	if (J == null || S == null || J.isEmpty() || S.isEmpty()) {
	    return 0;
	}
	int result = 0;
	HashSet<Character> jewels = new HashSet<Character>();
	for (char ch : J.toCharArray()) {
	    jewels.add(ch);
	}
	for (char ch : S.toCharArray()) {
	    if (jewels.contains(ch)) {
		result++;
	    }
	}
	return result;
    }
}
