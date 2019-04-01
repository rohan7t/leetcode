package leetcode;

public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] A) {
	if (A == null || A.length == 0) {
	    return A;
	}
	for (int i = 0; i < A.length; i++) {
	    reverseNInvert(A[i]);
	}
	return A;
    }

    private void reverseNInvert(int[] row) {
	if (row == null || row.length == 0) {
	    return;
	}
	int length = row.length;
	int start = 0, end = length - 1;
	while (start < end) {
	    int temp = row[start];
	    row[start] = row[end];
	    row[end] = temp;
	    row[start] = row[start] ^ 1;
	    row[end] = row[end] ^ 1;
	    start++;
	    end--;
	}
	if (length % 2 == 1) {
	    row[length / 2] = row[length / 2] ^ 1;
	}
    }
}
