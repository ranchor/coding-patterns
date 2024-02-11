class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() <= 1)
            return true;

        boolean[] visited = new boolean[rooms.size()];
        dfsRooms(0, visited, rooms);
        for (boolean value : visited) {
            if (value == false)
                return value;
        }

        return true;
    }

    // rooms = [[1, 3],[3, 0, 1],[2],[]]
    // visited = [true, true, false, true]
    void dfsRooms(int roomNo, boolean[] visited, List<List<Integer>> rooms) {
        if (visited[roomNo])
            return;
        visited[roomNo] = true;
        List<Integer> keys = rooms.get(roomNo);
        for (int key : keys) {
            dfsRooms(key, visited, rooms);
        }
        return;
    }
}