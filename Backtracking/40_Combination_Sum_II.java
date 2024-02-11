class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return output;
        Arrays.sort(candidates);
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
            if (i != pos && candidates[i] == candidates[i - 1]) continue;
            tempResult.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, tempResult, output);
            tempResult.remove(tempResult.size() - 1);
        }
    }
}