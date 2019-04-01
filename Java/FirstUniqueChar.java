package leetcode;

public class FirstUniqueChar {
    public int firstUniqChar(String s) {
	int[] count = new int[Character.MAX_VALUE - Character.MIN_VALUE];

	for (int i = 0; i < s.length(); i++) {
	    count[(int) s.charAt(i) - Character.MIN_VALUE]++;
	}

	for (int i = 0; i < s.length(); i++) {
	    if (count[(int) s.charAt(i) - Character.MIN_VALUE] == 1) {
		return i;
	    }
	}
	return -1;
    }
}
