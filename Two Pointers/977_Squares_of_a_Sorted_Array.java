class Solution {
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int left = 0, right = nums.length - 1;
        int[] output = new int[nums.length];
        // HINT: Iterate backwards
        int count = nums.length - 1;

        // nums = [-7,-3,2,3,11]
        // left = 2
        // right = 2
        // count = 1
        // output = [4, 9, 9, 49, 121]
        while (left <= right) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                output[count--] = nums[left] * nums[left];
                left++;
            } else {
                output[count--] = nums[right] * nums[right];
                right--;
            }

        }

        return output;

    }
}