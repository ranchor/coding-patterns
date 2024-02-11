class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int lastUpdatedIndex = 1;

        for (int index = 1; index < nums.length; index++) {
            if (nums[index] != nums[index - 1]) {
                nums[lastUpdatedIndex++] = nums[index];
            }
        }
        return lastUpdatedIndex;
    }
}