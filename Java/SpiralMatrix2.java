package leetcode;

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
	if (n == 0) {
	    return null;
	}
	int[][] result = new int[n][n];
	int[] dr = { 0, 1, 0, -1 };
	int[] dc = { 1, 0, -1, 0 };
	int r = 0, c = 0, dir = 0;
	for (int i = 0; i < n * n; i++) {
	    result[r][c] = i + 1;
	    int nextR = r + dr[dir];
	    int nextC = c + dc[dir];
	    if (0 <= nextR && nextR < n && 0 <= nextC && nextC < n && result[nextR][nextC] == 0) {
		r = nextR;
		c = nextC;
	    } else {
		dir = (dir + 1) % 4;
		r += dr[dir];
		c += dc[dir];
	    }
	}
	return result;
    }
}
