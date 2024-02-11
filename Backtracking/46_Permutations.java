class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        if (nums == null || nums.length == 0) return output;
        backtrack(nums, 0, output);
        return output;
    }


    void backtrack(int[] nums, int currPos, List<List<Integer>> output) {
        if (currPos >= nums.length - 1) {
            List<Integer> res = new ArrayList<>();
            for (int i : nums) {
                res.add(i);
            }
            output.add(res);
            return;
        }


        for (int i = currPos; i < nums.length; i++) {
            swap(nums, currPos, i);
            backtrack(nums, currPos + 1, output);
            swap(nums, currPos, i);
        }

    }

    void swap(int[] nums, int i, int j) {
        final int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}