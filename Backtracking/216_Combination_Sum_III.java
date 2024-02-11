class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), output);
        return output;
    }

    void backtrack(int k, int target, int pos, List<Integer> tempResult, List<List<Integer>> output) {
        if (target == 0 && tempResult.size() == k) {
            List<Integer> temp = new ArrayList<>(tempResult);
            output.add(temp);
            return;
        } else if (target <= 0 || tempResult.size() >= k) {
            return;
        }


        for (int i = pos; i <= 9; i++) {
            tempResult.add(i);
            backtrack(k, target - i, i + 1, tempResult, output);
            tempResult.remove(tempResult.size() - 1);
        }

    }
}