class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int maxLength = 0;
        int countZeros = 0;


        while (right < nums.length) {
            if (nums[right] == 0) countZeros++;
            right++;

            // for invalid window where count of zeros greater than k contract the window
            while (countZeros > k) {
                if (nums[left++] == 0) countZeros--;
            }

            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;

    }
}