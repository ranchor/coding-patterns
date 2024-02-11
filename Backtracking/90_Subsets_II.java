class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0)
            return Collections.emptyList();

        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), output);
        return output;
    }

    void backtrack(int[] nums, int start, List<Integer> tempResult, List<List<Integer>> output) {
        output.add(new ArrayList<>(tempResult));

        for (int index = start; index < nums.length; index++) {
            if (index != start && nums[index] == nums[index - 1])
                continue; // skip duplicates
            tempResult.add(nums[index]);
            backtrack(nums, index + 1, tempResult, output);
            tempResult.remove(tempResult.size() - 1);
        }
    }
}
