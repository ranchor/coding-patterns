class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // you can take primitve array here as you don't know the size of merged
        // interval array.
        List<int[]> output = new ArrayList<>();

        int[] prevInterval = intervals[0];
        for (int index = 1; index < intervals.length; index++) {
            int[] currInterval = intervals[index];

            if (currInterval[0] <= prevInterval[1]) { // Overlapping intervals, move the end if needed
                prevInterval[1] = Math.max(prevInterval[1], currInterval[1]);
            } else {
                // Disjoint intervals, add the new interval to the list
                output.add(prevInterval);
                prevInterval = currInterval;
            }
        }

        output.add(prevInterval);

        return output.toArray(new int[output.size()][2]);

    }
}