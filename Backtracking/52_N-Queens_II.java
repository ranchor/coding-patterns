class Solution {
    public int totalNQueens(int n) {

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        int solutions = backtrack(board, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), n);
        return solutions;

    }

    int backtrack(char[][] board, int row, Set<Integer> cols, Set<Integer> diags, Set<Integer> antiDiag, int n) {
        if (row == n) {
            return 1;
        }

        int solutions = 0;
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diags.contains(row - col) || antiDiag.contains(row + col))
                continue;

            board[row][col] = 'Q';
            cols.add(col);
            diags.add(row - col);
            antiDiag.add(row + col);
            solutions += backtrack(board, row + 1, cols, diags, antiDiag, n);
            board[row][col] = '.';
            cols.remove(col);
            diags.remove(row - col);
            antiDiag.remove(row + col);
        }

        return solutions;

    }
}