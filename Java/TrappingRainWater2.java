package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWater2 {
    class Cell {
	int row;
	int col;
	int height;

	public Cell(int x, int y, int h) {
	    row = x;
	    col = y;
	    height = h;
	}
    }

    public int trapRainWater(int[][] heightMap) {
	if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
	    return 0;
	}
	int m = heightMap.length;
	int n = heightMap[0].length;
	int result = 0;

	PriorityQueue<Cell> pq = new PriorityQueue<Cell>(1, new Comparator<Cell>() {
	    @Override
	    public int compare(Cell c1, Cell c2) {
		return c1.height - c2.height;
	    }
	});
	boolean[][] visited = new boolean[m][n];

	for (int i = 0; i < m; i++) {
	    visited[i][0] = true;
	    visited[i][n - 1] = true;
	    pq.offer(new Cell(i, 0, heightMap[i][0]));
	    pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
	}

	for (int i = 0; i < n; i++) {
	    visited[0][i] = true;
	    visited[m - 1][i] = true;
	    pq.offer(new Cell(0, i, heightMap[0][i]));
	    pq.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
	}

	int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	while (!pq.isEmpty()) {
	    Cell currentCell = pq.poll();
	    for (int[] direction : directions) {
		int row = currentCell.row + direction[0];
		int col = currentCell.col + direction[1];
		if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
		    visited[row][col] = true;
		    result += Math.max(0, currentCell.height - heightMap[row][col]);
		    pq.offer(new Cell(row, col, Math.max(currentCell.height, heightMap[row][col])));
		}
	    }
	}
	return result;
    }
}
