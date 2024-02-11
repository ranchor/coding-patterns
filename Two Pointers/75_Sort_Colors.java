class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int low = 0, curr = 0, high = nums.length - 1;
        while (curr <= high) {
            if (nums[curr] == 0) {
                // swap low-th and curr-th elements
                // low++ and curr++
                swap(nums, curr, low);
                low++;
                curr++;
            } else if (nums[curr] == 2) {
                // swap high-th and curr-th elements
                // high--
                swap(nums, curr, high);
                high--;
            } else {
                curr++;
            }

        }

    }

    void swap(int[] nums, int i, int j) {
        if (i == j)
            return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}