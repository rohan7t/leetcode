package leetcode;

public class Islands {

    public static class Point {
	int x;
	int y;

	Point(int row, int col) {
	    x = row;
	    y = col;
	}

	@Override
	public String toString() {
	    return "Point [x=" + x + ", y=" + y + "]";
	}
    }

    public static void main(String[] args) {
	char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
		{ '0', '0', '0', '0', '0' } };
	char[][] grid1 = { { '1', '1', '1', '0' }, { '1', '1', '0', '0' }, { '0', '1', '0', '0' },
		{ '0', '0', '1', '0' }, { '1', '0', '0', '1' } };
	char[][] grid2 = { { '1', '1', '0' }, { '0', '0', '1' }, { '0', '1', '1' }, { '1', '1', '1' },
		{ '1', '0', '0' } };
	char[][] grid3 = { { '1', '0', '1', '1', '1' }, { '1', '0', '1', '0', '1' }, { '1', '1', '1', '0', '1' } };
	System.out.println(numIslands(grid3));
    }

    public static int numIslands(char[][] grid) {
	int count = 0;
	boolean[][] visited = new boolean[grid.length][grid[0].length];
	for (int i = 0; i < grid.length; i++) {
	    for (int j = 0; j < grid[0].length; j++) {
		if (grid[i][j] == '1') {
		    dfs(grid, new Point(i, j), visited);
		    count++;
		}
	    }
	}
	return count;
    }

    private static void dfs(char[][] grid, Point currentLocation, boolean[][] visited) {
	visited[currentLocation.x][currentLocation.y] = true;
	if (grid[currentLocation.x][currentLocation.y] == '1') {

	    if ((currentLocation.x < grid.length - 1) && !visited[currentLocation.x + 1][currentLocation.y]) {
		if (grid[currentLocation.x + 1][currentLocation.y] == '1') {
		    dfs(grid, new Point(currentLocation.x + 1, currentLocation.y), visited);
		}
	    }
	    if ((currentLocation.x > 0) && !visited[currentLocation.x - 1][currentLocation.y]) {
		if (grid[currentLocation.x - 1][currentLocation.y] == '1') {
		    dfs(grid, new Point(currentLocation.x - 1, currentLocation.y), visited);
		}
	    }
	    if ((currentLocation.y > 0) && !visited[currentLocation.x][currentLocation.y - 1]) {
		if (grid[currentLocation.x][currentLocation.y - 1] == '1') {
		    dfs(grid, new Point(currentLocation.x, currentLocation.y - 1), visited);
		}
	    }
	    if ((currentLocation.y < grid[0].length - 1) && !visited[currentLocation.x][currentLocation.y + 1]) {
		if (grid[currentLocation.x][currentLocation.y + 1] == '1') {
		    dfs(grid, new Point(currentLocation.x, currentLocation.y + 1), visited);
		}
	    }

	    grid[currentLocation.x][currentLocation.y] = '0';
	}
    }
}
