class Solution {

    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return 0.0;
        }

        int sum = 0;
        int max_so_far;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max_so_far = sum;

        for (int i = k; i < nums.length; i++) {
            sum += -nums[i - k] + nums[i];
            max_so_far = Math.max(max_so_far, sum);
        }

        return (double) max_so_far / k;
    }


}