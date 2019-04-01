package leetcode;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
	if (grid == null || grid.length == 0) {
	    return 0;
	}
	int result = 0;
	for (int i = 0; i < grid.length; i++) {
	    for (int j = 0; j < grid[0].length; j++) {
		if (grid[i][j] == 1) {
		    result += blockedSides(grid, i, j);
		}
	    }
	}
	return result;
    }

    private int blockedSides(int[][] grid, int i, int j) {
	int sides = 0;
	if (i == 0 || grid[i - 1][j] == 0) {
	    sides++;
	}
	if (i == grid.length - 1 || grid[i + 1][j] == 0) {
	    sides++;
	}
	if (j == 0 || grid[i][j - 1] == 0) {
	    sides++;
	}
	if (j == grid[0].length - 1 || grid[i][j + 1] == 0) {
	    sides++;
	}
	return sides;
    }
}
