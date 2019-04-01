package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
	List<Integer> result = new ArrayList<Integer>();
	if (matrix == null || matrix.length == 0) {
	    return result;
	}
	int row = matrix.length;
	int column = matrix[0].length;
	boolean[][] visited = new boolean[row][column];
	int[] dr = { 0, 1, 0, -1 };
	int[] dc = { 1, 0, -1, 0 };
	int r = 0, c = 0, dir = 0;
	for (int i = 0; i < row * column; i++) {
	    result.add(matrix[r][c]);
	    visited[r][c] = true;
	    int nextR = r + dr[dir];
	    int nextC = c + dc[dir];
	    if (0 <= nextR && nextR < row && 0 <= nextC && nextC < column && !visited[nextR][nextC]) {
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
