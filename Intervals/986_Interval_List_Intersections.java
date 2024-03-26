class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        if (firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0) {
            return new int[0][];
        }

        int i = 0;
        int j = 0;
        List<int[]> output = new ArrayList<>();
        // firstList = [[0,2],[5,10],[13,23],[24,25]], secondList =
        // [[1,5],[8,12],[15,24],[25,26]]
        // i=3
        // j=3
        // left=15
        // right=23
        // output= [[1,2],[5, 5], [8, 10], [15, 23], [24, 24], [25, 25]]
        while (i < firstList.length && j < secondList.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int left = Math.max(firstList[i][0], secondList[j][0]);
            int right = Math.min(firstList[i][1], secondList[j][1]);
            if (left <= right) {
                output.add(new int[] { left, right });
            }
            // Remove the interval with the smallest endpoint
            if (firstList[i][1] == right) {
                i++;
            } else {
                j++;
            }
        }

        return output.toArray(new int[output.size()][]);

    }
}