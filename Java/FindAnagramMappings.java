package leetcode;

import java.util.HashMap;

public class FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
	if (A == null || B == null || A.length == 0 || B.length == 0) {
	    return new int[0];
	}
	HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
	for (int i = 0; i < B.length; i++) {
	    countMap.put(B[i], i);
	}
	int[] result = new int[A.length];
	for (int i = 0; i < A.length; i++) {
	    result[i] = countMap.get(A[i]);
	}
	return result;
    }
}
