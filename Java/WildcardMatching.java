package leetcode;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
	if (s.isEmpty() && (p.isEmpty()) || p.matches("(\\*+)$")) {
	    return true;
	}
	if (!s.isEmpty() && p.isEmpty()) {
	    return false;
	}
	char[] sArray = s.toCharArray();
	char[] pArray = p.toCharArray();

	// replace consecutive *s in the pattern
	boolean isFirstStar = true;
	int pLength = 0;
	for (int i = 0; i < pArray.length; i++) {
	    if (pArray[i] == '*') {
		if (isFirstStar) {
		    pArray[pLength++] = pArray[i];
		    isFirstStar = false;
		}
	    } else {
		pArray[pLength++] = pArray[i];
		isFirstStar = true;
	    }
	}
	boolean T[][] = new boolean[sArray.length + 1][pLength + 1];
	T[0][0] = true;

	if (pLength > 0 && pArray[0] == '*') {
	    // For case when * is the first wildcard character in the pattern
	    T[0][1] = true;
	}

	for (int i = 1; i < T.length; i++) {
	    for (int j = 1; j < T[0].length; j++) {
		if (pArray[j - 1] == '?' || sArray[i - 1] == pArray[j - 1]) {
		    T[i][j] = T[i - 1][j - 1];
		}
		if (pArray[j - 1] == '*') {
		    T[i][j] = T[i - 1][j] || T[i][j - 1];
		}
	    }
	}

	return T[sArray.length][pLength];
    }
}
