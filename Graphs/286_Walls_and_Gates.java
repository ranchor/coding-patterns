class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;

        int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();


        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new Pair(i, j));
                }
            }
        }


        while (!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();
            int row = p.getKey();
            int col = p.getValue();
            for (int[] dir : DIRS) {
                int tempRow = row + dir[0];
                int tempCol = col + dir[1];
                if (tempRow < 0 || tempCol < 0 || tempRow >= rooms.length || tempCol >= rooms[0].length || rooms[tempRow][tempCol] != Integer.MAX_VALUE)
                    continue;
                rooms[tempRow][tempCol] = rooms[row][col] + 1;
                queue.add(new Pair(tempRow, tempCol));
            }
        }

    }
}