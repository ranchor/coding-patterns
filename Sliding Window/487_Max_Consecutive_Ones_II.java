class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0;
        int maxLength = 0;
        int countZeros = 0;
        while (right < nums.length) {
            if (nums[right] == 0) countZeros++;

            // for invalid window contract the window
            while (countZeros > 1) {
                if (nums[left++] == 0) countZeros--;
            }

            right++;
            // update our longest sequence answer
            maxLength = Math.max(maxLength, right - left);

        }

        maxLength = Math.max(maxLength, right - left);
        return maxLength;
    }
}