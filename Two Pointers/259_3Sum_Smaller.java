class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length <= 2)
            return 0;

        Arrays.sort(nums);
        int output = 0;
        for (int i = 0; i <= nums.length - 3; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int diff = target - nums[i];
            while (left < right) {
                if (nums[left] + nums[right] >= diff) {
                    right--;
                } else {
                    output += right - left;
                    left++;
                }
            }

        }

        return output;
    }
}