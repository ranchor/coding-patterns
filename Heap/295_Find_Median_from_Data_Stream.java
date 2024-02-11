class MedianFinder {
    PriorityQueue<Integer> maxLowerHalf;
    PriorityQueue<Integer> minUpperHalf;

    public MedianFinder() {
        this.maxLowerHalf = new PriorityQueue<Integer>(Collections.reverseOrder());
        this.minUpperHalf = new PriorityQueue<Integer>();
    }

    // 1
    // maxHeap = [2, 1]
    // minHeap = [3]
    public void addNum(int num) {

        this.maxLowerHalf.offer(num);
        this.minUpperHalf.offer(this.maxLowerHalf.poll());

        while (this.minUpperHalf.size() > this.maxLowerHalf.size()) {
            maxLowerHalf.offer(minUpperHalf.poll());
        }

    }

    public double findMedian() {
        return maxLowerHalf.size() > minUpperHalf.size() ? maxLowerHalf.peek()
                : (((double) maxLowerHalf.peek() + minUpperHalf.peek()) * 0.5);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */