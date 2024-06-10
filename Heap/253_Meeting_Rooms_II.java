class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);
        for (int index = 1; index < intervals.length; index++) {
            if (intervals[index][0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(intervals[index][1]);

        }

        return pq.size();

    }
}