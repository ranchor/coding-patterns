class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length <= k)
            return nums;

        HashMap<Integer, Integer> freqCounter = new HashMap<>();
        for (int num : nums) {
            freqCounter.put(num, freqCounter.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<Pair<Integer, Integer>>(
                (a, b) -> (Integer.compare(a.getValue(), b.getValue())));

        freqCounter.forEach((key, value) -> {
            minHeap.offer(new Pair(key, value));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        });

        int[] output = new int[k];
        int count = 0;
        while (minHeap.size() > 0) {
            Pair<Integer, Integer> p = minHeap.poll();
            output[count++] = p.getKey();
        }

        return output;

    }
}