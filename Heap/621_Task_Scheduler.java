class Solution {
    public int leastInterval(char[] tasks, int n) {

        if (n == 0)
            return tasks.length;

        HashMap<Character, Integer> freqCounter = new HashMap<>();
        for (char ch : tasks) {
            freqCounter.put(ch, freqCounter.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Pair<Character, Integer>> maxHeap = new PriorityQueue<Pair<Character, Integer>>(
                (a, b) -> (Integer.compare(b.getValue(), a.getValue())));

        freqCounter.forEach((k, v) -> {
            maxHeap.offer(new Pair(k, v));
        });

        Pair<Character, Integer> p = maxHeap.poll();
        int maxFreq = p.getValue();
        int maxIdleTime = (maxFreq - 1) * n;

        while (maxHeap.size() > 0) {
            Pair<Character, Integer> p1 = maxHeap.poll();
            maxIdleTime -= Math.min(maxFreq - 1, p1.getValue());
        }

        maxIdleTime = Math.max(0, maxIdleTime);

        return maxIdleTime + tasks.length;

    }
}