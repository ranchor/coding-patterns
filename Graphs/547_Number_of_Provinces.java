class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0)
            return 0;

        int n = isConnected.length;

        boolean[] visited = new boolean[n];
        int totalProvinces = 0;
        Queue<Integer> queue = new LinkedList<>();
        // isConnected = [[1,1,0],[1,1,0],[0,0,1]]
        // index=0
        // queue = []
        for (int index = 0; index < n; index++) {
            if (visited[index])
                continue;
            visited[index] = true;
            queue.add(index);
            while (!queue.isEmpty()) {
                int row = queue.poll();
                for (int j = 0; j < n; j++) {
                    if (row == j || visited[j] == true)
                        continue;
                    if (isConnected[row][j] == 1) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
            totalProvinces++;
        }
        return totalProvinces;
    }
}