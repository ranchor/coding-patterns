class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<List<Integer>> output = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), output);
        return output;
    }

    // nums=[1,2,3]
    // index=0
    // temp=[1, 2, 3]
    // output=[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
    void backtrack(int[] nums, int start, List<Integer> tempResult, List<List<Integer>> output) {
        output.add(new ArrayList<>(tempResult));

        for (int index = start; index < nums.length; index++) {
            tempResult.add(nums[index]);
            backtrack(nums, index + 1, tempResult, output);
            tempResult.remove(tempResult.size() - 1);
        }
    }
}