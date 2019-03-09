package leetcode;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
	if (s.length() != t.length()) {
	    return false;
	}
	int[] alphas = new int[26];
	for (int ch : s.toCharArray()) {
	    alphas[ch - 'a']++;
	}
	for (int ch : t.toCharArray()) {
	    alphas[ch - 'a']--;
	}

	for (int i : alphas) {
	    if (i != 0) {
		return false;
	    }
	}
	return true;
    }
}
