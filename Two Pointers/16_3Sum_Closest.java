class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closetSum = 0, left, right, sum, diff, minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int index = 0; index < nums.length - 2; index++) {
            left = index + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[index] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                diff = Math.abs(target - sum);
                minDiff = Math.min(minDiff, diff);
                if (minDiff == diff) {
                    closetSum = sum;
                }
            }
        }
        return closetSum;

    }
}