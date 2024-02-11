class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int minlength = Integer.MAX_VALUE;
        int windowLeft = 0, windowRight = 0;
        int sum = 0;

        while (windowRight < nums.length) {
            sum += nums[windowRight++];
            while (sum >= target) {
                minlength = Math.min(minlength, windowRight - windowLeft);
                sum -= nums[windowLeft++];
            }

        }

        return minlength == Integer.MAX_VALUE ? 0 : minlength;

    }

}