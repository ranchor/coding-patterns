class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int numIslands = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, dirs);
                    numIslands++;
                }
            }
        }

        return numIslands;
    }


    void dfs(char[][] grid, int row, int col, int[][] dirs) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0')
            return;

        grid[row][col] = '0';
        for (int[] dir : dirs) {
            dfs(grid, row + dir[0], col + dir[1], dirs);
        }
    }
}