# Introduction
This pattern describes an efficient technique to deal with overlapping intervals. 
In a lot of problems involving intervals, we either need to find overlapping intervals or merge intervals if they overlap.
Given two intervals (`a` and `b`), there will be six different ways the two intervals can relate to each other:
1. `a` and `b`do not overlap
2. `a` and `b` overlap, `b` ends after `a`
3. `a` completely overlaps `b`
4. `a` and `b` overlap, `a` ends after `b`
5. `b` completly overlaps `a`
6. `a` and `b` do not overlap
Understanding the above six cases will help us in solving all intervals related problems.
![](../resources/mergeintervals.png)

**From the above diagram, the overlapping or merged interval will be equal to:**
```
    start = min(a.start, b.start)
    end = max(a.end, b.end) 
```

## Identification Strategy
* If you’re asked to produce a list with only mutually exclusive intervals
* If you hear the term “overlapping intervals”.

## Generic Template

```
  public boolean genericTemplate(int[][] intervals) {
        if (intervals.length == 0) {
            // Handle the case when there are no intervals (if needed)
            return true;
        }

        // Step 1: Sort the intervals by start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Initialize a pointer to the previous interval
        int[] prev = intervals[0];

        // Step 3: Iterate through the rest of the intervals and check for overlaps
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];

            // Step 4: Check if the current and previous intervals overlap
            if (doIntervalsOverlap(prev, current)) {
                // Step 5: Handle the overlap (implement business logic here)
                // You can modify the intervals, count overlaps, or perform other actions

                // Example: Merge overlapping intervals
                // prev[1] = Math.max(prev[1], current[1]);

                // Example: Count overlapping intervals
                // overlapCount++;

                // Example: Perform custom actions for overlapping intervals
                // CustomAction(current, prev);

            }

            // Step 6: Update the pointer to the previous interval
            prev = current;
        }

        // Step 7: Return the result (if needed)
        return $result;
    }

    private boolean doIntervalsOverlap(int[] i1, int[] i2) {
        // Define the condition for interval overlap
        // Modify this condition based on the problem's requirements
        // Example: Check if i2 starts after i1 ends (no overlap)
        return i2[0] <= i1[1];
    }

```

# Problems

# References
* https://leetcode.com/discuss/general-discussion/794725/general-pattern-for-greedy-approach-for-interval-based-problems