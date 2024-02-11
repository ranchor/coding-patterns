class Solution {

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return true;
            
        if (board == null || board.length == 0)
            return false;

        int[][] moves = new int[][] { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, word, i, j, 0, moves))
                        return true;
                }
            }
        }
        return false;
    }

    // board
    // sb="A"
    // row=0, col=0
    // currWordIndex = 0
    // visited = {{0,0}}
    //
    boolean backtrack(char[][] board, String word, int row, int col, int currWordIndex, int[][] moves) {
        if (currWordIndex >= word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
                || word.charAt(currWordIndex) != board[row][col] || board[row][col] == '#')
            return false;

        board[row][col] = '#';

        for (int[] move : moves) {
            boolean res = backtrack(board, word, row + move[0], col + move[1], currWordIndex + 1, moves);
            if (res)
                return true;
        }

        board[row][col] = word.charAt(currWordIndex);
        return false;
    }
}