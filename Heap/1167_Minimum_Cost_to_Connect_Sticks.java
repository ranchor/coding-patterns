class Solution {
    public int connectSticks(int[] sticks) {
        if (sticks == null || sticks.length <= 1)
            return 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int stick : sticks) {
            queue.offer(stick);
        }

        int cost = 0, sum;
        // [2, 4, 3]
        // queue = [17]
        // cost = 4+9+17
        while (queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();
            sum = x + y;
            cost += sum;
            queue.offer(sum);
        }

        return cost;
    }
}