class Solution {
    public void solve(char[][] board) {
        if(board==null || board.length<=0) return;

        int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]=='O' && (i==0 || j==0 || i==board.length-1 || j==board[0].length-1)) {
                    dfs(board, i, j, DIRS);
                }   
            }
        }

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]=='E') {
                    board[i][j] = 'O';
                } else if (board[i][j]=='O') {
                    board[i][j] = 'X';
                }
            }
        }

        return;
        
    }

    // board = [["X","X","X","X"],["X","x","O","X"],["X","X","O","X"],["X","O","X","X"]]
    // i=1, i=1
    void dfs(char[][] board, int row, int col, int[][] DIRS) {
        if(!isValid(row, col, board)) {
            return;
        }

        board[row][col] = 'E';
        for(int[] dir: DIRS) {
            dfs(board, row+dir[0], col+dir[1], DIRS);
        }

    }

    boolean isValid(int row, int col, char[][] board) {
        return row>=0 && row<board.length && col>=0 && col<board[0].length && board[row][col]=='O' ;
    }
}