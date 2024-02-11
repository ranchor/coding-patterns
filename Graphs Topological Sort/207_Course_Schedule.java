class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length <= 1)
            return true;

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        int[] inDegrees = new int[numCourses];

        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            graph.putIfAbsent(from, new HashSet<>());
            graph.get(from).add(to);

            inDegrees[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int index = 0; index < numCourses; index++) {
            if (inDegrees[index] == 0) {
                queue.offer(index);
            }
        }

        int visitedNodes = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visitedNodes++;

            if (!graph.containsKey(curr))
                continue;
            for (int neighbour : graph.get(curr)) {

                inDegrees[neighbour]--;
                if (inDegrees[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return visitedNodes == numCourses ? true : false;

    }
}