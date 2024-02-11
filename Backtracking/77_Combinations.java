class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(n, k, 0, new ArrayList<>(), output);
        return output;
    }


    // n =4, k=2
    // temp = [1, 3], output = [[1, 2], [1, 3]]
    // i=0, pos = 0
    // i=2, pos = 1
    // pos=2
    void backtrack(int n, int k, int pos, List<Integer> tempResult, List<List<Integer>> output) {
        if (tempResult.size() == k) {
            List<Integer> temp = new ArrayList<>(tempResult);
            output.add(temp);
            return;
        }

        for (int i = pos; i < n; i++) {
            tempResult.add(i + 1);
            backtrack(n, k, i + 1, tempResult, output);
            tempResult.remove(tempResult.size() - 1);
        }
    }
}