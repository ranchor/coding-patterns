class Solution {
    public int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        int totalFresh = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    totalFresh++;
                }
            }
        }

        // if no fresh oranges are present
        if (totalFresh == 0)
            return 0;

        return bfs(grid, totalFresh);

    }

    int bfs(int[][] grid, int totalFresh) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new int[] { row, col });
                    visited[row][col] = true;
                }
            }
        }

        int minimumTime = -1;
        int visitedFresh = 0;
        while (!queue.isEmpty()) {

            minimumTime++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                for (int[] dir : dirs) {
                    int newRow = temp[0] + dir[0];
                    int newCol = temp[1] + dir[1];
                    if (isValid(grid, newRow, newCol, visited)) {

                        // only if it's a fresh orange
                        if (grid[newRow][newCol] == 1)
                            visitedFresh++;

                        queue.add(new int[] { newRow, newCol });
                        visited[newRow][newCol] = true;
                    }
                }
            }

        }

        return visitedFresh != totalFresh ? -1 : minimumTime;
    }

    boolean isValid(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 0
                || grid[row][col] == 2 || visited[row][col])
            return false;

        return true;
    }
}