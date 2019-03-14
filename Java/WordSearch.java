package leetcode;

public class WordSearch {
    int height;
    int width;

    public boolean exist(char[][] board, String word) {
	if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || word == null
		|| word.isEmpty()) {
	    return false;
	}
	height = board.length;
	width = board[0].length;
	boolean[][] visited = new boolean[height][width];

	char[] wordArr = word.toCharArray();
	for (int i = 0; i < height; i++) {
	    for (int j = 0; j < width; j++) {
		if (dfs(board, wordArr, visited, 0, i, j)) {
		    return true;
		}
	    }
	}
	return false;
    }

    private boolean dfs(char[][] board, char[] word, boolean[][] visited, int searchIndex, int h, int w) {
	if (h < 0 || h >= height || w < 0 || w >= width || visited[h][w]) {
	    return false;
	}

	if (word[searchIndex] == board[h][w]) {
	    if (searchIndex == word.length - 1) {
		return true;
	    }
	    visited[h][w] = true;
	    if (dfs(board, word, visited, searchIndex + 1, h + 1, w)
		    || dfs(board, word, visited, searchIndex + 1, h, w + 1)
		    || dfs(board, word, visited, searchIndex + 1, h - 1, w)
		    || dfs(board, word, visited, searchIndex + 1, h, w - 1)) {
		return true;
	    }
	    visited[h][w] = false;
	}
	return false;
    }
}
