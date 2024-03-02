class Solution {
    public int numEnclaves(int[][] grid) {
        if(grid==null || grid.length<=0) return 0;

        int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1 && (i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1)) {
                    dfs(grid, i, j, DIRS);
                }   
            }
        }

        int totalMoves = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) {
                    totalMoves++;
                } 
            }
        }

        return totalMoves;
    }

    void dfs(int[][] grid, int row, int col, int[][] DIRS) {
        if(!isValid(grid, row, col)) {
            return;
        }

        grid[row][col] = 0;
        for(int[] dir: DIRS) {
            dfs(grid, row+dir[0], col+dir[1], DIRS);
        }

    }


    boolean isValid(int[][] grid, int row, int col) {
        return (row>=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col]==1);
    }
}