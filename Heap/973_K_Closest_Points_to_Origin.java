class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair<Integer, Double>> queue = new PriorityQueue<Pair<Integer, Double>>(
                (a, b) -> (Double.compare(b.getValue(), a.getValue())));
        for (int index = 0; index < points.length; index++) {
            queue.add(new Pair(index, distance(points[index][0], points[index][1])));
            while (queue.size() > k) {
                queue.poll();
            }
        }

        // Use of arraylist is not required here.
        int[][] output = new int[k][2];
        for (int index = 0; index < k; index++) {
            Pair<Integer, Double> p = queue.poll();
            int[] point = points[p.getKey()];
            output[index][0] = point[0];
            output[index][1] = point[1];
        }

        return output;
    }

    double distance(int x, int y) {
        return Math.pow((double) x, 2.0) + Math.pow((double) y, 2.0);
    }
}