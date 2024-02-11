class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image == null || image.length == 0)
            return image;

        boolean[][] visited = new boolean[image.length][image[0].length];
        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        dfs(image, sr, sc, visited, color, image[sr][sc], dirs);
        return image;
    }

    void dfs(int[][] image, int row, int col, boolean[][] visited, int newColor, int existingColor, int[][] dirs) {

        // Base condition
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != existingColor
                || visited[row][col])
            return;

        visited[row][col] = true;
        image[row][col] = newColor;

        for (int[] dir : dirs) {
            dfs(image, row + dir[0], col + dir[1], visited, newColor, existingColor, dirs);
        }

        return;

    }
}