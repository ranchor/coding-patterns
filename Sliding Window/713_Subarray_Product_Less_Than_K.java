class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return 0;

        int left = 0, right = 0;
        long prod = 1;
        int totalContSubs = 0;

        while (right < nums.length) {
            prod *= nums[right++];

             // for invalid window contract the window
            while (prod >= k) {
                prod = prod / nums[left++];
            }

            totalContSubs += (right - left);

        }

        return totalContSubs;

    }
}