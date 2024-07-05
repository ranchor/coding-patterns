class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        // [[1,2],[1,3],[2,3],[3,4]]
        // prevInterval = [1,2]
        // currInterval = [1,3]
        int[] prevInterval = intervals[0];
        int count = 0;
        for (int index = 1; index < intervals.length; index++) {
            int[] currInterval = intervals[index];
            if (currInterval[0] < prevInterval[1]) {
                count++;
                // prevInterval[1]=Math.max(currInterval[1], prevInterval[1]);
                // Grready way of removing the interval which has larger end time.
                if (prevInterval[1] >= currInterval[1]) {
                    prevInterval = currInterval;
                }
            } else {
                // count++;
                prevInterval = currInterval;
            }
        }

        return count;

    }
}

// https://leetcode.com/company/facebook/discuss/5100905/Metaor-SWE-E4-or-NYC
// https://leetcode.com/playground/jgMgx3Su
public class Main {

    public static int findOverlappingIntervals(String[] intervals) {
        int n = intervals.length;

        // Parse intervals and store start and end times in a 2D array
        int[][] times = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] parts = intervals[i].split("-");
            int start = parseTime(parts[0]);
            int end = parseTime(parts[1]);

            // If end time is less than start time, add 24 hours to end time
            if (end < start) {
                end += 24 * 60 * 60; // 24 hours in seconds
            }

            times[i][0] = start;
            times[i][1] = end;
        }

        // Sort intervals based on start times
        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));

        int overlapCount = 1;
        int currentEnd = times[0][1];

        // Merge overlapping intervals
        for (int i = 1; i < n; i++) {
            if (times[i][0] <= currentEnd) {
                // Overlapping interval found
                currentEnd = Math.max(currentEnd, times[i][1]);
            } else {
                // No overlap, start new interval
                overlapCount++;
                currentEnd = times[i][1];
            }
        }

        return overlapCount;
    }

    // Function to parse time string and convert it into seconds
    private static int parseTime(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }

    public static void main(String[] args) {
        String[] intervals1 = {
                "10:15:00-12:10:00",
                "14:33:45-16:17:13",
                "17:54:39-18:00:00",
                "20:00:00-01:00:00",
                "22:42:17-00:13:00",
                "23:59:59-00:00:00"
        };
        System.out.println(findOverlappingIntervals(intervals1)); // Output: 3

        String[] intervals2 = {
                "12:00:00-00:00:00",
                "13:30:00-20:45:00",
                "01:00:00-09:00:00"
        };
        System.out.println(findOverlappingIntervals(intervals2)); // Output: 2

        String[] intervals3 = {
                "23:59:59-00:00:00",
                "00:00:00-00:00:00"
        };
        System.out.println(findOverlappingIntervals(intervals3)); // Output: 2
    }
}
