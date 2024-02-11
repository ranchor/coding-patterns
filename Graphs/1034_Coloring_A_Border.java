class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        if (grid == null || grid.length == 0) return grid;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, row, col, visited, grid[row][col], color);
        return grid;
    }


    /*
    color =4, row=1, col=1
     [1,1,1],
     [1,1,1],
     [1,1,1]

     [3,2,2],
     [3,1,2],
     [3,3,2]
     row=0, col=0
     [1,1],
     [1,2]
    */
    void dfs(int[][] grid, int row, int col, boolean[][] visited, int currColor, int targetColor) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != currColor || visited[row][col] == true)
            return;
        visited[row][col] = true;

        boolean border = false;
        if (row == 0 || col == 0 || row == grid.length - 1 || col == grid[0].length - 1 || grid[row - 1][col] != currColor || grid[row + 1][col] != currColor || grid[row][col - 1] != currColor || grid[row][col + 1] != currColor) {
            border = true;
        }

        dfs(grid, row + 1, col, visited, currColor, targetColor);
        dfs(grid, row - 1, col, visited, currColor, targetColor);
        dfs(grid, row, col + 1, visited, currColor, targetColor);
        dfs(grid, row, col - 1, visited, currColor, targetColor);

        if (border) {
            grid[row][col] = targetColor;
        }

    }

}