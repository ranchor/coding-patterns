class Solution {
    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        List<List<String>> output = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(board, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), n, output);
        return output;
    }

    void backtrack(char[][] board, int row, Set<Integer> cols, Set<Integer> diags, Set<Integer> antiDiag, int n,
            List<List<String>> output) {
        if (row == n) {
            printBoard(board, output);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diags.contains(row - col) || antiDiag.contains(row + col))
                continue;

            board[row][col] = 'Q';
            cols.add(col);
            diags.add(row - col);
            antiDiag.add(row + col);
            backtrack(board, row + 1, cols, diags, antiDiag, n, output);
            board[row][col] = '.';
            cols.remove(col);
            diags.remove(row - col);
            antiDiag.remove(row + col);

        }

    }

    void printBoard(char[][] board, List<List<String>> output) {
        List<String> result = new ArrayList<>();
        for (int index = 0; index < board.length; index++) {
            String value = new String(board[index]);
            result.add(value);
        }
        output.add(result);
    }
}