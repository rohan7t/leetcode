package leetcode;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
	if (board == null || board.length == 0) {
	    return;
	}
	int row = board.length, col = board[0].length;
	for (int r = 0; r < row; r++) {
	    for (int c = 0; c < col; c++) {
		int lives = fetchLiveNeighbors(board, row, col, r, c);
		if (board[r][c] == 1 && lives >= 2 && lives <= 3) {
		    board[r][c] = 3;
		}
		if (board[r][c] == 0 && lives == 3) {
		    board[r][c] = 2;
		}
	    }
	}

	for (int r = 0; r < row; r++) {
	    for (int c = 0; c < col; c++) {
		board[r][c] = board[r][c] >> 1;
	    }
	}
    }

    private int fetchLiveNeighbors(int[][] board, int row, int col, int r, int c) {
	int lives = 0;
	for (int i = Math.max(0, r - 1); i <= Math.min(row - 1, r + 1); i++) {
	    for (int j = Math.max(0, c - 1); j <= Math.min(col - 1, c + 1); j++) {
		lives += board[i][j] & 1;
	    }
	}
	lives -= board[r][c] & 1;
	return lives;
    }
}
