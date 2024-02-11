class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for (int index = 1; index < intervals.length; index++) {
            if (intervals[index][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals[index][1]);

        }

        return pq.size();

    }
}