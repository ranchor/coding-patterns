class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return output;
        backtrack(candidates, target, 0, new ArrayList<>(), output);
        return output;
    }

    void backtrack(int[] candidates, int target, int pos, List<Integer> tempResult, List<List<Integer>> output) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(tempResult);
            output.add(temp);
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            tempResult.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, tempResult, output);
            tempResult.remove(tempResult.size() - 1);
        }
    }
}