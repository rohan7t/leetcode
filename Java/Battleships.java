package leetcode;

public class Battleships {
    public int countBattleships(char[][] board) {
	if (board == null || board.length == 0) {
	    return 0;
	}
	int result = 0;
	int rows = board.length;
	int cols = board[0].length;
	for (int r = 0; r < rows; r++) {
	    boolean horizCheck = false;
	    for (int c = 0; c < cols; c++) {
		if (board[r][c] == 'X') {
		    if (!horizCheck && (r == 0 || (r > 0 && board[r - 1][c] == '.'))) {
			result++;
			horizCheck = true;
		    }
		} else {
		    horizCheck = false;
		}
	    }
	}
	return result;
    }
}
