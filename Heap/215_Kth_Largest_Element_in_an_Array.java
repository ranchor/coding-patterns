class Solution {
    public int findKthLargest(int[] nums, int k) {
        // min-heap
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        /*
         * queue = [5, 6]
         */
        // keep k largest elements in the heap
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();

    }
}