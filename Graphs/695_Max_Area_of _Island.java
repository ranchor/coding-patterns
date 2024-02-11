class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j, visited, dirs));
                }
            }
        }
        return maxArea;
    }


    int dfs(int[][] grid, int row, int col, boolean[][] visited, int[][] dirs) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0 || visited[row][col])
            return 0;

        visited[row][col] = true;
        int totalArea = 1;
        for (int[] dir : dirs) {
            totalArea += dfs(grid, row + dir[0], col + dir[1], visited, dirs);
        }
        return totalArea;
    }
}