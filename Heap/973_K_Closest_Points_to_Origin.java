class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(distance(b), distance(a)));

        for (int[] point : points) {
            pq.add(point);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] output = new int[pq.size()][2];
        int index = 0;
        while (!pq.isEmpty()) {
            int[] point = pq.poll();
            output[index][0] = point[0];
            output[index][1] = point[1];
            index++;
        }

        return output;

    }

    int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}